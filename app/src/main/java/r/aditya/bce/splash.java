package r.aditya.bce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class splash extends Activity {
	public int flag = 0;
	TextView text_hello;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		text_hello = (TextView) findViewById(R.id.text_hello);
		Typeface face = Typeface.createFromAsset(getAssets(),
				"Vegur-Regular.otf");
		text_hello.setTypeface(face);
		Thread background = new Thread() {
			public void run() {
				try {
					sleep(2 * 1000);

					Intent i = new Intent(getBaseContext(), Activity_Login.class);
					startActivity(i);
					overridePendingTransition(R.drawable.slide_in_right,
							R.drawable.slide_out_left);

					flag = 1;
					finish();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		if (this.flag == 0) {
			background.start();
		}
	}
}