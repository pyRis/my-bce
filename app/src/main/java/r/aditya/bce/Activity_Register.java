package r.aditya.bce;


/**
 * Created by pyRis on 03/09/16.
 */

import volley.Config_URL;
import volley.AppController;
import helper.SQLiteHandler;
import helper.SessionManager;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

public class Activity_Register extends Activity {
    private static final String TAG = Activity_Register.class.getSimpleName();
    private Button btnRegister;
    private Button btnLinkToLogin;
    private EditText inputFullName;
    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputDOB;
    private EditText inputBranch;
    private EditText inputYear1;
    private EditText inputFyear;
    private EditText inputStatus;
    private EditText inputAnnv;
    private EditText inputDesig;
    private EditText inputOrgn;
    private EditText inputAdd;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputFullName = (EditText) findViewById(R.id.name);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputDOB = (EditText) findViewById(R.id.dob);
        inputBranch = (EditText) findViewById(R.id.mybranch);
        inputYear1 = (EditText) findViewById(R.id.admyear);
        inputFyear = (EditText) findViewById(R.id.finalyear);
        inputStatus = (EditText) findViewById(R.id.mstatus);
        inputAnnv = (EditText) findViewById(R.id.annv);
        inputDesig = (EditText) findViewById(R.id.desig);
        inputOrgn = (EditText) findViewById(R.id.myorganisation);
        inputAdd = (EditText) findViewById(R.id.myaddress);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(Activity_Register.this,
                    Activity_Main.class);
            startActivity(intent);
            finish();
        }

        // Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputFullName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String DOB = inputDOB.getText().toString();
                String branch = inputBranch.getText().toString();
                String admYear = inputYear1.getText().toString();
                String finyear = inputFyear.getText().toString();
                String status = inputStatus.getText().toString();
                String anniv = inputAnnv.getText().toString();
                String design = inputDesig.getText().toString();
                String organ = inputOrgn.getText().toString();
                String addr = inputAdd.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    registerUser(name, email, password, DOB, branch, admYear, finyear, status,
                            anniv, design, organ, addr);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        // Link to Login Screen
        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        Activity_Login.class);
                startActivity(i);
                finish();
            }
        });

    }

    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     * */
    private void registerUser(final String name, final String email,
                              final String password, final String DOB, final String branch,
                              final String admYear, final String finyear, final String status,
                              final String anniv, final String design, final String organ, final String addr) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Method.POST,
                Config_URL.URL_REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String created_at = user
                                .getString("created_at");
                        String DOB = user.getString("DOB");
                        String branch = user.getString("branch");
                        String admYear = user.getString("admYear");
                        String finyear = user.getString("finyear");
                        String status = user.getString("status");
                        String anniv = user.getString("anniv");
                        String design = user.getString("design");
                        String organ = user.getString("organ");
                        String addr = user.getString("addr");

                        // Inserting row in users table
                       db.addUser(name, email, uid, created_at);

                        // Launch login activity
                        Intent intent = new Intent(
                                Activity_Register.this,
                                Activity_Login.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register

                Map<String, String> params = new HashMap<String, String>();
                params.put("tag", "register");
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                params.put("DOB", DOB);
                params.put("branch", branch);
                params.put("admYear", admYear);
                params.put("finyear", finyear);
                params.put("status", status);
                params.put("anniv", anniv);
                params.put("design", design);
                params.put("organ", organ);
                params.put("addr", addr);



                // VolleyLog.v("data",params);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}