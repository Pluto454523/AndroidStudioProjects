package com.example.lecture_12_graphicsexample8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
public class GraphicsView extends View implements View.OnTouchListener {
    private Paint p;
    private float x, y, r, size;
    private int Type = 0;
    public GraphicsView(Context context) {
        super(context);
        p = new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(50);
        r = 50;
        size = 50;
        setOnTouchListener(this);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Type == 1) {
            p.setColor(Color.RED);
            canvas.drawText("Down", getWidth()/2, 50, p);
            canvas.drawCircle(x, y, r, p);
        }
        else if (Type == 2) {
            p.setColor(Color.GREEN);
            canvas.drawText("Move or Drag", getWidth() / 2, 50, p);
            canvas.drawRect(x, y, x + size, y + size, p);
        }
        else if (Type == 3) {
            p.setColor(Color.BLUE);
            canvas.drawText("Up", getWidth()/2, 50, p);
            canvas.drawText("ANDROID", x, y, p);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Type = 1;
        }
        else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            Type = 2;
        }
        else if (event.getAction() == MotionEvent.ACTION_UP) {
            Type = 3;
        }
        invalidate();
        return true;
//        return false;
    }

}