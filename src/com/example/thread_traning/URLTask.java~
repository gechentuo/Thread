package com.example.thread_traning;

import android.app.AlertDialog;
import android.app.Dialog;
import android.widget.TextView;

public class URLTask {
	private URLManager urlManager;
	private String url;
	private String content;
	private AlertDialog.Builder builder;
	private TextView textview;
	public URLTask(AlertDialog.Builder builder,TextView textview) {
		this.builder = builder;
		this.textview = textview;
		urlManager = URLManager.getInstance();
		
	}

	public void handleLoadState(int state) {
		int outState = -1;
		switch (state) {
		case LoadUrlRunnable.LOAD_STATE_COMPLETE:
			outState = URLManager.TASK_COMPLETE;
			break;
		}
		handleState(outState);
	}

	private void handleState(int state) {
		urlManager.handleState(this, state);
	}

	public TextView getTextview() {
		return textview;
	}

	public void setTextview(TextView textview) {
		this.textview = textview;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AlertDialog.Builder getBuilder() {
		return builder;
	}

	public void setBuilder(AlertDialog.Builder builder) {
		this.builder = builder;
	}

	 

}
