package com.example.trackingapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TrackingService {

    public static final String QUERY_FOR_CARRIER = "http://shipit-api.herokuapp.com/api/carriers/";

    Context context;
    String details, carrier;
    public TrackingService(Context context) {
        this.context = context;
    }

    // callback to schedule a method call to occur when another method finishes
    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(String packageDetails);
    }

    public void packageDetails(TextView details1, TextView carrierText1, View locationicon,
                               TextView details2, TextView carrierText2, View locationicon2,
                               String carrierName, String trackingNumber, VolleyResponseListener volleyResponseListener){

        String url = QUERY_FOR_CARRIER + carrierName + "/" + trackingNumber;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                details = "";
                carrier = "";
                try {

                    JSONArray arr = response.getJSONArray("activities");
                    JSONObject latestDetail = arr.getJSONObject(0);
                    details = latestDetail.getString("details");
                    carrier = response.getString("service");

                    if(details1.getText().toString().equals("") && carrierText1.getText().toString().equals("")){
                        locationicon.setVisibility(View.VISIBLE);
                        details1.setText(details);
                        carrierText1.setText(carrier);

                    }else if(details2.getText().toString().equals("") && carrierText2.getText().toString().equals("")){
                        locationicon2.setVisibility(View.VISIBLE);
                        details2.setText(details);
                        carrierText2.setText(carrier);
                    }

                    Log.d("Carrier ", carrier);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                volleyResponseListener.onResponse(details);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("ERROR!");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }


}
