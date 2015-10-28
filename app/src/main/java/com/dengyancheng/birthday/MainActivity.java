package com.dengyancheng.birthday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webview = (WebView) findViewById(R.id.webview);
		
		WebSettings ws = webview.getSettings();
		

		// ws.setBuiltInZoomControls(true);
		ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
		ws.setUseWideViewPort(true);
		ws.setLoadWithOverviewMode(true);
		ws.setSavePassword(true);
		ws.setSaveFormData(true);
		ws.setJavaScriptEnabled(true);
		ws.setGeolocationEnabled(true);
		ws.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
		ws.setDomStorageEnabled(true);
		ws.setSupportZoom(true);
		
		webview.loadUrl("file:///android_asset/index.html");
		
		 Intent intent = new Intent(MainActivity.this,PlayMusicService.class);
         startService(intent);
	}
	
	private long mExitTime;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
					mExitTime = System.currentTimeMillis();
				} else {
				finish();
				}
			}
			return true;
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 Intent intent = new Intent(MainActivity.this,PlayMusicService.class);
         stopService(intent);
	}

}
