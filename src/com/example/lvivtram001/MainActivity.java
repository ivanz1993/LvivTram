package com.example.lvivtram001;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import com.google.gson.reflect.TypeToken;
//import com.google.gson.reflect.TypeToken;

//import android.renderscript.Type;
import android.support.v7.app.ActionBarActivity;
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
         
        
        
        
        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            // виводимо  json-стрічку
           // String s="[{\"Angle\":3.1926728252539349,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":415,\"VehicleId\":34504,\"VehicleName\":\"1143\",\"X\":24.0371549,\"Y\":49.8397733},{\"Angle\":-33.697622349003922,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-107,\"VehicleId\":34505,\"VehicleName\":\"1105\",\"X\":24.0054966,\"Y\":49.8296166}]";
           // String s1="[{\"Angle\":8.5738645783643541,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":134,\"VehicleId\":34504,\"VehicleName\":\"1143\",\"X\":24.034365,\"Y\":49.841845},{\"Angle\":32.275644316189954,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":101,\"VehicleId\":34505,\"VehicleName\":\"1105\",\"X\":23.9924466,\"Y\":49.8238866},{\"Angle\":-148.39970227763735,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":290,\"VehicleId\":34506,\"VehicleName\":\"1098\",\"X\":24.0241283,\"Y\":49.8384266},{\"Angle\":-174.1079337826242,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":115,\"VehicleId\":34515,\"VehicleName\":\"1045\",\"X\":24.0447983,\"Y\":49.84063},{\"Angle\":145.93007236170539,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":125,\"VehicleId\":34520,\"VehicleName\":\"1047\",\"X\":24.0045083,\"Y\":49.83037},{\"Angle\":169.130916227571,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":175,\"VehicleId\":35152,\"VehicleName\":\"1090\",\"X\":24.0620133,\"Y\":49.8369416},{\"Angle\":27.687687019744139,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-64,\"VehicleId\":35157,\"VehicleName\":\"1100\",\"X\":24.0034683,\"Y\":49.8307683},{\"Angle\":25.6326524521499,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-66,\"VehicleId\":35169,\"VehicleName\":\"1123\",\"X\":24.0160966,\"Y\":49.8342766},{\"Angle\":-173.2484539742027,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-6,\"VehicleId\":35176,\"VehicleName\":\"1135\",\"X\":24.0302083,\"Y\":49.8410216},{\"Angle\":-10.681076870810419,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":336,\"VehicleId\":35179,\"VehicleName\":\"1139\",\"X\":24.0497766,\"Y\":49.839785}]";

            //strJson = s1;
           
            strJson =  strJson.replaceAll("\\s","");
            strJson = strJson.substring(0, 0) + strJson.substring(1);
            strJson = strJson.substring(0, strJson.length()-1) + strJson.substring(strJson.length());
          //  String s2="[{\"Angle\":14.010947318480779,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-10,\"VehicleId\":34504,\"VehicleName\":\"1143\",\"X\":24.0681033,\"Y\":49.8352116},{\"Angle\":-33.741214671878517,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":138,\"VehicleId\":34505,\"VehicleName\":\"1105\",\"X\":24.02231,\"Y\":49.836575},{\"Angle\":168.29043702998297,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-70,\"VehicleId\":34509,\"VehicleName\":\"1118\",\"X\":24.056955,\"Y\":49.8380883},{\"Angle\":-153.05804591196116,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":133,\"VehicleId\":34515,\"VehicleName\":\"1045\",\"X\":24.0089566,\"Y\":49.8307833},{\"Angle\":-165.57879628131249,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-51,\"VehicleId\":34520,\"VehicleName\":\"1047\",\"X\":24.043385,\"Y\":49.8402983},{\"Angle\":32.969403904006342,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-296,\"VehicleId\":34523,\"VehicleName\":\"1073\",\"X\":23.992845,\"Y\":49.8241433},{\"Angle\":144.41856684842148,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":86,\"VehicleId\":35081,\"VehicleName\":\"1126\",\"X\":24.0221683,\"Y\":49.8367366},{\"Angle\":30.731647614887123,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":-10,\"VehicleId\":35152,\"VehicleName\":\"1090\",\"X\":23.9976183,\"Y\":49.8271},{\"Angle\":0.0,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":2,\"TimeToPoint\":-2057,\"VehicleId\":35163,\"VehicleName\":\"1109\",\"X\":23.9921816,\"Y\":49.8346433},{\"Angle\":178.8097162331436,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":110,\"VehicleId\":35169,\"VehicleName\":\"1123\",\"X\":24.037645,\"Y\":49.8399366},{\"Angle\":12.674251226428433,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":91,\"VehicleId\":35176,\"VehicleName\":\"1135\",\"X\":24.0330233,\"Y\":49.8417016},{\"Angle\":9.4673444083947746,\"EndPoint\":\"\",\"RouteId\":5397,\"RouteName\":\"02\",\"StartPoint\":\"\",\"State\":1,\"TimeToPoint\":63,\"VehicleId\":35179,\"VehicleName\":\"1139\",\"X\":24.04439,\"Y\":49.84059}]";
           // strJson = s2;
            
            Log.d(LOG_TAG,strJson);
                 
           
           GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            /*List<Tram> trams = new ArrayList<Tram>();
            trams = Arrays.asList(gson.fromJson(strJson, Tram[].class));
            for (Tram i : trams)
    			Log.d(LOG_TAG, "X: " + i.x + "\nvehicleName: " + i.vehicleName+"\nAngle: "+ i.angle+"\n");*/
        }
    }
}