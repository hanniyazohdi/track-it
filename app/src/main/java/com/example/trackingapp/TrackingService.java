package com.example.trackingapp;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class TrackingService {

    public static final String QUERY_FOR_CARRIER = "https://www.metaweather.com/api/location/search/?query=";
    // public static final String QUERY_FOR_STATUS = "https://www.metaweather.com/api/location/";

    Context context;
    String location;

    public TrackingService(Context context) {
        this.context = context;
    }

    // callback to schedule a method call to occur when another method finishes
    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(String carrierName);
    }

    public void getCarrier(String carrierName, VolleyResponseListener volleyResponseListener){

        String url = "https://www.metaweather.com/api/location/search/?query=" + carrierName;
        // String url ="http://shipit-api.herokuapp.com/api/carriers/" + postalcarrier.getText().toString() + "/" + trackingnumber.getText().toString();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONObject packageInfo = response.getJSONObject(0);
                    location = packageInfo.getString("location_type");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                volleyResponseListener.onResponse(location);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("ERROR!");
            }

        });
        MySingleton.getInstance(context).addToRequestQueue(request);

    }


    // callback to schedule a method call to occur when another method finishes
    public interface StatusResponse{
        void onError(String message);
        void onResponse(TrackingStatusModel trackingStatusModel);
    }

//    public void getStatus(String carrierName, StatusResponse statusResponse){
//
//        List<TrackingStatusModel> status = new ArrayList<>();
//        String url = QUERY_FOR_STATUS + carrierName;
//
//        // get the json object
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                // Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
//
//                try {
//                    JSONArray consolidated_weather_list = response.getJSONArray("consolidated_weather");
//
//                    // get the first item in the tracking model
//                    TrackingStatusModel first_day = new TrackingStatusModel();
//                    JSONObject first_day_from_api = (JSONObject) consolidated_weather_list.get(0);
//
//                    first_day.setId(first_day_from_api.getInt("id"));
//                    first_day.setWeather_state_name(first_day_from_api.getString("weather_state_name"));
//                    first_day.setWeather_state_abbr(first_day_from_api.getString("weather_state_abbr"));
//                    first_day.setWind_direction_compass(first_day_from_api.getString("wind_direction_compass"));
//                    first_day.setCreated(first_day_from_api.getString("applicable_date"));
//                    first_day.setMin_temp(first_day_from_api.getLong("min_temp"));
//                    first_day.setMax_temp(first_day_from_api.getLong("max_temp"));
//                    first_day.setThe_temp(first_day_from_api.getLong("the_temp"));
//                    first_day.setMin_temp(first_day_from_api.getLong("min_temp"));
//                    first_day.setWind_speed(first_day_from_api.getLong("wind_speed"));
//                    first_day.setWind_direction(first_day_from_api.getLong("wind_direction"));
//                    first_day.setAir_pressure(first_day_from_api.getInt("air_pressure"));
//                    first_day.setHumidity(first_day_from_api.getInt("humidity"));
//                    first_day.setVisibility(first_day_from_api.getLong("visibility"));
//                    first_day.setPredictability(first_day_from_api.getInt("predictability"));
//
//                    statusResponse.onResponse(first_day);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        // get the property called "consolodated_weather" which is an array
//
//
//        // get each item in the array
//
//        MySingleton.getInstance(context).addToRequestQueue(request);
//    }


}
