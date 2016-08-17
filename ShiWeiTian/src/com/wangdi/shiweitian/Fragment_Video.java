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
public class Fragment_Video extends Fragment implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{
    ListView lv_video;
    List<Map<String,Object>> list_vidio;
    SimpleAdapter sa_video;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.released_view1,container,false);
        lv_video= (ListView) view.findViewById(R.id.lv_video);
        list_vidio=new ArrayList<Map<String,Object>>();
        String[] from_v={"tx_video","biaoti_video","jianjie_video"};
        int[] to_v={R.id.tx_video,R.id.biaoti_video,R.id.jianjie_video};
        sa_video=new SimpleAdapter(getActivity(),list_vidio,R.layout.released_fm1,from_v,to_v);
        getData_video();
        lv_video.setAdapter(sa_video);
        lv_video.setOnItemClickListener(this);
        lv_video.setOnScrollListener(this);
        return view;
    }
    public void getData_video(){
        for (int i = 0; i <10 ; i++) {
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("tx_video",R.drawable.ic_launcher);
                map.put("biaoti_video","三鲜金鱼蒸饺"+i);
                map.put("jianjie_video","为宝宝补充铁元素，促进宝宝的视力发育和上皮组织生长");
                list_vidio.add(map);
        }
    }
    ImageView tp1;
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final TextView biaoti_video = (TextView) view.findViewById(R.id.biaoti_video);
        final TextView jianjie_video = (TextView) view.findViewById(R.id.jianjie_video);
        final String str=biaoti_video.getText().toString();
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
                            list_vidio.remove(a);
                            sa_video.notifyDataSetChanged();
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
                new AlertDialog.Builder(getActivity(),R.style.AlertDialog_style)
                        .setTitle("编辑信息")
                        .setView(textEntryView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                final EditText etname = (EditText) textEntryView.findViewById(R.id.etname);
                                final ImageView tx_video = (ImageView) textEntryView.findViewById(R.id.tx_video);
                                final EditText etwenben = (EditText) textEntryView.findViewById(R.id.etwenben);
                               tp1 = (ImageView) textEntryView.findViewById(R.id.tp1);
                                final ImageView tp2 = (ImageView) textEntryView.findViewById(R.id.tp1);
                                final ImageView bianji_tp = (ImageView) textEntryView.findViewById(R.id.bianji_tp); // 将页面输入框中获得的“用户名”，“密码”转为字符串
                                String name = etname.getText().toString().trim();
                                String wenben = etwenben.getText().toString().trim();
                                Drawable drawable1 = tp1.getDrawable();
                                Drawable drawable2 = tp2.getDrawable();
                                if (!name.equals("")) {
                                    biaoti_video.setText(name);
                                    jianjie_video.setText(wenben);
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
                    list_vidio.add(map);
                    sa_video.notifyDataSetChanged();
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
