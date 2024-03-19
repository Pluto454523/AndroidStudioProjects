package com.example.assignment8_6306021630056_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class GraphicsView extends View implements View.OnTouchListener {
    Paint p1;

    int imageW,imageH;
    CountDownTimer timer1,timer2,UfoBoom;
    boolean StatusGame = false;
    float Width=0,Height=0;
    float spawnX[] = {50,250,450,650,850},spawnY[];
    Random rnd = new Random();
    int score=0 , time=0;
    int Speed = 50,SpeedUnit[];
    int resImage[] = {
            R.drawable.ufo_bm_01,R.drawable.ufo_bm_02,
            R.drawable.ufo_bm_03,R.drawable.ufo_bm_04,
            R.drawable.ufo_bm_05, R.drawable.ufo_bm_06,
            R.drawable.ufo_bm_07, R.drawable.ufo_bm_08,
            R.drawable.ufo_bm_09, R.drawable.ufo_bm_10,
            R.drawable.ufo_bm_11, R.drawable.ufo_bm_12,
            R.drawable.ufo_bm_13, R.drawable.ufo_bm_14,
            R.drawable.ufo_bm_15, R.drawable.ufo_bm_16,
            R.drawable.ufo_bm_17, R.drawable.ufo_bm_18,
            R.drawable.ufo_bm_19, R.drawable.ufo_bm_20
    };
    Bitmap image_boom[] = new Bitmap[resImage.length],image1;
    int HitUFO = -1,Num =0;
    float picy;
    int effect = R.raw.boommtf;
    MediaPlayer play;

    public GraphicsView(Context ctx) {
        super(ctx);
        setBackgroundColor(Color.BLACK);
        p1 = new Paint();
        for (int n =0 ;n<resImage.length;n++){
            image_boom[n] = BitmapFactory.decodeResource(getResources(),resImage[n]);
        }
        image1 =BitmapFactory.decodeResource(getResources(),R.drawable.ufo);
        imageW = image1.getWidth();
        imageH = image1.getHeight();
        spawnY = new float[5];
        SpeedUnit = new int[5];

        for(int n=0;n<SpeedUnit.length;n++){
            setSpeed(n);
        }
        setOnTouchListener(this);
        timer1 = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                time++;
                invalidate();
            }

            @Override
            public void onFinish() {
                StatusGame = true;
                timer2.cancel();
                invalidate();
            }
        };
        timer2 = new CountDownTimer(30000,50) {
            @Override
            public void onTick(long l) {
                for (int n=0;n<spawnY.length;n++){
                    spawnY[n] += SpeedUnit[n];
                    if(spawnY[n]>Height+image1.getHeight()){
                        spawnY[n] = 0;
                    }
                }
                invalidate();
            }

            @Override
            public void onFinish() {
                StatusGame = true;
                invalidate();
            }
        };
        UfoBoom = new CountDownTimer(200, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                Num = (Num +1 == resImage.length) ? 0 : Num+1;
                invalidate();
            }

            @Override
            public void onFinish() {
                Num = 0;
                HitUFO = -1;
                invalidate();
            }
        };
        timer1.start();
        timer2.start();
        play = MediaPlayer.create(ctx,effect);
    }

    private void setSpeed(int n) {
        SpeedUnit[n] = 1+rnd.nextInt(Speed);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(StatusGame){
            StatusGame = false;
            timer1.start();
            timer2.start();
            score = 0 ;
            time = 0;
            for (int n =0 ;n<spawnY.length;n++ )
                spawnY[n] = 0;
            invalidate();
        }else{
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if(Boom(x,y)){
                score++;
                play.start();
                invalidate();
            }
        }
        return true;
    }

    private boolean Boom(float x, float y) {
        for (int n=0;n<spawnX.length;n++){
            if(x > spawnX[n] && x < spawnX[n]+image1.getWidth()){
                if(y > spawnY[n] && y < spawnY[n]+image1.getHeight()){
                    NewSpawn(n,y);
                    return true;
                }
            }
        }
        return false;
    }

    private void NewSpawn(int n, float y) {
        spawnY[n] = 0;
        HitUFO = n;
        UfoBoom.start();
        picy = y;
        setSpeed(n);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Width = getWidth();
        Height = getHeight();
        if(StatusGame){
            p1.setColor(Color.GREEN);
            p1.setTextSize(60);
            p1.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Time Out!",Width/2,Height/2,p1);
            canvas.drawText("Press for play again or back to exit",Width/2,Height/2+100,p1);
        }else{
            p1.setColor(Color.YELLOW);
            p1.setTextSize(40);
            p1.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Score : " + score, 100, 60, p1);
            p1.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Time : " + time, Width-50, 60, p1);
            for(int n =0;n< spawnY.length;n++){
                if(HitUFO == n){
                    canvas.drawBitmap(image_boom[Num], spawnX[n], picy, null);
                }else{
                    canvas.drawBitmap(image1, spawnX[n], spawnY[n], null);
                }
            }
        }
    }
}