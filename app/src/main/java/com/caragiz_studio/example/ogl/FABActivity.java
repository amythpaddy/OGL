package com.caragiz_studio.example.ogl;

import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FABActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
    }
    boolean flag = false;
    public void animate(View view){
        FloatingActionButton fab = (FloatingActionButton)view;
        AnimatedVectorDrawable animVector;
//        AnimatedVectorDrawable animVector;
        if(!flag){
//            animVector = AnimatedVectorDrawableCompat.create(this , R.drawable.tomute_animated_vector_drawable_start_to_end);
            animVector = (AnimatedVectorDrawable)getDrawable(R.drawable.tomute_animated_vector_drawable_start_to_end);
            fab.setImageDrawable(animVector);
            animVector.start();

        }
        else{
            animVector = (AnimatedVectorDrawable)getDrawable(R.drawable.tomute_animated_vector_drawable_end_to_start);
//            animVector = AnimatedVectorDrawableCompat.create(this , R.drawable.tomute_animated_vector_drawable_end_to_start);
            fab.setImageDrawable(animVector);
            animVector.start();
        }

        flag = !flag;
    }
}
