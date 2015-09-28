package com.example.testrequev1005;



import android.app.Activity;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
	
	public void EnviarOnclick(View v){

		
		Thread nt = new Thread(){
			String res; 
			@Override
			public void run(){
				String NAMESPACE = "http://tempuri.org/"; 
				String URL = "http://201.201.163.14/Reque/WebService.asmx"; 
				String METHOD_NAME = "Eventos"; 
				String SOAP_ACTION = "http://tempuri.org/Eventos"; 
				
				SoapObject request= new SoapObject(NAMESPACE, METHOD_NAME);
				
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); 
				envelope.dotNet = true; 
				envelope.setOutputSoapObject(request);
				
				HttpTransportSE trasporte = new HttpTransportSE(URL); 
				
				try {
					trasporte.call(SOAP_ACTION, envelope);
					SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse(); 
					res = resultado_xml.toString(); 
				} catch (HttpResponseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				runOnUiThread(new Runnable(){
					@Override 
					public void run(){
						Toast.makeText(MainActivity.this, res, Toast.LENGTH_LONG).show();
						TextView result =  (TextView) findViewById(R.id.textView_resultado); 
						result.setText(res);
					}	
				});
			}
		
			
		};
		nt.start();
				
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}
}
