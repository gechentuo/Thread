package com.example.thread_traning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadUrlRunnable implements Runnable {
	private URLTask task;
	public  static final int LOAD_STATE_COMPLETE = 1;
	
	public LoadUrlRunnable(URLTask loadTask) {
		task = loadTask;
	}
	@Override
	public void run() {
		try{
			URL url = new URL("http://baidu.com");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			String content = readStream(con.getInputStream());
			task.setContent(content);
			task.setUrl(url.toString());
			task.handleLoadState(LOAD_STATE_COMPLETE);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private String readStream(InputStream in){
		BufferedReader reader = null;
		StringBuffer all = new StringBuffer();
		
		try{
			reader = new BufferedReader(new InputStreamReader(in));
			String data = "";
			while((data = reader.readLine())!= null){
				all.append(data);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			} 
		}

		return all.toString();

	}

}
