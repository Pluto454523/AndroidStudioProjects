package com.example.final_6406021630039_fruits;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Fruit {
    public int x, y;
    public Bitmap image;
    public Fruit(Context context, int x, int y, int resId){
        this.x = x;
        this.y = y;
        this.image = BitmapFactory.decodeResource(context.getResources(), resId);
    }
    public void respawn(Context context, int width, int resId){
        this.image = BitmapFactory.decodeResource(context.getResources(), resId);
        int x = new Random().nextInt(width - image.getWidth());
        this.x = x;
        this.y = -100;
    }
    public boolean isInside(float X, float Y) {
        if (X > x && X < x + image.getWidth())
            if (Y > y && Y < y + image.getHeight())
                return(true);
        return(false);
    }
}