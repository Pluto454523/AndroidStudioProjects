package com.example.final_6406021630039_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
public class GraphicsView extends View {
    float startX, startY;
    float endX, endY;
    public Paint paint;

    public GraphicsView(Context context) {
        super(context);

        // Initialize paint object and set default values
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = x;
                startY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                endX = x;
                endY = y;
                invalidate(); // Redraw the canvas
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // set color from selectedColorCode in MainActivity
        // because selectedColorCode is static so can so directly
        paint.setColor(MainActivity.selectedColorCode);
        switch (MainActivity.selectedShapeString) {
            case "line":
                canvas.drawLine(startX, startY, endX, endY, paint);
                break;
            case "rectangle":
                RectF rect = new RectF(startX, startY, endX, endY);
                canvas.drawRect(rect, paint);
                break;
            case "circle":
                float radius = (float) Math.sqrt(Math.pow(endX - startX, 2) +
                        Math.pow(endY - startY, 2));
                canvas.drawCircle(startX, startY, radius, paint);
                break;
        }
    }
}