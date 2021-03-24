package com.example.trackingapp;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
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
    TextView carrierText1, details1, carrierText2, details2;
    View locationicon, locationicon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // startActivity(new Intent(MainActivity.this, SplashActivity.class));
        // finish();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Log.d( "Life Cycle Event: ", "In onCreate");

        // object declarations
        track = findViewById(R.id.trackitbutton);
        // input boxes
        postalcarrier = findViewById(R.id.postalcarrier);
        trackingnumber = findViewById(R.id.trackingnumber);

        // output text first box
        details1 = (TextView) findViewById(R.id.details1);
        carrierText1 = (TextView) findViewById(R.id.carrierText1);
        locationicon = (View) findViewById(R.id.locationicon);

        // output text second box
        details2 = (TextView) findViewById(R.id.details2);
        carrierText2 = (TextView) findViewById(R.id.carrierText2);
        locationicon2 = (View) findViewById(R.id.locationicon2);

        final TrackingService trackingservice = new TrackingService(MainActivity.this);

        // button event listener
        track.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                trackingservice.packageDetails(details1, carrierText1, locationicon,
                        details2, carrierText2, locationicon2,
                        postalcarrier.getText().toString(), trackingnumber.getText().toString(),
                        new TrackingService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String packageDetails) {

                        postalcarrier.setText("");
                        trackingnumber.setText("");
                    }
                });

            }
        });


        // button event listener
//        track.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//
//                trackingservice.getLastDetail(postalcarrier.getText().toString(), trackingnumber.getText().toString(), new TrackingService.StatusResponse() {
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