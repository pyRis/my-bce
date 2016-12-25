package r.aditya.bce;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pyRis on 05/09/16.
 */
public class contact extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        final TextView textView=(TextView)findViewById(R.id.textView1);
        final Button button1 =  (Button)findViewById(R.id.mybutton);
        final Button button2 =  (Button)findViewById(R.id.mybutton2);

        //Implement listener for your button so that when you click the
        //button, android will listen to it.

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                textView.setText("Please mail me at\n\nrishu_kumar@live.com");

            }         });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                textView.setText(getString(R.string.about_us_content1));

            }         });
    }
}
