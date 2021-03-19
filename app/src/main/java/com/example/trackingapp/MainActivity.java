package com.example.trackingapp;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Log.d( "Life Cycle Event: ", "In onCreate");
    }

    public void disable (View v){
        findViewById(R.id.trackitbutton).setEnabled(false);
        ((Button)findViewById(R.id.trackitbutton)).setText("Tracking...");

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