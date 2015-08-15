package com.example.plugintest.service;

import com.example.plugintest.R;
import com.plugin.core.PluginLoader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * @author cailiming
 * 
 */
public class PluginTestService2 extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("PluginTestService2", "PluginTestService2 onCreate2");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Log.d("PluginTestService2", "PluginTestService2 onStartCommand2 "
				+ (intent == null ? " null" : intent.toUri(0)) + " " + getResources().getText(R.string.hello_world3));

		Toast.makeText(
				this,
				" PluginTestService2 "
						+ (intent == null ? " null" : (getResources().getText(R.string.hello_world3) + "," + intent
								.toUri(0))), Toast.LENGTH_LONG).show();

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	/**
	 * 为了能在Service中正常访问插件中的资源。
	 */
	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(PluginLoader.getDefaultPluginContext(PluginTestService2.class));
	}

}
