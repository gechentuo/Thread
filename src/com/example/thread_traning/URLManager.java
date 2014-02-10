package com.example.thread_traning;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class URLManager {
	public static final int TASK_COMPLETE = 1;
	private Handler mHandler;

	private URLManager() {
		mHandler = new Handler(Looper.getMainLooper()) {
			@Override
			public void handleMessage(Message msg) {
				URLTask task = (URLTask) msg.obj;
				switch (msg.what) {
				case TASK_COMPLETE:
					AlertDialog.Builder builder = task.getBuilder();
					TextView textview = task.getTextview();
					textview.setText(String.valueOf(task.getContent()
							.getBytes().length));
					builder.setTitle(task.getUrl()).setView(textview).show();
					break;
				}

			}
		};
	}

	public static URLManager getInstance() {
		return new URLManager();
	}

	public void handleState(URLTask task, int state) {
		switch (state) {
		case TASK_COMPLETE:
			Message completeMessage = mHandler.obtainMessage(state, task);
			completeMessage.sendToTarget();
			break;
		}
	}
}
