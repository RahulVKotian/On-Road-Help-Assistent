package com.example.roado;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class RateUsDialog extends Dialog {
    public RateUsDialog(@NonNull Context context)
    {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final float[] userRate = {0};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_dialog_layout);


        final AppCompatButton rate=findViewById(R.id.rate);
        final AppCompatButton later=findViewById(R.id.later);
        final RatingBar star=findViewById(R.id.star);
        final ImageView starsmile=findViewById(R.id.ratesmile);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hiding rating
                dismiss();
            }
        });
        star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                if(rating <= 1)
                {
                    starsmile.setImageResource(R.drawable.sad);

                } else if (rating <= 2) {
                    starsmile.setImageResource(R.drawable.smile);

                }
                else if (rating <= 3) {
                    starsmile.setImageResource(R.drawable.smile1);


                }
                else if (rating <= 4) {
                    starsmile.setImageResource(R.drawable.angry);

                }
                else if (rating <= 5) {
                    starsmile.setImageResource(R.drawable.lovesmile);

                }
                //animated emoji
                animateImage(starsmile);
                //select rating by user
                userRate[0] =rating;
            }
        });
    }

    private  void animateImage(ImageView starsmile){

        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1f,0,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
   scaleAnimation.setFillAfter(true);
   scaleAnimation.setDuration(200);
   starsmile.startAnimation(scaleAnimation);
    }
}
