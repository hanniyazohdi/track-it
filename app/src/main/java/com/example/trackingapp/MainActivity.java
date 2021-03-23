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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trackingapp.ui.dashboard.SplashActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    Button track;
    EditText postalcarrier, trackingnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // startActivity(new Intent(MainActivity.this, SplashActivity.class));
        // finish();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Log.d( "Life Cycle Event: ", "In onCreate");

        // button declarations
        track = findViewById(R.id.trackitbutton);

        // text input declarations
        postalcarrier = findViewById(R.id.postalcarrier);
        trackingnumber = findViewById(R.id.trackingnumber);

        // button event listener
        track.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // VOLLEY HTTP REQUEST

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                String url ="https://www.metaweather.com/api/location/search/?query=" + postalcarrier.getText().toString();

                // String url ="http://shipit-api.herokuapp.com/api/carriers/" + postalcarrier.getText().toString() + "/" + trackingnumber.getText().toString();

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        String location = "";

                        try {
                            JSONObject packageInfo = response.getJSONObject(0);
                            location = packageInfo.getString("location");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(MainActivity.this, "Location = " + title, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                });

                queue.add(request);

            }
        });

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