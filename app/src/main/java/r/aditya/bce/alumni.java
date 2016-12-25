package r.aditya.bce;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.ActionBar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
/**
 * @author Ravindra & aditya
 * 
 */
public class alumni extends ListActivity {
	private ProgressDialog pDialog;
	ListView lv;
	final Context context = this;
	String json1, json2, json3;
	// Creating JSON Parser object
	JSONParser jsonParser = new JSONParser();
	ImageView im;
	ArrayList<HashMap<String, String>> inboxList;
	SearchView notifCount;

	String ids, status, msg, message;
	String L_id, L_name, L_reason, L_lastupdate, L_fromdate, L_todate, L_days,
			L_trans_id, L_pid, approve_pending, l_hq;
	String name, designation, deptname, officename, photo, pho;
	String s = "", s1 = "";
	int j, jj;
	String[] arg;
	int pos;
	Activity activity;

	//125319
	private static final String TAG_MESSAGES = "getAlumniResult";
	private static final String TAG_INNER_MSG = "alumniDetail";
	private static final String TAG_STATUS = "Status";
	private static final String TAG_LEAVE_ID = "L_id";
	private static final String TAG_LEAVE_TRANS_ID = "LTransId";
	private static final String TAG_LEAVE_LP_ID = "LP_id";
	
	
	//private static final String TAG_LEAVE_NAME = "L_Name";
	private static final String TAG_LEAVE_REASON = "Reason";
	private static final String TAG_LAST_UPDATE = "Last_update";
	private static final String TAG_FROM_D = "From_date";
	private static final String TAG_APPROVE_PENDING = "Status";
	private static final String TAG_TO_D = "To_date";
	private static final String TAG_PHOTO = "Photo";
	
	private static final String TAG_NAME = "name";
	//private static final String TAG_DEGI = "email";
	private static final String TAG_DEP = "admissionyear";
	private static final String TAG_ID = "branch";
	private static final String TAG_DEGI  = "designationorg";
	
	private static final String TAG_Leave_Days = "Days_count";
	private static final String TAG_MSG = "Message";
	private static final String TAG_LHQ = "HQ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alumni);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
StrictMode.setThreadPolicy(policy);
		Global_Function cn = new Global_Function(getApplicationContext());
		if (!cn.isConnectingToInternet()) {
			Global_Function.Network_Connection_check(alumni.this,
					"No Network", "PLease Check Internet Connection");
			return;
		}

		inboxList = new ArrayList<HashMap<String, String>>();

		
		pDialog = new ProgressDialog(alumni.this);
		pDialog.setMessage("Loading Alumni details...");
		pDialog.setIndeterminate(false);
		pDialog.setCancelable(false);
		pDialog.show();
		Thread background = new Thread() {
			public void run() {
				String url = "http://" + Global_variable.ip 				
						+ "/student_json/Alumni.json";
				Log.d("URL", url);
				HttpGet request = new HttpGet(url);
				String not = new String(" ");
				try {
					// Send request to WCF service
					DefaultHttpClient httpClient = new DefaultHttpClient();
					Log.d("Http Response:", httpClient.toString());
					HttpResponse response = httpClient.execute(request);
					String res;
					HttpEntity ent = response.getEntity();
					res = (EntityUtils.toString(ent));
					res = res.trim();
					JSONObject parentObject = new JSONObject(res);
					JSONArray inbox = parentObject.getJSONArray(TAG_MESSAGES);
					JSONObject c = inbox.getJSONObject(0);
					status = c.getString("Status");
					message = c.getString("Message");
					Log.d("Leave JSON: ", status);
					Log.d("Leave INNER MSG: ", message);
					JSONArray innerdata = c.getJSONArray(TAG_INNER_MSG);
					if (Integer.parseInt(status.trim()) == Global_variable.RESPONSE_STATUS_SUCCESS) {
						Log.d("Inside: ", "status:true");
						for (int j = 0; j < innerdata.length(); j++) {
							JSONObject d = innerdata.getJSONObject(j);

							ids = d.getString(TAG_ID);

							name = d.getString(TAG_NAME);

							designation = d.getString(TAG_DEGI);

							deptname = d.getString(TAG_DEP);

						
							
							
							HashMap<String, String> map = new HashMap<String, String>();

							// adding each child node to HashMap key => value

							map.put(TAG_ID, ids);
							map.put(TAG_NAME, name);

							map.put(TAG_DEGI, designation);

							map.put(TAG_DEP, deptname);

							inboxList.add(map);

						}
						runOnUiThread(new Runnable() {
							public void run() {
							
								lv = getListView();
								Log.d("Inbox JSON: ", "OK");
								ListAdapter adapter = new SimpleAdapter(
										alumni.this, inboxList,
										R.layout.alumni_list_item, new String[] {
												TAG_NAME,TAG_DEGI,
												TAG_DEP,TAG_ID
												 }, new int[] {
												R.id.name, R.id.edu,
												R.id.app,R.id.branch
												 });
								// updating listview
								setListAdapter(adapter);
								lv.setAdapter(adapter);
								lv.setTextFilterEnabled(true);
								lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
								pDialog.dismiss();

							}
						});
					} else {
						runOnUiThread(new Thread(new Runnable() {
							@Override
							public void run() {
								// dismiss loader
								pDialog.dismiss();
								Global_Function.ErrorAppDialog(
										alumni.this, "Message", "ERROR");
							}
						}));

					}

				} catch (final Exception e) {
					e.printStackTrace();

					not = "NOT ";
					runOnUiThread(new Thread(new Runnable() {
						@Override
						public void run() {
							// dismiss loader
							pDialog.dismiss();
							Toast.makeText(alumni.this, "Server not Responding",
									Toast.LENGTH_LONG).show();

							
						}
					}));

				}
			}

		};
		background.start();
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		overridePendingTransition(R.drawable.slide_in_left,
				R.drawable.slide_out_right);
		finish();
		return true;

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		overridePendingTransition(R.drawable.slide_in_left,
				R.drawable.slide_out_right);
		finish();
		super.onBackPressed();
	}
}