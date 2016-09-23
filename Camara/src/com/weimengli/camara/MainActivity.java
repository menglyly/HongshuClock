package com.weimengli.camara;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	public static final int TAKE_PHOTO = 1;
	public static final int CROP_PHOTO = 2;
	public Button takephoto,chooseFromAlbum,musicplay;
	public ImageView picture;
	private Uri imagUri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		takephoto = (Button)findViewById(R.id.take_photo);
		chooseFromAlbum = (Button)findViewById(R.id.choose_from_album);
		musicplay = (Button)findViewById(R.id.music_play);
		picture = (ImageView)findViewById(R.id.picture);
		takephoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File outputImage = new File(Environment.getExternalStorageDirectory(),"tempImage");
			try {
				if(outputImage.exists()){
					outputImage.delete();
				}
					outputImage.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			imagUri = Uri.fromFile(outputImage);
			Intent intent  = new Intent("android.media.action.IMAGE_CAPTURE");
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imagUri);
			startActivityForResult(intent, TAKE_PHOTO);//启动相机
			}
		});
		chooseFromAlbum.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				File fileOutputStream = new File(Environment.getExternalStorageDirectory(),"output_image.jpg");
				try {
					if (fileOutputStream.exists()) {
						fileOutputStream.delete();
					}
					fileOutputStream.createNewFile();
					} catch (IOException e) {
					e.printStackTrace();
					}
				imagUri = Uri.fromFile(fileOutputStream);
				Intent intent = new Intent("android.intent.action.GET_CONTENT");
				intent.setType("image/*");
				intent.putExtra("crop", true);
				intent.putExtra("scale", true);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imagUri);
				startActivityForResult(intent, CROP_PHOTO);
			}
		});
		musicplay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i =new Intent(MainActivity.this,MusicPlayActivity.class);
				startActivity(i);
			}
		});
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case TAKE_PHOTO:
			if(resultCode == RESULT_OK){
			Intent intent = new Intent("com.android.camera.action.CROP");
			intent.putExtra("scale", true);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imagUri);
			startActivityForResult(intent, CROP_PHOTO);//裁剪相机
			}
			break;

		case CROP_PHOTO:
			if(requestCode == RESULT_OK){
				try {
					
					Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imagUri));
					//将图片装成bitmap
					picture.setImageBitmap(bitmap);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		}
	}

}
