package com.airo.photoemptystateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView btnAddPhoto, titlePage, subtitlePage;
    Button btnPagePhoto, btnPageChat;
    View dotMenu;
    ImageView icStates;
    Animation btt, bttwo, imgbounce;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        imgbounce = AnimationUtils.loadAnimation(this, R.anim.imgbounce);

        btnAddPhoto = findViewById(R.id.btnaddphoto);
        btnAddPhoto.setPaintFlags(btnAddPhoto.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // give an event to next activity
        btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhotoCateActivity.class);
                startActivity(intent);
            }
        });

        titlePage = findViewById(R.id.titlepage);
        subtitlePage = findViewById(R.id.subtitlepage);

        btnPagePhoto = findViewById(R.id.btnpagephoto);
        btnPageChat = findViewById(R.id.btnpagechate);

        dotMenu = findViewById(R.id.dotmenu);

        icStates = findViewById(R.id.icstates);

        btnPageChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icStates.setImageResource(R.drawable.clerk);
                titlePage.setText("No One Chat");
                subtitlePage.setText("Build a circle that impact society");

                btnAddPhoto.setText("Find a Friend");
                btnAddPhoto.setTextColor(Color.parseColor("#DF5F7D"));

                // Pass Animation
                icStates.startAnimation(imgbounce);
                titlePage.startAnimation(btt);
                subtitlePage.startAnimation(bttwo);
                btnAddPhoto.startAnimation(bttwo);

                // Another Animation + img resource
                btnPagePhoto.setBackgroundResource(R.drawable.icccircledim);
                btnPageChat.setBackgroundResource(R.drawable.icchat);

                btnPagePhoto.animate().scaleY(0.7f).scaleX(0.7f).setDuration(350).start();
                btnPageChat.animate().scaleY(1).scaleX(1).setDuration(350).start();

                dotMenu.animate().translationX(230).setDuration(350).setStartDelay(100).start();
            }
        });

        btnPagePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icStates.setImageResource(R.drawable.photographer);
                titlePage.setText("No Photos");
                subtitlePage.setText("Add a picture for your circle");

                btnAddPhoto.setText("Add Photo");
                btnAddPhoto.setTextColor(Color.parseColor("#706AC9"));

                // Pass Animation
                icStates.startAnimation(imgbounce);
                titlePage.startAnimation(btt);
                subtitlePage.startAnimation(bttwo);
                btnAddPhoto.startAnimation(bttwo);

                // Another Animation + img resource
                btnPagePhoto.setBackgroundResource(R.drawable.icccircle);
                btnPageChat.setBackgroundResource(R.drawable.icchatdim);

                btnPageChat.animate().scaleY(0.7f).scaleX(0.7f).setDuration(350).start();
                btnPagePhoto.animate().scaleY(1).scaleX(1).setDuration(350).start();

                dotMenu.animate().translationX(0).setDuration(350).setStartDelay(100).start();
            }
        });
    }
}
