package com.example.final_6406021630039_fruits;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
public class GraphicsView extends View implements View.OnTouchListener {
    int fruitSpeed;
    int score, gameTime, endTime;
    boolean isGameRunning;
    Paint paint;
    int[] resIds = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.cherry,
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.cherry,
            R.drawable.apple,
            R.drawable.banana
    };
    Fruit[] fruits;


    public GraphicsView(Context context) {
        super(context);
        setOnTouchListener(this);
        paint = new Paint();
        setBackgroundColor(Color.parseColor("#f2a4a4"));

        // 30 px per 0.1 second
        fruitSpeed = 30;
        score = gameTime = 0;
        endTime = 30;
        isGameRunning = true;
        fruits = new Fruit[8];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = new Fruit(context, -100, -100, resIds[i]);
            fruits[i].respawn(context, getScreenWidth(getContext()), resIds[i]);
        }
        startGameTime();
        startMovingFruits();
    }

    @Override
    public void onDraw(Canvas canvas) {
        postInvalidateDelayed(1000 / 30); // draw 30fps
        if (isGameRunning) {

            // draw fruit
            for (int i = 0; i < fruits.length; i++) {
                canvas.drawBitmap(fruits[i].image, fruits[i].x, fruits[i].y, null);
            }

            // draw time and score
            paint.setColor(Color.BLACK);
            paint.setTextSize(50);

            // Draw the score on the top left of the screen
            paint.setTextAlign(Paint.Align.LEFT);
            String scoreText = "Score: " + score;
            canvas.drawText(scoreText, 20, 50, paint);

            // Draw the timer on the top right of the screen
            paint.setTextAlign(Paint.Align.RIGHT);
            int seconds = endTime - gameTime;
            String timerText = String.format("%02d:%02d", 0, seconds);
            canvas.drawText(timerText, canvas.getWidth() - 20, 50, paint);
        } else {
            paint.setColor(Color.BLACK);
            paint.setTextSize(70);
            paint.setTextAlign(Paint.Align.CENTER);
            String gameOverText = "END GAME!";
            String scoreText = "Your score: " + score;
            String restartText = "Touch to restart";
            float centerX = canvas.getWidth() / 2;
            float centerY = canvas.getHeight() / 2;
            canvas.drawText(gameOverText, centerX, centerY - 100, paint);
            canvas.drawText(scoreText, centerX, centerY, paint);
            canvas.drawText(restartText, centerX, centerY + 100, paint);
        }
    }

    private void startGameTime() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isGameRunning) {
                    gameTime++;
                    if (gameTime >= endTime) {
                        isGameRunning = false;
                        return;
                    }
                    handler.postDelayed(this, 1000);
                }
            }
        }, 100);
    }

    // move 30 pixel every 0.1 second (50 pixel every second)
    // if lag just change 100 to 500 maybe. (Don't forget to change speed too)
    private void startMovingFruits() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isGameRunning) {
                    for (int i = 0; i < fruits.length; i++) {
                        fruits[i].y += fruitSpeed;
                        if (fruits[i].y > getHeight())
                            fruits[i].respawn(getContext(), getWidth(), resIds[i]);
                    }
                    handler.postDelayed(this, 100);
                }
            }
        }, 100);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (isGameRunning) {
                for (int i = 0; i < fruits.length; i++) {
                    if (fruits[i].isInside(event.getX(), event.getY())) {
                        score++;
                        fruits[i].respawn(getContext(), getWidth(), resIds[i]);
                        break;
                    }
                }
            } else {
                restartGame();
            }
        }
        return true;
    }
    private void restartGame() {
        isGameRunning = true;
        gameTime = 0;
        score = 0;
        for (int i = 0; i < fruits.length; i++) {
            fruits[i].respawn(getContext(), getWidth(), resIds[i]);
        }
        startGameTime();
        startMovingFruits();
    }
    private int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}