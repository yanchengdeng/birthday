package com.dengyancheng.birthday;


import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
/***
 * yancheng
 **/
public class PlayMusicService extends IntentService {
	
	private Thread myThread;
	 private MediaPlayer mp;
	public PlayMusicService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public PlayMusicService() {
		// TODO Auto-generated constructor stub
		super("PlayMusicService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		mp =MediaPlayer.create(this, R.raw.love);
		mp.setLooping(true);
		myThread  = new MyThread();
		myThread.start();
		}
	
	private class MyThread extends Thread
    {
		@Override
		public void run() {
			try
			{
			if (mp!=null)
			{
				mp.stop();
			}
			mp.prepare();
			mp.start();
			} catch (Exception e)
			{
			e.printStackTrace();
			}
			super.run();
		}
		
    }
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
