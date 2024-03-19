package com.example.assignment8_6306021630056_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View implements View.OnTouchListener {

    Paint p1,p2,p3;
    float x,y;
    float x1,y1,x2,y2;
    int check = 0;
    String choice[] = {"Line","Rectangle","Circle"};

    public GraphicsView(Context ctx) {
        super(ctx);
        p1 = new Paint();
        p1.setTextAlign(Paint.Align.CENTER);
        p1.setTextSize(50);

        p2 = new Paint();
        p2.setStyle(Paint.Style.STROKE);
        p2.setStrokeWidth(5);

        p3 = new Paint();
        p3.setStyle(Paint.Style.FILL);
        p3.setColor(Color.YELLOW);

        setOnTouchListener(this);

    }

    @Override
    public void onDraw(Canvas canvas) {
        p1.setColor(Color.BLACK);
        p2.setColor(Color.BLACK);
        canvas.drawRect(10,10,200,110,p2);
        canvas.drawRect(10,10,200,110,p3);
        canvas.drawText("Line",100,80,p1);

        canvas.drawRect(200,10,480,110,p2);
        canvas.drawRect(200,10,480,110,p3);
        canvas.drawText("Rectangle",350,80,p1);

        canvas.drawRect(480,10,700,110,p2);
        canvas.drawRect(480,10,700,110,p3);
        canvas.drawText("Circle",600,80,p1);

        canvas.drawRect(700,10,960,110,p2);
        canvas.drawRect(700,10,960,110,p3);
        p1.setColor(Color.rgb(159, 43, 104));
        canvas.drawText(choice[check],820,80,p1);
        if(check == 0 ){
            p2.setColor(Color.RED);
            canvas.drawLine( x1, y1, x2, y2, p2);
        }else if(check == 1){
            p2.setColor(Color.RED);
            canvas.drawRect( x1, y1, x2, y2, p2);
        }else if(check == 2){
            p2.setColor(Color.RED);
            canvas.drawCircle( x1, y1, y2, p2);
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        checkchooice(x,y);

        if(check == 0){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                x1 = event.getX();
                y1 = event.getY();
            }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                x2 = event.getX();
                y2 = event.getY();
            }else if(event.getAction() == MotionEvent.ACTION_UP){
                x2 = event.getX();
                y2 = event.getY();
            }
        }else if(check == 1){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                x1 = event.getX();
                y1 = event.getY();
            }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                x2 = event.getX();
                y2 = event.getY();
            }else if(event.getAction() == MotionEvent.ACTION_UP){
                x2 = event.getX();
                y2 = event.getY();
            }
        }else if(check == 2){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                x1 = event.getX();
                y1 = event.getY();
            }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                y2 = event.getY();
                if(y2 > y1)
                    y2 =y2-y1;
                else y2 = y1-y2;
            }else if(event.getAction() == MotionEvent.ACTION_UP){
                y2 = event.getY();
                if(y2 > y1)
                    y2 =y2-y1;
                else y2 = y1-y2;
            }
        }

        invalidate();

        return true;
    }

    private void checkchooice(float x, float y) {
        if(x >10 && x <=200 && y>=10 && y <= 110)
            check = 0;
        else if(x >200 && x <=480 && y>=10 && y <= 110)
            check = 1;
        else if(x >480 && x <=700 && y>=10 && y <= 110)
            check = 2;
    }
}