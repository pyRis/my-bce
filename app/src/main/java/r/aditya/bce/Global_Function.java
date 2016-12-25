
package r.aditya.bce;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.DisplayMetrics;

import android.widget.ImageView;
/**
 * @author Ravindra & aditya
 * 
 */
public class Global_Function {

	
	 private final static String HEX = "0123456789ABCDEF";

	   private final static int JELLY_BEAN_4_2 = 17;

	   private final static byte[] key = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	 //---------------------------Starting Internet Connectivity Check---------------------------------------
	    private Context _context;
	     
	    public Global_Function(Context context){
	        this._context = context;
	    }
	 
	    public boolean isConnectingToInternet(){
	        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
	          if (connectivity != null) 
	          {
	              NetworkInfo[] info = connectivity.getAllNetworkInfo();
	              if (info != null) 
	                  for (int i = 0; i < info.length; i++) 
	                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
	                      {
	                          return true;
	                      }
	 
	          }
	          return false;
	    }
	    //---------------------------Ending Internet Connectivity Check---------------------------------------
	 

	   // static {

	  // Security.addProvider(new BouncyCastleProvider());

	  // }

	    //---------------------------Starting Encryption/decryption Function---------------------------------------
	    //encrypt
	   public static String encrypt(String seed, String cleartext) throws Exception {

	    byte[] rawKey = getRawKey(seed.getBytes());

	    byte[] result = encrypt(rawKey, cleartext.getBytes());

	    String fromHex = toHex(result);

	    String base64 = new String(Base64.encodeToString(fromHex.getBytes(), 0));

	    return base64;

	   }
	   //decrypt
	   public static String decrypt(String seed, String encrypted) throws Exception {

	   byte[] seedByte = seed.getBytes();

	    System.arraycopy(seedByte, 0, key, 0, ((seedByte.length < 16) ? seedByte.length : 16));

	    String base64 = new String(Base64.decode(encrypted, 0));

	  byte[] rawKey = getRawKey(seedByte);

	   byte[] enc = toByte(base64);

	   byte[] result = decrypt(rawKey, enc);

	    return new String(result);

	   }
	 //encrypt in byte
	 public static byte[] encryptBytes(String seed, byte[] cleartext) throws Exception {

	    byte[] rawKey = getRawKey(seed.getBytes());

	    byte[] result = encrypt(rawKey, cleartext);

	   return result;

	  }	 
	//decrypt in byte
	   public static byte[] decryptBytes(String seed, byte[] encrypted) throws Exception {

	   byte[] rawKey = getRawKey(seed.getBytes());

	    byte[] result = decrypt(rawKey, encrypted);

	   return result;

	   }

	   private static byte[] getRawKey(byte[] seed) throws Exception {

	   KeyGenerator kgen = KeyGenerator.getInstance("AES"); // , "SC");

	  SecureRandom sr = null;

	    if (android.os.Build.VERSION.SDK_INT >= JELLY_BEAN_4_2) {

	     sr = SecureRandom.getInstance("SHA1PRNG", "Crypto");

	   } else {

	     sr = SecureRandom.getInstance("SHA1PRNG");

	    }

	   sr.setSeed(seed);

	   try {

	     kgen.init(256, sr);

	     // kgen.init(128, sr);

	  } catch (Exception e) {

	     // Log.w(LOG, "This device doesn't support 256bits, trying 192bits.");

	     try {

	      kgen.init(192, sr);

	    } catch (Exception e1) {

	     // Log.w(LOG, "This device doesn't suppor 192bits, trying 128bits.");

	      kgen.init(128, sr);

	     }

	    }

	   SecretKey skey = kgen.generateKey();

	    byte[] raw = skey.getEncoded();

	   return raw;

	   }

	 

	   private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {

	    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

	  Cipher cipher = Cipher.getInstance("AES"); // /ECB/PKCS7Padding", "SC");

	    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

	    byte[] encrypted = cipher.doFinal(clear);

	   return encrypted;

	  }



	   private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {

	   SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

	   Cipher cipher = Cipher.getInstance("AES"); // /ECB/PKCS7Padding", "SC");

	    cipher.init(Cipher.DECRYPT_MODE, skeySpec);

	   byte[] decrypted = cipher.doFinal(encrypted);

	   return decrypted;

	   }



	  public static String toHex(String txt) {

	   return toHex(txt.getBytes());

	 }





	  public static String fromHex(String hex) {

	   return new String(toByte(hex));  }





	  public static byte[] toByte(String hexString) {

	   int len = hexString.length() / 2;

	   byte[] result = new byte[len];

	   for (int i = 0; i < len; i++)

	   result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
	   return result;

	  }




	  public static String toHex(byte[] buf) {

	   if (buf == null)

	    return "";

	   StringBuffer result = new StringBuffer(2 * buf.length);

	   for (int i = 0; i < buf.length; i++) {

	   appendHex(result, buf[i]);

	   }

	   return result.toString();

	  }



