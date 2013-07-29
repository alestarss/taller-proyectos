package socialtoilet.android.activities;

import socialtoilet.android.R;
import socialtoilet.android.R.layout;
import socialtoilet.android.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends Activity {

	private static String TAG = SplashScreenActivity.class.getName();
	private static long SLEEP_TIME = 3;    // Sleep for some time
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
		
		setContentView(R.layout.activity_splash_screen);
		
		  // Start timer and launch main activity
		IntentLauncher launcher = new IntentLauncher();
		launcher.start();
	}

	private class IntentLauncher extends Thread {
		@Override
		/**
		* Sleep for some time and than start new activity.
		*/
		public void run() {
			try {
				// Sleeping
		        Thread.sleep(SLEEP_TIME*1000);
			} catch (Exception e) {
				Log.e(TAG, e.getMessage());
			}
			// Start main activity
		    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
		    SplashScreenActivity.this.startActivity(intent);
		    SplashScreenActivity.this.finish();
		}
	}
}
