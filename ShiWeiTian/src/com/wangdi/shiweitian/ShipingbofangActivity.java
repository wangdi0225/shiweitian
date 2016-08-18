package com.wangdi.shiweitian;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ShipingbofangActivity extends Activity {
	private VideoView videoView;
	MediaController mediaController;

	@SuppressLint("SdCardPath")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bofang);
		videoView = (VideoView) findViewById(R.id.videoView);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		mediaController = new MediaController(this);
		// 将videoView与mediaController建立关联
		videoView.setMediaController(mediaController);
		// 将mediaController与videoView建立关联
		mediaController.setMediaPlayer(videoView);
		File vFile = new File("/mnt/sdcard/Movies/test.3gp");
		if (vFile.exists()) {// 如果文件存在
			videoView.setVideoPath(vFile.getAbsolutePath());
			// 让videoView获得焦点
			videoView.start();
			videoView.requestFocus();
		}

	}
}
