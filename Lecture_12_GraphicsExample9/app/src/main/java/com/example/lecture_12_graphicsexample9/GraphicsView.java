package com.example.lecture_12_graphicsexample9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
public class GraphicsView extends View implements View.OnTouchListener {
    private Paint p1, p2;
    private float x1, y1, x2, y2;
    private boolean isDraw = false;
    private boolean isFirst = true;
    public GraphicsView(Context context)
    {
        super(context);
        p1 = new Paint();
        p2 = new Paint();
        p2.setColor(Color.RED);
        p2.setStrokeWidth(3);
        setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View view, MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (isFirst) {
                x1 = event.getX();
                y1 = event.getY();
                isDraw = isFirst = false;
            }
            else {
                x2 = event.getX();
                y2 = event.getY();
                isDraw = true;
                isFirst = true;
            }
        }
        invalidate();
        return(true);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        p1.setColor(Color.BLUE);
        p1.setTextSize(60);
        p1.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("> Drawing <", getWidth()/2, 80, p1);
        if (isDraw)
            canvas.drawLine( x1, y1, x2, y2, p2);
        p1.setColor(Color.MAGENTA);
        p1.setTextSize(50);
        p1.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("(X1,Y1) = ("+x1+", "+y1+")",
                20, getHeight()-100, p1);
        canvas.drawText("(X2,Y2) = ("+x2+", "+y2+")",
                20, getHeight()-50, p1);

    }
}