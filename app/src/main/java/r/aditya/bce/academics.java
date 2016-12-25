package r.aditya.bce;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class academics extends Activity {
	TextView t1, t2, t3, t4, t5, t6, t7, t8, ece1, ece2, ece3, ece4, ece5;
	TextView ece6, m1, m2, m3, m4, m5, m6, m7, m8, e1, e2, e3, e4, e5, e6;
	TextView ece7, ece8, e7, e8, cs1, cs2, cs3, cs4, cs5, cs6, cs7, cs8;
	Spanned Text, text1;
	Button button1, button2, button3, button4, button5, btn_course,btn_faculty,btn_student,btn_notice;
	static int flag = 0;

	RelativeLayout r1, r2, r3, r4, r5, r_course;
	String filename, file;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.academics);
		t1 = (TextView) findViewById(R.id.text_sem1);
		t2 = (TextView) findViewById(R.id.text_sem2);
		t3 = (TextView) findViewById(R.id.text_sem3);
		t4 = (TextView) findViewById(R.id.text_sem4);
		t5 = (TextView) findViewById(R.id.text_sem5);
		t6 = (TextView) findViewById(R.id.text_sem6);
		t7 = (TextView) findViewById(R.id.text_sem7);
		t8 = (TextView) findViewById(R.id.text_sem8);

		m1 = (TextView) findViewById(R.id.Mech_sem1);
		m2 = (TextView) findViewById(R.id.Mech_sem2);
		m3 = (TextView) findViewById(R.id.Mech_sem3);
		m4 = (TextView) findViewById(R.id.Mech_sem4);
		m5 = (TextView) findViewById(R.id.Mech_sem5);
		m6 = (TextView) findViewById(R.id.Mech_sem6);
		m7 = (TextView) findViewById(R.id.Mech_sem7);
		m8 = (TextView) findViewById(R.id.Mech_sem8);

		ece1 = (TextView) findViewById(R.id.ece_sem1);
		ece2 = (TextView) findViewById(R.id.ece_sem2);
		ece3 = (TextView) findViewById(R.id.ece_sem3);
		ece4 = (TextView) findViewById(R.id.ece_sem4);
		ece5 = (TextView) findViewById(R.id.ece_sem5);
		ece6 = (TextView) findViewById(R.id.ece_sem6);
		ece7 = (TextView) findViewById(R.id.ece_sem7);
		ece8 = (TextView) findViewById(R.id.ece_sem8);

		e1 = (TextView) findViewById(R.id.ee_sem1);
		e2 = (TextView) findViewById(R.id.ee_sem2);
		e3 = (TextView) findViewById(R.id.ee_sem3);
		e4 = (TextView) findViewById(R.id.ee_sem4);
		e5 = (TextView) findViewById(R.id.ee_sem5);
		e6 = (TextView) findViewById(R.id.ee_sem6);
		e7 = (TextView) findViewById(R.id.ee_sem7);
		e8 = (TextView) findViewById(R.id.ee_sem8);

		cs1 = (TextView) findViewById(R.id.cse_sem1);
		cs2 = (TextView) findViewById(R.id.cse_sem2);
		cs3 = (TextView) findViewById(R.id.cse_sem3);
		cs4 = (TextView) findViewById(R.id.cse_sem4);
		cs5 = (TextView) findViewById(R.id.cse_sem5);
		cs6 = (TextView) findViewById(R.id.cse_sem6);
		cs7 = (TextView) findViewById(R.id.cse_sem7);
		cs8 = (TextView) findViewById(R.id.cse_sem8);


		button1 = (Button) findViewById(R.id.button1);
		r1 = (RelativeLayout) findViewById(R.id.civil);
		button2 = (Button) findViewById(R.id.button2);
		r2 = (RelativeLayout) findViewById(R.id.ece);
		button3 = (Button) findViewById(R.id.button3);
		r3 = (RelativeLayout) findViewById(R.id.Mech);
		button4 = (Button) findViewById(R.id.button4);
		r4 = (RelativeLayout) findViewById(R.id.ee);
		button5 = (Button) findViewById(R.id.button5);
		r5 = (RelativeLayout) findViewById(R.id.cs);
		btn_course = (Button) findViewById(R.id.btn_syllbus);
		r_course = (RelativeLayout) findViewById(R.id.syllbus);
		btn_faculty = (Button) findViewById(R.id.btn_faculty);
		btn_student = (Button) findViewById(R.id.btn_students);
		btn_notice = (Button) findViewById(R.id.btn_notice);
		/*
		 * Text = Html.fromHtml(
		 * "<a href='http://akubihar.ac.in/Academics/Docs/CE.pdf'>Civil Enginnering Syllabus</a>"
		 * ); t1.setMovementMethod(LinkMovementMethod.getInstance());
		 * t1.setText(Text);
		 * 
		 * text1=Html.fromHtml(
		 * "<a href='http://akubihar.ac.in/Academics/Docs/MG.pdf'>Mechanical Engineering Syllabus</a>"
		 * ); t1.setMovementMethod(LinkMovementMethod.getInstance());
		 * t2.setText(Text);
		 */
		btn_notice.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Notice.class);
				startActivity(i);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		btn_faculty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Approval_list.class);
				startActivity(i);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		btn_student.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), student_list.class);
				startActivity(i);
				overridePendingTransition(R.drawable.slide_in_right,
						R.drawable.slide_out_left);
			}
		});
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShowHide(r1, flag);
			}
		});
		btn_course.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShowHide_main(r_course,flag);
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShowHide(r2, flag);
			}
		});
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShowHide(r3, flag);
			}
		});
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShowHide(r4, flag);
			}
		});
		button5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShowHide(r5, flag);
			}
		});
		t1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/Group_A_1st_SEM.pdf";
				file = "Group_A_1st_SEM.pdf";
				viewer(filename);
			}
		});
		t2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/Group_A_2nd_SEM.pdf";
				file = "Group_A_2nd_SEM.pdf";
				viewer(filename);
			}
		});
		t3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/civil/Civil_3rd_sem.pdf";
				file = "Civil_3rd_sem.pdf";
				viewer(filename);
			}
		});
		t4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/civil/Civil_4th_Sem.pdf";
				file = "Civil_4th_Sem.pdf";
				viewer(filename);
			}
		});
		t5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/civil/Civil_5th_Sem.pdf";
				file = "Civil_5th_Sem.pdf";
				viewer(filename);
			}
		});
		t6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/civil/Civil_6th_Sem.pdf ";
				file = "Civil_6th_Sem.pdf";
				viewer(filename);
			}
		});
		t7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/civil/Civil_7th_Sem.pdf ";
				file = "Civil_7th_Sem.pdf";
				viewer(filename);
			}
		});
		t8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/civil/Civil_8th_Sem.pdf";
				file = "Civil_8th_Sem.pdf";
				viewer(filename);
			}
		});
		e1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/Group_A_1st_SEM.pdf";
				file = "Elec_1st_SEM.pdf";
				viewer(filename);
			}
		});
		e2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/Group_A_2nd_SEM.pdf ";
				file = "Elec_2nd_SEM.pdf";
				viewer(filename);
			}
		});
		e3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electrical/Elec_3rd_sem.pdf ";
				file = "Elec_3rd_sem.pdf";
				viewer(filename);
			}
		});
		e4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electrical/Elec_4th_sem.pdf ";
				file = "Elec_4th_sem.pdf";
				viewer(filename);
			}
		});
		e5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electrical/Elec_5th_sem.pdf ";
				file = "Elec_5th_sem.pdf";
				viewer(filename);
			}
		});
		e6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electrical/Elec_6th_sem.pdf";
				file = "Elec_6th_sem.pdf";
				viewer(filename);
			}
		});
		e7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electrical/Elec_7th_sem.pdf";
				file = "Elec_7th_sem.pdf";
				viewer(filename);
			}
		});
		e8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electrical/Elec_8th_sem.pdf";
				file = "Elec_8th_sem.pdf";
				viewer(filename);
			}
		});
		m1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/Group_A_1st_SEM.pdf ";
				file = "Mech_1st_Sem.pdf";
				viewer(filename);
			}
		});
		m2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/Group_A_2nd_SEM.pdf ";
				file = "Mech_2nd_Sem.pdf";
				viewer(filename);
			}
		});
		m3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/mechanical/Mech_3rd_Sem.pdf ";
				file = "Mech_3rd_Sem.pdf";
				viewer(filename);
			}
		});
		m4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/mechanical/Mech_4th_Sem.pdf ";
				file = "Mech_4th_Sem.pdf";
				viewer(filename);
			}
		});
		m5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/mechanical/Mech_5th_Sem.pdf ";
				file = "Mech_5th_Sem.pdf";
				viewer(filename);
			}
		});
		m6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/mechanical/Mech_6th_Sem.pdf";
				file = "Mech_6th_Sem.pdf";
				viewer(filename);
			}
		});
		m7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/mechanical/Mech_7th_Sem.pdf ";
				file = "Mech_7th_Sem.pdf";
				viewer(filename);
			}
		});
		m8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/mechanical/Mech_8th_Sem.pdf";
				file = "Mech_8th_Sem.pdf";
				viewer(filename);
			}
		});

		ece1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/Group_B_1st_SEM.pdf ";
				file = "ECE_1st_sem.pdf";
				viewer(filename);
			}
		});
		ece2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/Group_B_2nd_SEM.pdf ";
				file = "ECE_2nd_sem.pdf";
				viewer(filename);
			}
		});
		ece3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electronics/ECE_3rd_sem.pdf";
				file = "ECE_3rd_sem.pdf";
				viewer(filename);
			}
		});
		ece4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electronics/ECE_4th_sem.pdf ";
				file = "ECE_4th_sem.pdf";
				viewer(filename);
			}
		});
		ece5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = " http://technoriti.in/syllabusdirectory/electronics/ECE_5th_sem.pdf ";
				file = "ECE_5th_sem.pdf";
				viewer(filename);
			}
		});
		ece6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/electronics/ECE_6th_sem.pdf";
				file = "ECE_6th_sem.pdf";
				viewer(filename);
			}
		});
		ece7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/electronics/ECE_7th_sem.pdf";
				file = "ECE_7th_sem.pdf";
				viewer(filename);
			}
		});
		ece8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/electronics/ECE_8th_sem.pdf";
				file = "ECE_8th_sem.pdf";
				viewer(filename);
			}
		});

		cs1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/Group_B_1st_SEM.pdf";
				file = "CSE_1st_sem.pdf";
				viewer(filename);
			}
		});
		cs2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/Group_B_2nd_SEM.pdf";
				file = "CSE_2nd_sem.pdf";
				viewer(filename);
			}
		});
		cs3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/computer/CSE_3rd_sem.pdf";
				file = "CSE_3rd_sem.pdf";
				viewer(filename);
			}
		});
		cs4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/computer/CSE_4th_sem.pdf";
				file = "CSE_4th_sem.pdf";
				viewer(filename);
			}
		});
		cs5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/computer/CSE_5th_sem.pdf";
				file = "CSE_5th_sem.pdf";
				viewer(filename);
			}
		});
		cs6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/computer/CSE_6th_sem.pdf";
				file = "CSE_6th_sem.pdf";
				viewer(filename);
			}
		});
		cs7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/computer/CSE_7th_sem.pdf";
				file = "CSE_7th_sem.pdf";
				viewer(filename);
			}
		});
		cs8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				filename = "http://technoriti.in/syllabusdirectory/electronics/CSE_8th_sem.pdf";
				file = "CSE_8th_sem.pdf";
				viewer(filename);
			}
		});


	}

	public void ShowHide(RelativeLayout rr1, int flag1) {
		if (flag1 == 0) {
			r1.setVisibility(View.GONE);
			r2.setVisibility(View.GONE);
			r3.setVisibility(View.GONE);
			r4.setVisibility(View.GONE);
			r5.setVisibility(View.GONE);
			rr1.setVisibility(View.VISIBLE);
			flag = 1;
		} else {
			r1.setVisibility(View.GONE);
			r2.setVisibility(View.GONE);
			r3.setVisibility(View.GONE);
			r4.setVisibility(View.GONE);
			r5.setVisibility(View.GONE);
			rr1.setVisibility(View.GONE);
			flag = 0;
		}
	}
	public void ShowHide_main(RelativeLayout rr1, int flag1) {
		if (flag1 == 0) {
			
			rr1.setVisibility(View.VISIBLE);
			flag = 1;
		} else {
		
			rr1.setVisibility(View.GONE);
			flag = 0;
		}
	}

	@Override
	public void onBackPressed() {
		overridePendingTransition(R.drawable.slide_in_left,
				R.drawable.slide_out_right);
		finish();
		super.onBackPressed();
	}

	@SuppressWarnings("deprecation")
	private void CopyReadAssets(String files) {
		AssetManager assetManager = getAssets();

		InputStream in = null;
		OutputStream out = null;
		File file = new File(getFilesDir(), files);
		try {
			in = assetManager.open(files);
			out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			copyFile(in, out);
			in.close();
			in = null;
			out.flush();
			out.close();
			out = null;
		} catch (Exception e) {
			Log.e("tag", e.getMessage());
		}

		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(
				Uri.parse("file://" + getFilesDir() + "/" + files),
				"application/pdf");

		startActivity(intent);
	}

	public void showPdf() {
		File file = new File(Environment.getExternalStorageDirectory()
				+ "/Mypdf/Read.pdf");
		PackageManager packageManager = getPackageManager();
		Intent testIntent = new Intent(Intent.ACTION_VIEW);
		testIntent.setType("application/pdf");
		List list = packageManager.queryIntentActivities(testIntent,
				PackageManager.MATCH_DEFAULT_ONLY);
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		Uri uri = Uri.fromFile(file);
		intent.setDataAndType(uri, "application/pdf");
		startActivity(intent);
	}

	public void pdf_download(String url) {
		String extStorageDirectory = Environment.getExternalStorageDirectory()
				.toString();
		File folder = new File(extStorageDirectory, "application/pdf");
		folder.mkdir();
		File file = new File(folder, "Read.pdf");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		downloader.DownloadFile(
				"http://technoriti.in/syllabusdirectory/Group_A_1st_SEM.pdf",
				file);

		showPdf();
	}

	@SuppressLint("SetJavaScriptEnabled")
	@SuppressWarnings("deprecation")
	public void viewer(String LinkTo) {
		WebView mWebView = new WebView(academics.this);
		mWebView.getSettings().setJavaScriptEnabled(true);
		// mWebView.getSettings().setPluginsEnabled(true);

		mWebView.getSettings().setPluginState(PluginState.ON);

		mWebView.loadUrl("https://docs.google.com/gview?embedded=true&url="
				+LinkTo.trim());
		setContentView(mWebView);
	}

	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
	}

}
