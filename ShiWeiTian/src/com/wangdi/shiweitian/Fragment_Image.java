package com.wangdi.shiweitian;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.wangdi.shiweitian.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class Fragment_Image extends Fragment implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{
    ListView lv_image;
    List<Map<String,Object>> list_image;
    SimpleAdapter sa_image;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.released_view2,container,false);
        lv_image= (ListView) view.findViewById(R.id.lv_image);
        list_image=new ArrayList<Map<String,Object>>();
        String[] from_i={"tx_image","biaoti_image","jianjie_image"};
        int[] to_i={R.id.tx_image,R.id.biaoti_image,R.id.jianjie_image};
        sa_image=new SimpleAdapter(getActivity(),list_image,R.layout.released_fm2,from_i,to_i);
        getData_video();
        lv_image.setAdapter(sa_image);
        lv_image.setOnItemClickListener(this);
        lv_image.setOnScrollListener(this);
        return view;
    }

    public void getData_video(){
        for (int i = 0; i <10 ; i++) {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("tx_image",R.drawable.ic_launcher);
            map.put("biaoti_image","三鲜金鱼蒸饺");
            map.put("jianjie_image","为宝宝补充铁元素，促进宝宝的视力发育和上皮组织生长");
            list_image.add(map);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final TextView biaoti_image = (TextView) view.findViewById(R.id.biaoti_image);
        final TextView jianjie_image = (TextView) view.findViewById(R.id.jianjie_image);
        final String str=biaoti_image.getText().toString();
        final int a=i;
        TextView delete = (TextView) view.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("你要删除["+str+"]吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener()
                        {  @Override public void onClick(DialogInterface dialog, int which)
                        {   //点击“确认”后的操作
                            list_image.remove(a);
                            sa_image.notifyDataSetChanged();
                            Toast.makeText(getActivity(),"已经删除"+str,Toast.LENGTH_SHORT).show();
                            //getActivity().finish();
                        }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
        TextView bianji = (TextView) view.findViewById(R.id.bianji);
        bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                final View textEntryView = factory.inflate(R.layout.bianji_view, null);
                new AlertDialog.Builder(getActivity())
                        .setTitle("编辑信息")
                        .setView(textEntryView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                final EditText etname = (EditText) textEntryView.findViewById(R.id.etname);
                                final ImageView tx_video = (ImageView) textEntryView.findViewById(R.id.tx_video);
                                final EditText etwenben = (EditText) textEntryView.findViewById(R.id.etwenben);
                                final ImageView tp1 = (ImageView) textEntryView.findViewById(R.id.tp1);
                                final ImageView tp2 = (ImageView) textEntryView.findViewById(R.id.tp1);
                                final ImageView bianji_tp = (ImageView) textEntryView.findViewById(R.id.bianji_tp); // 将页面输入框中获得的“用户名”，“密码”转为字符串
                                String name = etname.getText().toString().trim();
                                String wenben = etwenben.getText().toString().trim();
                                Drawable drawable1 = tp1.getDrawable();
                                Drawable drawable2 = tp2.getDrawable();
                                if (!name.equals("")) {
                                    biaoti_image.setText(name);
                                    jianjie_image.setText(wenben);
                                    Toast.makeText(getActivity(), "编辑成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "姓名不能为空", Toast.LENGTH_SHORT).show();
                                    try {
                                        // 注意此处是通过反射，修改源代码类中的字段mShowing为true，系统会认为对话框打开
                                        // 从而调用dismiss()
                                        Field field = dialog.getClass().getSuperclass()
                                                .getDeclaredField("mShowing");
                                        field.setAccessible(true);
                                        field.set(dialog, false);
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        })
                        // 对话框的“退出”单击事件
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        // 设置dialog是否为模态，false表示模态，true表示非模态
                        .setCancelable(false)
                        // 对话框的创建、显示
                        .create().show();
            }
        });

    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i){
            case SCROLL_STATE_FLING://手指离开 但还在划动

                Map<String,Object> map=new HashMap<String,Object>();
                map.put("tx_video",R.drawable.ic_launcher);
                map.put("biaoti_video","111111");
                map.put("jianjie_video","2222222");
                list_image.add(map);
                sa_image.notifyDataSetChanged();
                //更新数据源

                break;
            case SCROLL_STATE_IDLE://视图停止划动

                break;
            case SCROLL_STATE_TOUCH_SCROLL://正在滑动

                break;
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
}
