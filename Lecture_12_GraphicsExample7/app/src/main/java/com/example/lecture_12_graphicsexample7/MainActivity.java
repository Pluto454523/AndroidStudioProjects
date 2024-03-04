package com.example.lecture_12_graphicsexample7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));
    }
}
class GraphicsView extends View {
    private Paint p;
    private float X, Y;
    private Canvas myCanvas;
    public GraphicsView(Context context)
    {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(3);
        p.setTextSize(40);
        getWidth(); // เรียกได้ไม่ผิดแต่ไม่มีค่า เพราะ canva จาก onDraw จะเซ็ตค่าให้ตอนเรียกใช้
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        X = event.getX();
        Y = event.getY();
        invalidate();
        return(true);
    }
    @Override
    protected void onDraw(Canvas canvas)
    { int x, y;
        x = getWidth() /2;
        y = getHeight() /2;
        canvas.drawText("Width :" +getWidth(), 50, 100, p);
        canvas.drawText("Height :" +getHeight(), 50, 150, p);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawCircle( x, y, 100, p);
        for (int n = 1; n <= 5 ; n++)
            canvas.drawRect( 10*n, 10*n, getWidth() -10*n,getHeight() -10*n, p);
        canvas.drawText("X :" + X +", Y = " + Y, X, Y, p);
    }
}