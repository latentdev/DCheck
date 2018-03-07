package com.latentdev.d_check;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by latentdev on 7/22/2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //connection and permission stuff

        //start main activity
        startActivity(new Intent(SplashActivity.this, MainActivity.class));

        //close activity
        finish();
    }
}
