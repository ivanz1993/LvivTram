package com.example.lvivtram001;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
//import com.google.gson.reflect.TypeToken;

//import android.renderscript.Type;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends ActionBarActivity {
	public static String LOG_TAG = "my_log";
	public static final String SERVER_URL = "http://82.207.107.126:13541/SimpleRIDE/LET/SM.WebApi/api/RouteMonitoring/5397";
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        new ParseTask().execute();
      //  String s="[{\"Angle\":3.1926728252539349,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":415,\"VehicleId\":34504,\"VehicleName\":\"1143\",\"X\":24.0371549,\"Y\":49.8397733},{\"Angle\":-33.697622349003922,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-107,\"VehicleId\":34505,\"VehicleName\":\"1105\",\"X\":24.0054966,\"Y\":49.8296166}]";
       // String s="{\"Angle\":3.1926728252539349,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":415,\"VehicleId\":34504,\"VehicleName\":\"1143\",\"X\":24.0371549,\"Y\":49.8397733}";
    }

    private class ParseTask extends AsyncTask<Void, Void, String> {
    	 
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";
 
        @Override
        protected String doInBackground(Void... params) {
            // отримуємо дані
            try {
                URL url = new URL(SERVER_URL);
 
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
 
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
 
                reader = new BufferedReader(new InputStreamReader(inputStream));
 
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
 
                resultJson = buffer.toString();
 
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }
         
        private void writeToFile(String data) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("config.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write(data);
                outputStreamWriter.close();
            }
            catch (IOException e) {
                Log.e("Exception", "File write failed: " + e.toString());
            } 
        }


       
        
        
        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            // виводимо  json-стрічку
           // String s="[{\"Angle\":3.1926728252539349,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":415,\"VehicleId\":34504,\"VehicleName\":\"1143\",\"X\":24.0371549,\"Y\":49.8397733},{\"Angle\":-33.697622349003922,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-107,\"VehicleId\":34505,\"VehicleName\":\"1105\",\"X\":24.0054966,\"Y\":49.8296166}]";
            //strJson = s1;
           
               
            Log.d(LOG_TAG,strJson);
               
            
           GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<Vehicle> vehicles = new ArrayList<Vehicle>();
               strJson = strJson.replace("\\\"", "\"");    
               strJson = strJson.substring(1, strJson.length() - 1);
	            vehicles = Arrays.asList(gson.fromJson(strJson, Vehicle[].class));
	            for (Vehicle i : vehicles)    			Log.d(LOG_TAG, "X: " + i.x + "\nvehicleName: " + i.vehicleName+"\nAngle: "+ i.angle+"\n");
            
        }
    }
}