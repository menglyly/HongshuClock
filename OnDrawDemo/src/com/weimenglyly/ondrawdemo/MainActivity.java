package com.weimenglyly.ondrawdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		 ScrollView layout=(ScrollView) findViewById(R.id.try_something);//只用在xml中设置一下id就行，有些可以再里边添加<com.xxx.xxx.view> 
	        final DrawView view=new DrawView(this);  
	        view.setMinimumHeight(500);  
	        view.setMinimumWidth(300);  
	        //通知view组件重绘    
	        view.invalidate();  
	        layout.addView(view);  
	          
	}

}
