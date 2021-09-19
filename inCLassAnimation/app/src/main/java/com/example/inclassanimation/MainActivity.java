package com.example.inclassanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    //class member vars
    private Animation animRotate1;
    private ImageView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hold on t
        myView = (ImageView)findViewById(R.id.imageView);
        // load the animation
        animRotate1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        //set listener (VERY IMPORTANT, YOU FORGET nothing works!)
        animRotate1.setAnimationListener(this);
    }
    public void doAnimate(View view) {
    //finally start the animation on the view
        myView.startAnimation(animRotate1);
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}