	  private static void appendHex(StringBuffer sb, byte b) {

	  sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));

	 }
	  //---------------------------Ending Encryption/decryption Function---------------------------------------
	  //-----------------------Start Function For ALL TYPE OF Alert-------------------------------
	  
	  public static void WarningAppDialog(final Activity activity,CharSequence msgtitle,CharSequence msg)
	  {

	  	// TODO Auto-generated method stub
	  				AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
	  				 
	  		        // Setting Dialog Title
	  		        alertDialog.setTitle(msgtitle);
	  		 
	  		        // Setting Dialog Message
	  		        alertDialog.setMessage(msg);
	  		 
	  		        // Setting Icon to Dialog
	  		       // alertDialog.setIcon(R.drawable.warning);
	  		 
	  		        // Setting Positive "Yes" Button
	  		        alertDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
	  		            public void onClick(DialogInterface dialog,int which) {
	  		            	dialog.cancel();
	  		            	
	  		            // Write your code here to invoke YES event
	  		           // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
	  		            }
	  		        });
	  		 
	  		        // Setting Negative "NO" Button
	  		        alertDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
	  		            public void onClick(DialogInterface dialog, int which) {
	  		            // Write your code here to invoke NO event
	  		            //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
	  		            	
	  		            
	  		                // final Global_variable gb= new Global_variable();
	  		             
	  		               // gb.setName("1");
	  		            	
	  		            }
	  		        });
	  		 
	  		        // Showing Alert Message
	  		        alertDialog.show();
	  }
	  //---------------------------Starting Exit Application Alert Dialog Box---------------------------------------
	  public static void ExitAppDialog(final Activity activity,CharSequence msgtitle,CharSequence msg)
	  {
	  AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);

	  // Setting Dialog Title
	  alertDialog.setTitle(msgtitle);

	  // Setting Dialog Message
	  alertDialog.setMessage(msg);

	  // Setting Icon to Dialog  
	 // alertDialog.setIcon(R.drawable.warning);

	  // Setting Positive "Yes" Button
	  alertDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
	      public void onClick(DialogInterface dialog,int which) {
	      	dialog.cancel();
	      // Write your code here to invoke YES event
	     // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
	      }
	  });

	  // Setting Negative "NO" Button
	  alertDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
	      public void onClick(DialogInterface dialog, int which) {
	      // Write your code here to invoke NO event
	      //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
	      
	      	activity.finish();
	      	System.exit(0);
	      }
	  });

	  // Showing Alert Message
	  alertDialog.show();
	  }
	  //---------------------------Ending Exit Application Alert Dialog Box---------------------------------------

	  //---------------------------Starting Network Check Application Alert Dialog Box---------------------------------------

	  @SuppressWarnings("deprecation")
	  public static void Network_Connection_check(final Activity activity ,CharSequence msgtitle,CharSequence msg )
	  {
	  AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

	  // Setting Dialog Title
	  alertDialog.setTitle(msgtitle);

	  // Setting Dialog Message
	  alertDialog.setMessage(msg);
	  //
	  // Setting Icon to Dialog
	 // alertDialog.setIcon(R.drawable.nonetwork);

	  // Setting OK Button

	  alertDialog.setButton2("OK",new DialogInterface.OnClickListener() {

	  @Override
	  public void onClick(DialogInterface dialog, int which) {
	  	// TODO Auto-generated method stub
			activity.finish();
	  }
	  });

	  // Showing Alert Message
	  alertDialog.show();
	  }
	  
	  //overloading
	  
	  @SuppressWarnings("deprecation")
	  public static void Network_Connection_check(final Context frag ,CharSequence msgtitle,CharSequence msg )
	  {
	  AlertDialog alertDialog = new AlertDialog.Builder(frag).create();

	  // Setting Dialog Title
	  alertDialog.setTitle(msgtitle);

	  // Setting Dialog Message
	  alertDialog.setMessage(msg);
	  //
	  // Setting Icon to Dialog
	 // alertDialog.setIcon(R.drawable.nonetwork);

	  // Setting OK Button

	  alertDialog.setButton2("OK",new DialogInterface.OnClickListener() {

	  @Override
	  public void onClick(DialogInterface dialog, int which) {
	  	// TODO Auto-generated method stub
	  	
	  }
	  });

	  // Showing Alert Message
	  alertDialog.show();
	  }
	  //---------------------------Ending Network Check Application Alert Dialog Box---------------------------------------

	  //---------------------------Starting Success Application Alert Dialog Box---------------------------------------

	  @SuppressWarnings("deprecation")
	  public static void SuccessAppDialog(final Activity activity ,CharSequence msgtitle,CharSequence msg )
	  {
	  AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

	  //Setting Dialog Title
	  alertDialog.setTitle(msgtitle);

	  //Setting Dialog Message
	  alertDialog.setMessage(msg);
	  //
	  //Setting Icon to Dialog
	  //alertDialog.setIcon(R.drawable.sucess);

	  //Setting OK Button

	  alertDialog.setButton2("OK",new DialogInterface.OnClickListener() {

	  @Override
	  public void onClick(DialogInterface dialog, int which) {
	  	// TODO Auto-generated method stub
	  	
	  }
	  });

	  //Showing Alert Message
	  alertDialog.show();
	  }
	  
	  
	
	  
	  public static void InfoAppDialog(final Activity activity ,CharSequence msgtitle,CharSequence msg )
	  {
	  AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

	  //Setting Dialog Title
	  alertDialog.setTitle(msgtitle);

	  //Setting Dialog Message
	  alertDialog.setMessage(msg);
	  //
	  //Setting Icon to Dialog
	  //alertDialog.setIcon(R.drawable.info);

	  //Setting OK Button

	  alertDialog.setButton2("OK",new DialogInterface.OnClickListener() {

	  @Override
	  public void onClick(DialogInterface dialog, int which) {
	  	// TODO Auto-generated method stub
		 /* Intent startMain = new Intent(Intent.ACTION_MAIN);
		  startMain.addCategory(Intent.CATEGORY_HOME);
		  startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		  startActivity(hrms.manavsampada.jh_iasleave.MainActivity.this);*/
		 
		  return;
	  }
	  });

	  //Showing Alert Message
	  alertDialog.show();
	  }
	  //---------------------------Ending Sucess Application Alert Dialog Box---------------------------------------

	  //---------------------------Starting Sucess Application Alert Dialog Box---------------------------------------

	 

	@SuppressWarnings("deprecation")
	  public static void ErrorAppDialog(final Activity activity ,CharSequence msgtitle,CharSequence msg )
	  {
	  AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

	  //Setting Dialog Title
	  alertDialog.setTitle(msgtitle);

	  //Setting Dialog Message
	  alertDialog.setMessage(msg);
	  //
	  //Setting Icon to Dialog
	  //alertDialog.setIcon(R.drawable.error);

	  //Setting OK Button

	  alertDialog.setButton2("OK",new DialogInterface.OnClickListener() {

	  @Override
	  public void onClick(DialogInterface dialog, int which) {
	  	// TODO Auto-generated method stub
	  	
	  }
	  });

	  //Showing Alert Message
	  alertDialog.show();
	  }
	  //---------------------------Ending Sucess Application Alert Dialog Box---------------------------------------
	 public static void NoNetwork_Dialog(final Activity activity,CharSequence msgtitle,CharSequence msg)
	  {
	  AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);

	  // Setting Dialog Title
	  alertDialog.setTitle(msgtitle);

	  // Setting Dialog Message
	  alertDialog.setMessage(msg);

	  // Setting Icon to Dialog  
	  //alertDialog.setIcon(R.drawable.nonetwork);

	  // Setting Positive "Yes" Button
	  alertDialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
	      public void onClick(DialogInterface dialog,int which) {
	      	dialog.cancel();
	      // Write your code here to invoke YES event
	     // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
	      }
	  });

	  // Setting Negative "NO" Button
	  alertDialog.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
	      public void onClick(DialogInterface dialog, int which) {
	      // Write your code here to invoke NO event
	      //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
	    	 
	      
	      
	      }
	  });

	  // Showing Alert Message
	  alertDialog.show();
	  }
	  //-----------------------ENDS Function For ALL TYPE OF Alert-------------------------------

	  
	  
	  //----------json formatter------//
	  
	  public static String JSONFormater(String json) {
		 String json1=json.toString().replace('\\', ' ');
		 String json2 = json1.substring(0,json1.indexOf(':')+1);
          json1=json1.substring(json2.length()+1,(json1.length()-2));
          return (json2.concat(json1).concat("}"));
	  }
	  public static void ShowProgress(ProgressDialog pDialog, Activity act,String msg, boolean interminate, boolean cancel){		 
		  pDialog = new ProgressDialog(act);
          pDialog.setMessage(msg);
          pDialog.setIndeterminate(interminate);
          pDialog.setCancelable(cancel);          
          pDialog.show();
	  }
	  public static void HideProgress(ProgressDialog pDialog){		     
          pDialog.dismiss();
	  }
	
	  
	  //image thumnails
	  
	  public static void ThumnailImage(Activity act, String image, ImageView img_user ) {
			byte[] decodedBytes = Base64.decode(image, Base64.DEFAULT);
			Bitmap bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0,
					decodedBytes.length);
			DisplayMetrics dm = new DisplayMetrics();
			act.getWindowManager().getDefaultDisplay().getMetrics(dm);

			img_user.setMinimumHeight(dm.heightPixels);
			img_user.setMinimumWidth(dm.widthPixels);
			img_user.setImageBitmap(bitmap);
		}

}
