package com.caragiz_studio.example.ogl;

import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FABActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
    }
    boolean flag = false;
    public void animate(View view) {
        FloatingActionButton fab = (FloatingActionButton) view;
        AnimatedVectorDrawable animVector;
//        AnimatedVectorDrawable animVector;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (!flag) {
//            animVector = AnimatedVectorDrawableCompat.create(this , R.drawable.tomute_animated_vector_drawable_start_to_end);
                animVector = (AnimatedVectorDrawable) getDrawable(R.drawable.tomute_animated_vector_drawable_start_to_end);

                fab.setImageDrawable(animVector);

                animVector.start();

            } else {
                animVector = (AnimatedVectorDrawable) getDrawable(R.drawable.tomute_animated_vector_drawable_end_to_start);
//            animVector = AnimatedVectorDrawableCompat.create(this , R.drawable.tomute_animated_vector_drawable_end_to_start);
                fab.setImageDrawable(animVector);
                animVector.start();
            }

            flag = !flag;
        }
    }

    /***
     * Displays a popup on click of the view
     * @param view
     */
    public void popup(final View view){
        PopupMenu pop = new PopupMenu(this , view);
        pop.getMenuInflater().inflate(R.menu.popup_menu,pop.getMenu());
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(FABActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                ((TextView)view).setText(item.getTitle());
                return true;
            }
        });

        pop.show();
    }
}
