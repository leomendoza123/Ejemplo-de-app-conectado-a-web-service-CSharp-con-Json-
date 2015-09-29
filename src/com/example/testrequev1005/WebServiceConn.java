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

import Datos.Articulo;
import Datos.Atraccion;
import Datos.Plato;
import Datos.Restaurante;
import Datos.Show;
import Datos.Tienda;
import android.widget.TextView;
import android.widget.Toast;

public class WebServiceConn {
	
	public static ArrayList <Show> Shows = new ArrayList<Show>(); 
	public static ArrayList <Restaurante> Restaurantes= new ArrayList<Restaurante>(); 
	public static ArrayList <Tienda> Tiendas= new ArrayList<Tienda>(); 
	public static ArrayList <Atraccion> Atracciones= new ArrayList<Atraccion>(); 

	public static void getShows() {

		
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
				WebServiceConn.getRestaurantes(); 
								
			}
		
			
		};
		nt.start();
	}
		

	public static void getRestaurantes() {
		
		Thread nt = new Thread(){
			String res; 
			@Override
			public void run(){
				
				
				/////// PETICION AL WEBSERVICE
				
				String NAMESPACE = "http://tempuri.org/"; 
				String URL = "http://201.201.163.14/Reque/WebService.asmx"; 
				String METHOD_NAME = "getRestaurantes"; /// Cambio el nombre de la funcion 
				String SOAP_ACTION = "http://tempuri.org/getRestaurantes"; // Cambiar despues del / por el nombre de la funcion 
				
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
					      ArrayList<Plato> platos = new ArrayList<Plato>(); 
					      JSONArray  SubjArray =  Jobject.getJSONArray("platos"); 
					      for(int ii = 0; ii < SubjArray.length(); ii++){
					    	  JSONObject SubJobject = SubjArray.getJSONObject(ii); 
					    	  Plato plato = new Plato(
					    			  SubJobject.getString("nombre"), SubJobject.getString("descripcion"));
					    	  platos.add(plato); 
					      }
					      
					      
					      Restaurante newObjectRestaurante =
					    		  
					    		  new Restaurante(
						    		  Jobject.getString("nombre"),
						    		  Jobject.getString("horario"),
						    		  platos);
						    		  
					      WebServiceConn.Restaurantes.add(newObjectRestaurante);
					      
					      
					}
				}
				catch (Exception ex){
					ex.printStackTrace();
					
				}
				WebServiceConn.getTiendas();
				
								
			}
		
			
		};
		nt.start();
		
	}

	

	public static void getTiendas() {
		
		Thread nt = new Thread(){
			String res; 
			@Override
			public void run(){
				
				
				/////// PETICION AL WEBSERVICE
				
				String NAMESPACE = "http://tempuri.org/"; 
				String URL = "http://201.201.163.14/Reque/WebService.asmx"; 
				String METHOD_NAME = "GetTiendas"; /// Cambio el nombre de la funcion 
				String SOAP_ACTION = "http://tempuri.org/GetTiendas"; // Cambiar despues del / por el nombre de la funcion 
				
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
					      ArrayList<Articulo> articulos = new ArrayList<Articulo>(); 
					      JSONArray  SubjArray =  Jobject.getJSONArray("articulos"); 
					      for(int ii = 0; ii < SubjArray.length(); ii++){
					    	  JSONObject SubJobject = SubjArray.getJSONObject(ii); 
					    	  Articulo articulo = new Articulo( 
					    			  SubJobject.getString("nombre"), 
					    			  SubJobject.getString("precio"),
					    			  SubJobject.getInt("cantidad")
					    			  );
					    	  articulos.add(articulo); 
					      }
					      
					      
					      Tienda newObjectRestaurante =
					    		  
					    		  new Tienda(
						    		  Jobject.getString("nombre"),
						    		  Jobject.getString("horario"),
						    		  articulos);
						    		  
					      WebServiceConn.Tiendas.add(newObjectRestaurante);
					      
					      
					}
				}
				catch (Exception ex){
					ex.printStackTrace();
					
				}

				WebServiceConn.getAtracciones();
								
			}
		
			
		};
		nt.start();
		
	}

	public static void getAtracciones() {

		
		Thread nt = new Thread(){
			String res; 
			@Override
			public void run(){
				
				
				/////// PETICION AL WEBSERVICE
				
				String NAMESPACE = "http://tempuri.org/"; 
				String URL = "http://201.201.163.14/Reque/WebService.asmx"; 
				String METHOD_NAME = "GetAtracciones"; /// Cambio el nombre de la funcion 
				String SOAP_ACTION = "http://tempuri.org/GetAtracciones"; // Cambiar despues del / por el nombre de la funcion 
				
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
					      Atraccion newObjectAtraccion =
					    		  
					    		  new Atraccion(
						    		  Jobject.getString("categoria"),
						    		  Jobject.getString("nombre"),
						    		  Jobject.getString("horario"),
						    		  Jobject.getString("estado"),
						    		  Jobject.getInt("espera"));
						      
					      
					      WebServiceConn.Atracciones.add(newObjectAtraccion);
					      
					      
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
