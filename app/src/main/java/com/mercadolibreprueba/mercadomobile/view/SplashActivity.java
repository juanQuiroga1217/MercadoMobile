package com.mercadolibreprueba.mercadomobile.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.mercadolibreprueba.mercadomobile.R;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startApp();
    }

    private void startApp() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(()->{
            Intent intentSearch = new Intent(SplashActivity.this, SearchActivity.class);
            startActivity(intentSearch);
            finish();
        }, 500);
    }
}
