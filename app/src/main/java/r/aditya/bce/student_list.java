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
public class student_list extends ListActivity {
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
	private static final String TAG_MESSAGES = "getLeaveResult";
	private static final String TAG_INNER_MSG = "LeaveDetail";
	private static final String TAG_STATUS = "Status";
	private static final String TAG_LEAVE_ID = "L_id";
	private static final String TAG_LEAVE_TRANS_ID = "LTransId";
	private static final String TAG_LEAVE_LP_ID = "LP_id";
	private static final String TAG_ID = "admsnYear";
	private static final String TAG_NAME = "name";
	private static final String TAG_LEAVE_NAME = "L_Name";
	private static final String TAG_LEAVE_REASON = "Reason";
	private static final String TAG_LAST_UPDATE = "Last_update";
	private static final String TAG_FROM_D = "From_date";
	private static final String TAG_APPROVE_PENDING = "Status";
	private static final String TAG_TO_D = "To_date";
	private static final String TAG_PHOTO = "Photo";
	
	private static final String TAG_DEGI = "rollNo";
	private static final String TAG_DEP = "branch";
	private static final String TAG_OFFICE = "OfficeName";
	private static final String TAG_Leave_Days = "Days_count";
	private static final String TAG_MSG = "Message";
	private static final String TAG_LHQ = "HQ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faculty_list);
		//StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		//.permitAll().build();
//StrictMode.setThreadPolicy(policy);
		Global_Function cn = new Global_Function(getApplicationContext());
		if (!cn.isConnectingToInternet()) {
			Global_Function.Network_Connection_check(student_list.this,
					"No Network", "PLease Check Internet Connection");
			return;
		}
		
		//im = (ImageView) findViewById(R.id.imageView1data);
	/*	try {
			BufferedReader br = null;
			File ff = new File(getCacheDir(), "mydata");
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					ff)));
			StringBuffer sb = new StringBuffer();
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}

			s = Global_Function.decrypt("UserId", sb.toString());

			arg = s.split("\\|");

		} catch (Exception e) {
			e.printStackTrace();
		}*/
	
		//LayoutInflater li = LayoutInflater.from(context);
	//final	View promptsView = li.inflate(R.id.imageView1_for_approved, null);
		//final ImageView l = (ImageView) promptsView
			//	.findViewById(R.id.imageView1_for_approved);
	//	final ImageView l=(ImageView) View.inflate(this,android.R.color.holo_green_light,null);
		
		
		/*getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		ActionBar bar = getActionBar();

		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#20b2aa")));*/
		// Hashmap for ListView

