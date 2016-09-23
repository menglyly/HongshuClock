package com.weimengli.camara;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;

public class VidioPlayActivity extends Activity implements OnClickListener{
	
	public Button play,pause,stop;
	public VideoView videoView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_vidioplay);
		play = (Button)findViewById(R.id.play_v);
		pause = (Button)findViewById(R.id.pause_v);
		stop = (Button)findViewById(R.id.replay_v);
		videoView = (VideoView) findViewById(R.id.video_view);
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		stop.setOnClickListener(this);
		initVideoPath();
		
	}

	private void initVideoPath() {
		// TODO Auto-generated method stub
		//这个事先应该在sd卡里放入movie.mp4这个音频文件，它和音乐播放的方法一样
		File file = new File(Environment.getExternalStorageDirectory(),"movie.mp4");
		videoView.setVideoPath(file.getPath());
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.play_v:
			if(videoView.isPlaying()){
				videoView.start();
			}
			
		break;
		case R.id.pause_v:
			if(videoView.isPlaying()){
				videoView.pause();
			}
		break;
		case R.id.replay_v:
			if(videoView.isPlaying()){
				videoView.resume();
			}
		break;
		}
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(videoView != null){
			videoView.suspend();
		}
	}

}
