package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {

    Animation animFadeIn, animFadeOut, animFadeInOut;
    Animation animZoomIn, animZoomOut;
    Animation animLeftRight, animRightLeft, animTopBottom;
    Animation animBounce, animFlash, animRotate;

    ImageView imgLogo;
    TextView txtStatus, txtSeekBar;
    SeekBar seekBar;


    Button btnFadeIn, btnFadeOut, btnFadeInOut;
    Button btnZoomIn, btnZoomOut;
    Button btnLeftRight, btnRightLeft, btnTopBottom;
    Button btnBounce, btnFlash, btnRotate;

    int seekSpeedProgress;


    private static final String TAG = "TAG ANIM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadAnimations();
        loadUi();

    }

    private void loadAnimations()
    {
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeIn.setAnimationListener(this);

        animFadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        animFadeOut.setAnimationListener(this);

        animFadeInOut = AnimationUtils.loadAnimation(this,R.anim.fade_in_out);
        animFadeInOut.setAnimationListener(this);

        animZoomIn = AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        animZoomIn.setAnimationListener(this);

        animZoomOut = AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        animZoomOut.setAnimationListener(this);

        animLeftRight = AnimationUtils.loadAnimation(this,R.anim.left_right);
        animLeftRight.setAnimationListener(this);
        
        animTopBottom = AnimationUtils.loadAnimation(this,R.anim.top_bottom);
        animTopBottom.setAnimationListener(this);
        
        animRightLeft = AnimationUtils.loadAnimation(this,R.anim.right_left);
        animRightLeft.setAnimationListener(this);
        
        animBounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        animBounce.setAnimationListener(this);
        
        animFlash = AnimationUtils.loadAnimation(this,R.anim.flash);
        animFlash.setAnimationListener(this);
        
        animRotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        animRotate.setAnimationListener(this);

        seekBar = findViewById(R.id.seekBar);
        txtStatus = findViewById(R.id.txtStatus);
        txtSeekBar = findViewById(R.id.txtSeekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekSpeedProgress = progress;
                txtSeekBar.setText(progress+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void loadUi()
    {
        imgLogo = findViewById(R.id.imgLogo);
        txtSeekBar = findViewById(R.id.txtSeekBar);
        txtStatus = findViewById(R.id.txtStatus);
        seekBar = findViewById(R.id.seekBar);

        btnFadeIn = findViewById(R.id.btnFadein);
        btnFadeIn.setOnClickListener(this);

        btnFadeOut = findViewById(R.id.btnFadeout);
        btnFadeOut.setOnClickListener(this);

        btnBounce = findViewById(R.id.btnBounce);
        btnBounce.setOnClickListener(this);

        btnFlash = findViewById(R.id.btnFlash);
        btnFlash.setOnClickListener(this);

        btnTopBottom = findViewById(R.id.btnTopBottom);
        btnTopBottom.setOnClickListener(this);

        btnLeftRight = findViewById(R.id.btnLeftRight);
        btnLeftRight.setOnClickListener(this);

        btnRightLeft = findViewById(R.id.btnRightLeft);
        btnRightLeft.setOnClickListener(this);

        btnRotate = findViewById(R.id.btnRotate);
        btnRotate.setOnClickListener(this);

        btnZoomIn = findViewById(R.id.btbZoomIn);
        btnZoomIn.setOnClickListener(this);

        btnZoomOut = findViewById(R.id.btnZoomOut);
        btnZoomOut.setOnClickListener(this);

        btnFadeInOut = findViewById(R.id.btnFadeInOut);
        btnFadeInOut.setOnClickListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {
        txtStatus.setText("Running...");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        txtStatus.setText("STOPED");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        txtStatus.setText("Repeating");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnFadein:
                animFadeIn.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animFadeIn);
                break;

            case R.id.btnFadeout:
                animFadeOut.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animFadeOut);
                break;

            case R.id.btnFadeInOut:
                animFadeInOut.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animFadeInOut);
                break;

            case R.id.btbZoomIn:
                animFadeIn.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animFadeIn);
                break;

            case R.id.btnZoomOut:
                animZoomOut.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animZoomOut);
                break;


            case R.id.btnBounce:
                animBounce.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animBounce);
                break;

            case R.id.btnLeftRight:
                animLeftRight.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animLeftRight);
                break;

            case R.id.btnRightLeft:
                animRightLeft.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animRightLeft);
                break;

            case R.id.btnTopBottom:
                animTopBottom.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animTopBottom);
                break;

            case R.id.btnFlash:
                animFlash.setDuration(seekSpeedProgress/10);
                imgLogo.startAnimation(animFlash);
                break;

            case R.id.btnRotate:
                animRotate.setDuration(seekSpeedProgress);
                imgLogo.startAnimation(animRotate);
                break;
        }
    }
}