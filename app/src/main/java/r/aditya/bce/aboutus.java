package r.aditya.bce;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

public class aboutus extends Activity {
	TextView text1, text2, text3;
	ViewPager mViewPager;
	int currentPage, NUM_PAGES = 6;
	Timer swipeTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us);

		text1 = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
		text3 = (TextView) findViewById(R.id.textView3);

		mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
		AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
		mViewPager.setAdapter(adapterView);

		swipeTimer = new Timer();
		swipeTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						if (currentPage == NUM_PAGES) {
							currentPage = 0;
						}
						mViewPager.setCurrentItem(currentPage++, true);
					}
				});
			}
		}, 500, 2000);
	}

	@Override
	public void onBackPressed() {
		overridePendingTransition(R.drawable.slide_in_left,
				R.drawable.slide_out_right);
		finish();
		super.onBackPressed();
	}
}
