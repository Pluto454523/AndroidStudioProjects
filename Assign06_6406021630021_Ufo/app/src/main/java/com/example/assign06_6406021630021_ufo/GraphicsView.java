package com.example.assign06_6406021630021_ufo;
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
    private Paint p;
    private float width, height;
    private Bitmap image, image1;
    private int score, time;
    private CountDownTimer timer1, timer2;
    private boolean finish = false;
    private Random rnd = new Random();
    private int imageWidth, imageHeight;
    private MediaPlayer effect;
    private int Speed = 50, SpeedUnit[];
    private float picy;
    float spawnX[] = {50, 250, 450, 650, 850, 1050, 1250, 1450}, spawnY[];
    int HitUFO = -1;
    public GraphicsView(Context context) {
        super(context);
        setBackgroundColor(Color.BLACK); //กำหนดพื้นหลัง
        p = new Paint();
        image = BitmapFactory.decodeResource(getResources(),R.drawable.ufo); //กำหนดรูป ufo ปกติ
        image1 = BitmapFactory.decodeResource(getResources(),R.drawable.ufo_bm); //กำหนดรูป ufo ที่ระเบิด
        score = 0;
        time = 0;
        width = 0;
        height = 0;
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        spawnY = new float[8]; // กำหนดให้มี 8 เพราะมี 8 ลำ

        SpeedUnit = new int[8]; // กำหนดให้มี 8 เพราะมี 8 ลำ
        for (int n = 0; n < SpeedUnit.length; n++) { // วนลูปตามจำนวน Ufo ที่กำหนด
            setSpeed(n); // เข้าเมธอดเพื่อกำหนดความเร็ว
        }

        effect = MediaPlayer.create(context, R.raw.effect); //กำหนดเสียง
        setOnTouchListener(this);
        timer1 = new CountDownTimer(30000, 1000) { // นับถอยหลัง 30 วิ
            public void onTick(long millisUntilFinished) {
                time ++;
                invalidate();
            }
            public void onFinish() {
                finish = true;
                timer2.cancel();
                invalidate();
            }
        };
        timer2 = new CountDownTimer(30000, 50) { // นับถอยหลัง 30 วิ
            public void onTick(long millisUntilFinished) {
                for (int n = 0; n < spawnY.length; n++) { //กำหนดความเร็ว
                    spawnY[n] += SpeedUnit[n];
                    if (spawnY[n] > height + image.getHeight()) {
                        spawnY[n] = 0;
                    }
                }
                invalidate();
            }
            public void onFinish() {
                finish = true;
                invalidate();
            }
        };

        timer1.start(); // เริ่มนับ
        timer2.start(); // เริ่มนับ

    }
    private void setSpeed(int n) {

        SpeedUnit[n] = 1 + rnd.nextInt(Speed); // สุ่มความเร็ว
    }

    @Override
    public boolean onTouch(View view, MotionEvent event)
    {
        if (finish) { // เทียบเงื่อนไข
            finish = false;
            timer1.start();
            timer2.start();
            score = 0;
            time = 0;
            for (int n = 0; n < spawnY.length; n++) {
                spawnY[n] = 0;
            }
            invalidate();
        }
        else {
            float x = event.getX();  // รับค่า
            float y = event.getY();  // รับค่า
            if (isInside(x, y)) { // เทียบเงื่อนไขเมื่อยิงโดน
                score += 1;
                effect.start();
                invalidate();
            }
        }
        return true;
    }

    private boolean isInside(float xp, float yp){ // เทียบเงื่อนไขในกการยิง
        for (int n = 0; n < spawnX.length; n++) {
            if (xp > spawnX[n] && xp < spawnX[n] + image.getWidth()) {
                if (yp > spawnY[n] && yp < spawnY[n] + image.getHeight()) {
                    NewSpawn(n, yp);
                    return true;
                }
            }
        }
        return(false);
    }

    private void NewSpawn(int n, float y) { // รีเซ็ต Ufo
        spawnY[n] = 0;
        HitUFO = n;
        picy = y;
        setSpeed(n);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        if (finish){ // เทียบเงื่อนไขเมื่อจบเกม
            p.setColor(Color.GREEN);
            p.setTextSize(100);
            p.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Time Out!", width/2, height/2-100, p);
            canvas.drawText("Press for play again or back to exit", width/2, height/2 + 100, p);
        }
        else {
            p.setColor(Color.YELLOW);
            p.setTextSize(100);
            p.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Score : " + score, 20, 90, p);
            p.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Time : " + time, width-20, 90, p);
            for (int n = 0; n < spawnY.length; n++) { // สร้างรูปภาพ
                if (HitUFO == n) {
                    canvas.drawBitmap(image1, spawnX[n], picy, null);
                } else {
                    canvas.drawBitmap(image, spawnX[n], spawnY[n], null);
                }
            }
        }
    }
}