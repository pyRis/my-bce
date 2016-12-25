package r.aditya.bce;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

public class calender extends AppCompatActivity {
CalendarView calendarView;
String date="05-09-2016";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calender);
		calendarView = (CalendarView) findViewById(R.id.simpleCalendarView);
	
		
		
	
	}

}
