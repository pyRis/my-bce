package r.aditya.bce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;

public class club extends Activity {
	RelativeLayout first, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13,
			r14, r15, r16, r17, r18;
	GridLayout g1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO(3) To remove this class.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.achiever_club);

		first = (RelativeLayout) findViewById(R.id.first);
		r2 = (RelativeLayout) findViewById(R.id.second);
		r3 = (RelativeLayout) findViewById(R.id.third);
		r4 = (RelativeLayout) findViewById(R.id.fourth);
		r5 = (RelativeLayout) findViewById(R.id.fifth);
		r6 = (RelativeLayout) findViewById(R.id.sixth);
		r7 = (RelativeLayout) findViewById(R.id.seventh);
		r8 = (RelativeLayout) findViewById(R.id.eight);
		r9 = (RelativeLayout) findViewById(R.id.nine);
		r10 = (RelativeLayout) findViewById(R.id.ten);
		r11 = (RelativeLayout) findViewById(R.id.eleven);
		r12 = (RelativeLayout) findViewById(R.id.twelve);
		r13 = (RelativeLayout) findViewById(R.id.thirteen);
		r14 = (RelativeLayout) findViewById(R.id.fourteen);
		r15 = (RelativeLayout) findViewById(R.id.fifteen);
		r16 = (RelativeLayout) findViewById(R.id.sixteen);
		r17 = (RelativeLayout) findViewById(R.id.seventeen);
		r18 = (RelativeLayout) findViewById(R.id.eighteen);
		g1 = (GridLayout) findViewById(R.id.Grid_view4);
		/*
		 * first.setOnTouchListener(new OnTouchListener() {
		 *
		 * @Override public boolean onTouch(View v, MotionEvent event) {
		 * Auto-generated method stub if (event.getAction() ==
		 * MotionEvent.ACTION_OUTSIDE) { first.setBackgroundColor(Color.RED);
		 * }else if(event.getAction() == MotionEvent.ACTION_) {
		 * first.setBackgroundColor(Color.BLUE); } return false; } });
		 */

		first.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				send_data(1);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				send_data(2);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(3);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(4);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(5);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(6);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(7);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(8);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(9);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r10.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(10);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(11);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r12.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(12);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r13.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(13);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r14.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(14);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		r15.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				g1.setVisibility(View.VISIBLE);
			}
		});
		r16.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(15);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);

			}
		});
		r17.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				send_data(16);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);

			}
		});
		r18.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				g1.setVisibility(View.GONE);
			}
		});
	}

	public void send_data(int data) {
		Intent in = new Intent(getApplicationContext(), cell.class);
		switch (data) {
			case 1:

				in.putExtra("Data", "1");// send name
				startActivity(in);

				break;
			case 2:

				in.putExtra("Data", "2");// send name

				startActivity(in);

				break;
			case 3:

				in.putExtra("Data", "3");// send name

				startActivity(in);

				break;
			case 4:

				in.putExtra("Data", "4");// send name

				startActivity(in);

				break;
			case 5:

				in.putExtra("Data", "5");// send name

				startActivity(in);

				break;
			case 6:

				in.putExtra("Data", "6");// send name

				startActivity(in);

				break;
			case 7:

				in.putExtra("Data", "7");// send name

				startActivity(in);

				break;
			case 8:

				in.putExtra("Data", "8");// send name

				startActivity(in);

				break;
			case 9:

				in.putExtra("Data", "9");// send name

				startActivity(in);

				break;
			case 10:

				in.putExtra("Data", "10");// send name

				startActivity(in);

				break;
			case 11:

				in.putExtra("Data", "11");// send name

				startActivity(in);

				break;
			case 12:

				in.putExtra("Data", "12");// send name

				startActivity(in);

				break;
			case 13:

				in.putExtra("Data", "13");// send name

				startActivity(in);

				break;
			case 14:

				in.putExtra("Data", "14");// send name

				startActivity(in);

				break;
			case 15:

				in.putExtra("Data", "15");// send name

				startActivity(in);

				break;
			case 16:

				in.putExtra("Data", "16");// send name

				startActivity(in);

				break;
		}
	}

	@Override
	public void onBackPressed() {
		overridePendingTransition(R.drawable.slide_in_left,
				R.drawable.slide_out_right);
		finish();
		super.onBackPressed();
	}

}
