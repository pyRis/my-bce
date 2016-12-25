package r.aditya.bce;

/**
 * Created by pyRis on 03/09/16.
 */

import helper.SQLiteHandler;
import helper.SessionManager;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Main extends Activity {

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout,btn_home;

    private SQLiteHandler db;
    private SessionManager session;
String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btn_home=(Button)findViewById(R.id.btnhome);



        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

       /* Thread background = new Thread() {
            public void run() {
                try {
                    sleep(1 * 1000);

                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.drawable.slide_in_right,
                            R.drawable.slide_out_left);

                    //flag = 1;
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        background.start();*/

        if (!session.isLoggedIn()) {
            logoutUser();
            finish();
        }

        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(name);
        txtEmail.setText(email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
                finish();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.drawable.slide_in_right,
                        R.drawable.slide_out_left);
            }
        });
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        //Intent intent = new Intent(Activity_Main.this, Activity_Login.class);
        //startActivity(intent);
        finish();
    }
}
