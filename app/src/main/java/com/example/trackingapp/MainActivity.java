package com.example.trackingapp;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trackingapp.ui.dashboard.SplashActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    Button track;
    EditText postalcarrier, trackingnumber;
    TextView carriertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // startActivity(new Intent(MainActivity.this, SplashActivity.class));
        // finish();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Log.d( "Life Cycle Event: ", "In onCreate");


        // final TrackingService trackingservice = new TrackingService(MainActivity.this);

        // object declarations
        track = findViewById(R.id.trackitbutton);
        postalcarrier = findViewById(R.id.postalcarrier);
        trackingnumber = findViewById(R.id.trackingnumber);
        carriertext = (TextView) findViewById(R.id.carriertext);


        track.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                // String url = "https://www.metaweather.com/api/location/search/?query=london";
                String url = "http://shipit-api.herokuapp.com/api/carriers/fedex/784296727591";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String carrier = "";
                        try{

                             JSONObject carrierName = response.getJSONObject("service");
                             carrier = String.valueOf(carrierName);

                            VolleyLog.e("", carrier);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(MainActivity.this, carrier, Toast.LENGTH_SHORT).show();
                    }

                }, new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

                        VolleyLog.e("Error: ", error.toString());
                        VolleyLog.e("Error: ", error.getMessage());

                    }
                });

                queue.add(request);

            }
        });




        // button event listener
//        track.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//
//                trackingservice.getCarrier(postalcarrier.getText().toString(), new TrackingService.VolleyResponseListener() {
//                    @Override
//                    public void onError(String message) {
//                        Toast.makeText(MainActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(String carrierName) {
//                        Toast.makeText(MainActivity.this, "Returned location: " + carrierName, Toast.LENGTH_SHORT).show();
//                        // carriertext.setText(carrierName);
//                    }
//                });
//
//            }
//        });


        // button event listener
//        track.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//
//                trackingservice.getCarrier(postalcarrier.getText().toString(), new TrackingService.StatusResponse() {
//                    @Override
//                    public void onError(String message) {
//                        Toast.makeText(MainActivity.this,"Something wrong!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(TrackingStatusModel trackingStatusModel) {
//                        Toast.makeText(MainActivity.this, trackingStatusModel.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
//
//        });
//
   }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d( "Life Cycle Event: ", "In onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "Life Cycle Event: ", "In onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "Life Cycle Event: ", "In onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( "Life Cycle Event: ", "In onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( "Life Cycle Event: ", "In onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d( "Life Cycle Event: ", "In onRestart");
    }


}