		inboxList = new ArrayList<HashMap<String, String>>();

		
		pDialog = new ProgressDialog(student_list.this);
		pDialog.setMessage("Loading Student details...");
		pDialog.setIndeterminate(false);
		pDialog.setCancelable(false);
		pDialog.show();
		Thread background = new Thread() {
			public void run() {
				String url = "http://" + Global_variable.ip 				
						+ "/student_json/2k13_CSE.json";
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
							//map.put(TAG_PHOTO, pho);
							map.put(TAG_DEP, deptname);


							inboxList.add(map);

						}
						runOnUiThread(new Runnable() {
							public void run() {
							
								lv = getListView();
								Log.d("Inbox JSON: ", "OK");
								ListAdapter adapter = new SimpleAdapter(
										student_list.this, inboxList,
										R.layout.student_list_item, new String[] {
												TAG_NAME,TAG_DEGI,
												TAG_DEP,TAG_ID
												 }, new int[] {
												R.id.name, R.id.app,
												R.id.edu,R.id.branch
												/*R.id.c_office,
												R.id.leave_count,
												R.id.text_status,
												R.id.designation, R.id.txt_hq*/ });
								// updating listview
								setListAdapter(adapter);
								lv.setAdapter(adapter);
								lv.setTextFilterEnabled(true);
								lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
								pDialog.dismiss();
								/*lv.setOnItemClickListener(new OnItemClickListener() {

									@Override
									public void onItemClick(
											AdapterView<?> parent, View view,
											int position, long id) {
										// TODO Auto-generated method stub
										Global_Function cn = new Global_Function(
												getApplicationContext());
										if (!cn.isConnectingToInternet()) {
											Global_Function
													.Network_Connection_check(
															Approval_list.this,
															"No Network",
															"PLease Check Internet Connection");
											return;
										}

										pos = position;
										String s = String.valueOf(lv
												.getItemAtPosition(position));
										s=s.replace("{", "");
									s=s.replace("}", ",").trim();
										Log.d("object", s);
										
										String emp_name;
										String emp_leave_id;
										String emp_dept_name;
										String emp_last_update;
										String emp_trans_id;
										String emp_lp_id;
										String emp_day_count;
										String emp_officename;
										String emp_fromdate;
										String emp_code;
										String emp_photo;
										String emp_desgi;
										String emp_todate;
										String emp_leavename;
										String emp_reason;
										String emp_approve_reject;
										String emp_hq;

										emp_name =s.substring(s.indexOf("Name=")+5);
										emp_name=emp_name.substring(0,emp_name.indexOf(","));
										
										emp_hq =s.substring(s.indexOf("HQ=")+3);
										emp_hq=emp_hq.substring(0,emp_hq.indexOf(","));
										
										emp_officename = s.substring(s.indexOf("OfficeName=")+11);
										emp_officename=emp_officename.substring(0,emp_officename.indexOf(","));
										
										emp_code = s.substring(s.indexOf("empcode=")+7);
										emp_code=emp_code.substring(0,emp_code.indexOf(","));
										
										emp_approve_reject = s.substring(s.indexOf("Status=")+7);
										emp_approve_reject=emp_approve_reject.substring(0,emp_approve_reject.indexOf(","));
										
										emp_trans_id = s.substring(s.indexOf("LTransId=")+8);
										emp_trans_id=emp_trans_id.substring(0,emp_trans_id.indexOf(","));
										
										emp_reason =s.substring(s.indexOf("Reason=")+7);
										emp_reason=emp_reason.substring(0,emp_reason.indexOf(","));
										
										emp_photo =s.substring(s.indexOf("Photo=")+6);
										emp_photo=emp_photo.substring(0,emp_photo.indexOf(","));
										
										emp_leave_id= s.substring(s.indexOf("L_id=")+5);
										emp_leave_id=emp_leave_id.substring(0,emp_leave_id.indexOf(","));
										
										emp_day_count = s.substring(s.indexOf("Days_count=")+11);
										emp_day_count=emp_day_count.substring(0,emp_day_count.indexOf(","));

										emp_leavename= s.substring(s.indexOf("L_Name=")+7);
										emp_leavename=emp_leavename.substring(0,emp_leavename.indexOf(","));
										
										emp_todate = s.substring(s.indexOf("To_date=")+8);
										emp_todate=emp_todate.substring(0,emp_todate.indexOf(","));
										
										emp_desgi = s.substring(s.indexOf("Designation=")+12);
										emp_desgi=emp_desgi.substring(0,emp_desgi.indexOf(","));
										
										emp_dept_name = s.substring(s.indexOf("DeptName=")+9);
										emp_dept_name=emp_dept_name.substring(0,emp_dept_name.indexOf(","));
										
										emp_lp_id= s.substring(s.indexOf("LP_id=")+5);
										emp_lp_id=emp_lp_id.substring(0,emp_lp_id.indexOf(","));
										
										emp_fromdate = s.substring(s.indexOf("From_date=")+10);
										emp_fromdate=emp_fromdate.substring(0,emp_fromdate.indexOf(","));
										
										emp_last_update = s.substring(s.indexOf("Last_update=")+12);
										emp_last_update=emp_last_update.substring(0,emp_last_update.indexOf(","));
	
										Log.d("Status", emp_approve_reject);
										if (emp_approve_reject
												.equalsIgnoreCase("Approved")) {
											AlertDialog.Builder adb = new AlertDialog.Builder(
													Approval_list.this);
											adb.setTitle("Message");
											// adb.setMessage("Selected Item is = "+lv.getItemAtPosition(position));
											adb.setMessage("Leave is already Approved");
											adb.setPositiveButton("Ok", null);
											adb.show();
										} else if (emp_approve_reject
												.equalsIgnoreCase("Rejected")) {

											AlertDialog.Builder adb = new AlertDialog.Builder(
													Approval_list.this);
											adb.setTitle("Message");
											// adb.setMessage("Selected Item is = "+lv.getItemAtPosition(position));
											adb.setMessage("Leave is already Rejected");
											adb.setPositiveButton("Ok", null);
											adb.show();
										} else if (emp_approve_reject
												.equalsIgnoreCase("Cancellation Approved")) {
											
										
										} else if (emp_approve_reject
												.equalsIgnoreCase("Cancellation Pending")) {

											Intent inn = new Intent(
													getApplicationContext(),
													Cancel_approve.class);

											inn.putExtra("id", emp_code);
											inn.putExtra("name", emp_name);
											inn.putExtra("leaveid",
													emp_leave_id);
											inn.putExtra("dept", emp_dept_name);											
											inn.putExtra("degi", emp_desgi);
											inn.putExtra("leavename",
													emp_leavename);
											inn.putExtra("photo", emp_photo);
											inn.putExtra("From_date",
													emp_fromdate);
											inn.putExtra("To_date", emp_todate);
											inn.putExtra("days_count",
													emp_day_count);
											inn.putExtra("Reason", emp_reason);
											inn.putExtra("USERID",
													arg[0].toString());
											inn.putExtra("transid",
													emp_trans_id);
											inn.putExtra("lpid", emp_lp_id);
											inn.putExtra("HQ", emp_hq);
											
											startActivity(inn);
											finish();
										} else {
											Intent inn = new Intent(
													getApplicationContext(),
													Approve_Reject.class);

											inn.putExtra("id", emp_code);
											inn.putExtra("name", emp_name);
											inn.putExtra("leaveid",
													emp_leave_id);
											inn.putExtra("dept", emp_dept_name);
											inn.putExtra("degi", emp_desgi);
											inn.putExtra("leavename",
													emp_leavename);
											inn.putExtra("photo", emp_photo);
											inn.putExtra("From_date",
													emp_fromdate);
											inn.putExtra("To_date", emp_todate);
											inn.putExtra("days_count",
													emp_day_count);
											inn.putExtra("Reason", emp_reason);
											inn.putExtra("USERID",
													arg[0].toString());
											inn.putExtra("transid",
													emp_trans_id);
											inn.putExtra("lpid", emp_lp_id);
											inn.putExtra("HQ", emp_hq);
											startActivity(inn);
											finish();
										}

										

									}
								});*/
							}
						});
					} else {
						runOnUiThread(new Thread(new Runnable() {
							@Override
							public void run() {
								// dismiss loader
								pDialog.dismiss();
								Global_Function.ErrorAppDialog(
										student_list.this, "Message", "ERROR");
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
							Toast.makeText(student_list.this, "Server not Responding",
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