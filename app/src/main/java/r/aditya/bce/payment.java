package r.aditya.bce;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class payment extends Activity {
	WebView webView;
	@SuppressLint("SetJavaScriptEnabled")
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);

		// Get webview
		WebView wb=(WebView)findViewById(R.id.webView1);
		wb.getSettings().setJavaScriptEnabled(true);
		wb.setWebViewClient(new mybroser());
		wb.loadUrl("https://mpassbook.ucoonline.in/UPAYCOLLECT/Default.aspx?&MCODE=BCEBHAGALPUR");
	}
	

	private class mybroser extends WebViewClient
	{
		@Override
		public boolean shouldOverrideUrlLoading(WebView ww,String url)
		{
			ww.loadUrl(url);
			return true;
		}
		
	}

	public void onBackPressed() {
		// Let the system handle the back button
			super.onBackPressed();
			finish();
		}
	}

