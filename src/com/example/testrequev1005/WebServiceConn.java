package com.example.testrequev1005;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import Datos.Show;
import android.widget.TextView;
import android.widget.Toast;

public class WebServiceConn {
	
	public static ArrayList <Show> Shows; 

	public static void getShows() {

		Shows = new ArrayList<Show>(); 
		Thread nt = new Thread(){
			String res; 
			@Override
			public void run(){
				
				
				/////// PETICION AL WEBSERVICE
				
				String NAMESPACE = "http://tempuri.org/"; 
				String URL = "http://201.201.163.14/Reque/WebService.asmx"; 
				String METHOD_NAME = "getShows"; /// Cambio el nombre de la funcion 
				String SOAP_ACTION = "http://tempuri.org/getShows"; // Cambiar despues del / por el nombre de la funcion 
				
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
				
				
				//// CONVIERTE EL RESULTADO EN UNA LISTA DE OBJETOS
				
				try {
					JSONArray  jArray = new JSONArray(res);
					for(int i = 0; i < jArray.length(); i++)
					{
					      JSONObject Jobject = jArray.getJSONObject(i); 
					      Show newObjectAtraccion =
					    		  
					    		  new Show(
						    		  Jobject.getString("nombre"),
						    		  Jobject.getString("horario"),
						    		  Jobject.getString("lugar"),
						    		  Jobject.getString("descripcion"));
						      
					      
					      WebServiceConn.Shows.add(newObjectAtraccion);
					      
					      
					}
				}
				catch (Exception ex){
					ex.printStackTrace();
					
				}
								
			}
		
			
		};
		nt.start();
		
	}

}
