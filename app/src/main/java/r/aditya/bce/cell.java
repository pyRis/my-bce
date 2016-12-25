package r.aditya.bce;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class cell extends Activity {
	TextView t1,t6,t3,t5;
	ImageView im;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.club_cell);
		t1=(TextView)findViewById(R.id.textView1);
		t3=(TextView)findViewById(R.id.textView3);
		t5=(TextView)findViewById(R.id.textView5);
		t6=(TextView)findViewById(R.id.textView6);
		im=(ImageView)findViewById(R.id.imageView1);
		String data = getIntent().getExtras().getString("Data");

		//TODO(2): Delete this class or make a better work out of it.

		switch (data) {

			case "1":
				/*
				t1.setText("Academic Cell");//title
				t3.setText("To deal with the prevalent academic issues in the college which includes all-time availability of needed books in the library, ascertaining the issue of provided syllabi,  organizing events like debates,quizzes,etc.among the students to ensure their development");
				t6.setText("Bce_acad@gmail.com");//email
				im.setImageResource(R.drawable.academic);*/

				Global_Function.InfoAppDialog(cell.this, "Student Council", "Under construction");
				break;
			case "2":
				/*
				t1.setText("Academic Cell");//title
				t3.setText("To deal with the prevalent academic issues in the college which includes all-time availability of needed books in the library, ascertaining the issue of provided syllabi,  organizing events like debates,quizzes,etc.among the students to ensure their development");
				t6.setText("Bce_acad@gmail.com");//email
				im.setImageResource(R.drawable.academic);*/

				Global_Function.InfoAppDialog(cell.this, "Academic Cell", "Under construction");
				break;
			case "3":
				/*
				t1.setText("Alumni Cell");//title
				t3.setText("Build a strong relationship and a global family of BCEian to garner alumni’s mentorship and support for BCE development. Cross sharing of Alumni information so that alumni world also gets support from each other.");
				t6.setText("Bce_alum@gmail.com");//email
				im.setImageResource(R.drawable.alumni);
				*/
				Global_Function.InfoAppDialog(cell.this, "Alumni Cell", "Under construction");
				break;
			case "4":
				/*
				t1.setText("Placement Cell");//title
				t3.setText("To ensure better placement opportunity for students by creating strong industry connect & alumni support  and to highlight college strength to attract corporate to BCE");
				t6.setText("Bceplacement2016@gmail.com");//email
				im.setImageResource(R.drawable.placement_cell);*/

				Global_Function.InfoAppDialog(cell.this, "Placement Cell", "Under construction");

				break;
			case "5":
				/*
				t1.setText("Media Cell");//title
				t3.setText("To ensure better publicity of the institute's activities through various media outlets.");
				t6.setText("Connecttobce@gmail.com");//email
				im.setImageResource(R.drawable.media);*/
				Global_Function.InfoAppDialog(cell.this, "Media Cell", "Under construction");

				break;
			case "6":
				/*
				t1.setText("Sports Cell");//title
				t3.setText("To promote sports in BCE premises by ensuring concerned sports grounds, coaches and necessary resources and organizing different level sports events and establishment of Yoga & Gym Club in BCE");
				t6.setText("Bce_sports@gmail.com");//email
				im.setImageResource(R.drawable.sports);
				*/
				Global_Function.InfoAppDialog(cell.this, "Sports cell", "Under construction");
				break;
			case "7":
				/*
				t1.setText("Disciplinary Cell");//title
				t3.setText("To develop a responsive and accountable attitude among all students in order to maintain a harmonious educational atmosphere in the institute.");
				t6.setText("Bce_disciplinary_committee@gmail.com");//email
				im.setImageResource(R.drawable.disipline);*/
				Global_Function.InfoAppDialog(cell.this, "Disciplinary Committee", "Under construction");
				break;
			case "8":
				/*
				t1.setText("Cultural Cell");//title
				t3.setText("To promote cultural activities by organizing various cultural events,  providing a platform which  brings exposure of students for their holistic development.");
				t6.setText("Bce_cul@gmail.com");//email
				im.setImageResource(R.drawable.culture);
				*/
				Global_Function.InfoAppDialog(cell.this, "Cultural Cell", "Under construction");
				break;
			case "9":
				/*
				t1.setText("Focus Cell");//title
				t3.setText("To provide guidance, materials n mentorship by alumni, counseling to students preparing for specific exams like Civil Services, PSU, GATE, MBA, IT Sector etc");
				t6.setText("Bcefocuscell016@gmail.com");//email
				im.setImageResource(R.drawable.focus);
				*/
				Global_Function.InfoAppDialog(cell.this, "Focus Cell", "Under construction");
				break;
			case "10":
				/*
				t1.setText("Tech Cell");//title
				t3.setText("To maintain bce website and app, providing technical support to different programs or events of bce with ensuring technical resources");
				t6.setText("Bce_tech@gmail.com");//email
				im.setImageResource(R.drawable.techcell);
*/
				Global_Function.InfoAppDialog(cell.this, "Tech Cell", "Under construction");
				break;
			case "11":
				/*
				t1.setText("Entrepreneurship Cell");//title
				t3.setText("To inspires students to pursue entrepreneurship&creating strong ecosystem by bringing together a diverse set of people who all share the same passion");
				t6.setText("Bce_enterpreneurship@gmail.com");//email
				im.setImageResource(R.drawable.ent);
				*/
				Global_Function.InfoAppDialog(cell.this, "Entrepreneurship Cell", "Under construction");
				break;
			case "12":
				/*
				t1.setText("Election/Survey Cell");//title
				t3.setText("To conduct online surveys and transparent selection processes for finalization of initiatives and leaders respectively.");
				t6.setText("Bce_election@gmail.com");//email
				im.setImageResource(R.drawable.election);
				*/
				Global_Function.InfoAppDialog(cell.this, "Election/survey Cell", "Under construction");
				break;
			case "13":
				/*
				t1.setText("Skill Development Cell");//title
				t3.setText("To supplement students with different programs, lectures to groom their personalities by improving their communication, presentation, software, skillsunder constant guidance of experts and professionals");
				t6.setText("Bce_skill@gmail.com");//email
				im.setImageResource(R.drawable.skill);
				*/
				Global_Function.InfoAppDialog(cell.this, "Skill Development Cell", "Under construction");
				break;
			case "14":
				/*
				t1.setText("Fund Management Cell");//title
				t3.setText("To ensure effective utilization and due diligence for expenditure, prepare an audited report of expenditure in line with transparent fund management system");
				t6.setText("Bce_fund@gmail.com");//email
				im.setImageResource(R.drawable.fund);
				*/
				Global_Function.InfoAppDialog(cell.this, "Fund Management Cell", "Under construction");
				break;
			case "15":
				/*
				t1.setText("Social Impact Cell");//title
				t3.setText("To build and support strong community of socially conscious students by engaging them in work that  impact the community to outreach BCE beyond horizon");
				t6.setText("Bce_social@gmail.com");//email
				im.setImageResource(R.drawable.socia);
				*/
				Global_Function.InfoAppDialog(cell.this, "Social Impact Cell", "Under construction");
				break;
			case "16":
				/*
				t1.setText("Speaker Series Cell");//title
				t3.setText("To invite industry leaders, business heads, distinguished alumni,  Civil Servants, Entrepreneur, Academicians etc in order to develop leadership qualities and evolve them as a better professionals");
				t6.setText("Bce_spe@gmail.com");//email
				im.setImageResource(R.drawable.specker);
				*/
				Global_Function.InfoAppDialog(cell.this, "Speaker Series Cell", "Under construction");
				break;
			default:
				break;
		}
	}

}
