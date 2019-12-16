package com.example.pst4;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

public class ForwardToDone extends AppCompatImageView {
    int switchNumber = 0;

    public ForwardToDone(Context context) {
        super(context);
    }

    public void morph(ImageView next) {
        if (switchNumber == 0){
            next.setImageDrawable(getResources().getDrawable(R.drawable.avd_anim));
            Drawable drawable = next.getDrawable();


            if(drawable instanceof AnimatedVectorDrawableCompat){
                AnimatedVectorDrawableCompat forwardToDone = (AnimatedVectorDrawableCompat) drawable;
                forwardToDone.start();
            }else if(drawable instanceof  AnimatedVectorDrawable){
                AnimatedVectorDrawable doneToForward = (AnimatedVectorDrawable) drawable;
                doneToForward.start();
            }

            switchNumber++;
        }/*else {
                    next.setImageDrawable(getResources().getDrawable(R.drawable.avd_animreverse));
                    Drawable drawable = next.getDrawable();

                    if(drawable instanceof AnimatedVectorDrawableCompat){
                        avd = (AnimatedVectorDrawableCompat) drawable;
                        avd.start();
                    }else if(drawable instanceof  AnimatedVectorDrawable){
                        avd2 = (AnimatedVectorDrawable) drawable;
                        avd2.start();
                    }

                    switchNumber--;
                }*/
    }

    }
