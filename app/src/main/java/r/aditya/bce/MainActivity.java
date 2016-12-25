package r.aditya.bce;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView text_hello, text_content, text_i_want;
	boolean doubleBackToExitPressedOnce = false;
	Button button7,button1,button2,button3,button4,button5,button6,bt8,bt7,btn_logout;
	final Context context = this;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text_hello = (TextView) findViewById(R.id.text_hello);
		text_content = (TextView) findViewById(R.id.text_content);
		text_i_want = (TextView) findViewById(R.id.text_i_want);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		button3=(Button)findViewById(R.id.button3);
		button4=(Button)findViewById(R.id.button4);
		//button5=(Button)findViewById(R.id.button5);
		//button6=(Button)findViewById(R.id.button6);
		bt7=(Button)findViewById(R.id.button7);
		bt8=(Button)findViewById(R.id.button8);
		button7 = (Button) findViewById(R.id.button8);
		btn_logout = (Button) findViewById(R.id.btn_logout);
		Typeface face = Typeface.createFromAsset(getAssets(),
				"Magnolia Script.otf");
		text_hello.setTypeface(face);
		text_content.setTypeface(face);
		text_i_want.setTypeface(face);

		btn_logout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(), Activity_Main.class);
				startActivity(i);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
				finish();
			}
		});
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(), aboutus.class);
				startActivity(i);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});

	button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(), academics.class);
				startActivity(i);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
	button3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent i = new Intent(getApplicationContext(), club.class);
			startActivity(i);
			overridePendingTransition(R.drawable.slide_in_right,
					R.drawable.slide_out_left);
		}
	});
	button4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent i = new Intent(getApplicationContext(), payment.class);
			startActivity(i);
			overridePendingTransition(R.drawable.slide_in_right,
					R.drawable.slide_out_left);
		}
	});
	bt7.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Intent i = new Intent(getApplicationContext(), Activity_Register.class);
			startActivity(i);
			overridePendingTransition(R.drawable.slide_in_right,
					R.drawable.slide_out_left);
		}
	});
	bt8.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Intent i = new Intent(getApplicationContext(), contact.class);
			startActivity(i);
			overridePendingTransition(R.drawable.slide_in_right,
					R.drawable.slide_out_left);
		}
	});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce) {
			// TODO Auto-generated method stub
			super.onBackPressed();
			return;
		}
		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "Please click BACK again to Exit!",
				Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
			}
		}, 2000);

	}
}
