package com.example.thread_traning;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v) {
		TextView textview = new TextView(MainActivity.this);
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		LoadUrlRunnable load = new LoadUrlRunnable(new URLTask(builder,textview));
 		load.run();
	}

    
}
