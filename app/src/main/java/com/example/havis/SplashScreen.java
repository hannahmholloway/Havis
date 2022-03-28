package com.example.havis;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class SplashScreen extends AppCompatActivity{

   private ImageView logoSplash, charmaTech;
   private Animation anim1, anim2, anim3, anim4;


   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      setContentView(R.layout.splash_screen);
      init();


      logoSplash.startAnimation(anim1);
      anim1.setAnimationListener(new Animation.AnimationListener() {
         @Override
         public void onAnimationStart(Animation animation) {


         }

         @Override
         public void onAnimationEnd(Animation animation) {
            charmaTech.startAnimation(anim2);
            charmaTech.setVisibility(View.GONE);

            charmaTech.startAnimation(anim3);
            anim3.setAnimationListener(new Animation.AnimationListener() {
               @Override
               public void onAnimationStart(Animation animation) {
               }

               @Override
               public void onAnimationEnd(Animation animation) {
                  logoSplash.setVisibility(View.VISIBLE);
                  charmaTech.setVisibility(View.VISIBLE);


                  finish();
                  startActivity(new Intent(SplashScreen.this,LoginActivity.class));
               }

               @Override
               public void onAnimationRepeat(Animation animation) {

               }
            });


         }

         @Override
         public void onAnimationRepeat(Animation animation) {

         }
      });




   }


   private void init(){

      logoSplash = findViewById(R.id.ivLogoSplash);
      charmaTech = findViewById(R.id.ivCHTtext);
      anim1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadein);
      anim2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
      anim3 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.beerotate);
      anim4 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadeout);
   }


}

