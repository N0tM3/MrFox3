package com.spinblue.mrfox;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Eduardo on 07/03/2017.
 * asdasdasd
 */

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button boton = (Button) findViewById(R.id.button4);

       // TextView txt = (TextView) findViewById(R.id.txt_titulo);
       // Typeface externalFont = Typeface.createFromAsset(getAssets(), "fonts/kust");

       // txt.setTypeface(externalFont);

        animaciones();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Main.this,ScrollingActivity.class);
                startActivity(login);
            }
        });

    }

    public void animaciones(){

        final ImageView logo = (ImageView) findViewById(R.id.imageView);
        final LinearLayout form = (LinearLayout) findViewById(R.id.form);

//LOGO
        final Animation fadeIntro = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        final Animation fadeSalir = AnimationUtils.loadAnimation(this,R.anim.fade_out);
//FORM
        final Animation out = AnimationUtils.loadAnimation(this,R.anim.out);
        final Animation in = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        logo.startAnimation(fadeIntro);
        fadeIntro.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                form.startAnimation(out);
                logo.startAnimation(fadeSalir);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fadeSalir.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                form.startAnimation(in);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
