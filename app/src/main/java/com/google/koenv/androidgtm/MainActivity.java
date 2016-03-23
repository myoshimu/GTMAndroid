package com.google.koenv.androidgtm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart(){
        super.onStart();
        sendScreenView("Home");
    }

    public void sendScreenView(String screenName){
        DataLayer dataLayer = TagManager.getInstance(this).getDataLayer();
        dataLayer.pushEvent("OpenScreen", DataLayer.mapOf("screenName", screenName));
    }
}
