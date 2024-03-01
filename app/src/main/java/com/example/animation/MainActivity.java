package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    Button cov;
    LottieAnimationView lot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //removes the status bar

         cov = findViewById(R.id.covid_test);
         lot = findViewById(R.id.animation);

        cov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lot.setVisibility(View.VISIBLE);
                cov.setVisibility(View.INVISIBLE);
                lot.playAnimation();
                Thread td = new Thread(){
                    public void run(){
                        try{
                            sleep(3000);
                        }catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        finally {
                            Intent intent = new Intent(MainActivity.this,details_activity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };td.start();

            }
        });
    }


}