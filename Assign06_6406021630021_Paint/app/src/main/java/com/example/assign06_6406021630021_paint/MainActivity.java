package com.example.assign06_6406021630021_paint;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    TextView line,rectangle,circle,btn;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        line = (TextView) findViewById(R.id.line);
        line.setOnClickListener(this);
        rectangle = (TextView) findViewById(R.id.rectangle);
        rectangle.setOnClickListener(this);
        circle = (TextView) findViewById(R.id.circle);
        circle.setOnClickListener(this);
        btn = (TextView) findViewById(R.id.btn);
        layout = (LinearLayout) findViewById(R.id.layout);



    }
    @Override
    public void onClick(View v) {
        layout.removeAllViews();
        if(v.getId() == R.id.line){ // เทียบเงื่อนไขเมื่อคลิก Line
            btn.setText("LINE");
            GraphicsView graphicsView = new GraphicsView(this, "Line");
            layout.addView(graphicsView);
        }else if(v.getId() == R.id.rectangle){  // เทียบเงื่อนไขเมื่อคลิก Rectangle
            btn.setText("RECTANGLE");
            GraphicsView graphicsView = new GraphicsView(this, "Rectangle");
            layout.addView(graphicsView);
        }else if(v.getId() == R.id.circle){ // เทียบเงื่อนไขเมื่อคลิก Circle
            btn.setText("CIRCLE");
            GraphicsView graphicsView = new GraphicsView(this, "Circle");
            layout.addView(graphicsView);
        }
    }
}


class GraphicsView extends View implements View.OnTouchListener{
    private Paint p1, p2;
    private float x1, y1, x2, y2;
    private boolean isDraw = false;
    private boolean isFirst = true;
    private String check = "";
    public GraphicsView(Context context, String status)
    {
        super(context);
        check = status; // check ค่าที่ส่งมาจาก Main
        p1 = new Paint();
        p1.setColor(Color.RED);
        p1.setStyle(Paint.Style.STROKE);
        p1.setStrokeWidth(3);
        setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View view, MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN) { // เทียบเงื่อนไขเมื่อ ACTION_DOWN
            x1 = event.getX();
            y1 = event.getY();
            isDraw = true;
            isFirst = false;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) { // เทียบเงื่อนไขเมื่อ ACTION_MOVE
            if (isDraw) {
                x2 = event.getX();
                y2 = event.getY();
                invalidate();
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) { // เทียบเงื่อนไขเมื่อ ACTION_UP
            if (isDraw) {
                x2 = event.getX();
                y2 = event.getY();
                isDraw = false;
            }
        }
        return true;
    }



    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (check.equals("Line") && isDraw) { // เทียบเงื่อนไขจากค่าที่ส่งมาว่าเป็น Line หรือไม่ และ isDraw เป็นจริงหรือไม่
            canvas.drawLine(x1, y1, x2, y2, p1); // วาดเส้น
        } else if(check.equals("Rectangle") && isDraw) { // เทียบเงื่อนไขจากค่าที่ส่งมาว่าเป็น Rectangle และ isDraw เป็นจริงหรือไม่
            float left = Math.min(x1, x2);
            float top = Math.min(y1, y2);
            float right = Math.max(x1, x2);
            float bottom = Math.max(y1, y2);
            canvas.drawRect(left, top, right, bottom, p1); // วาดสี่เหลี่ยม
        } else if(check.equals("Circle") && isDraw) { // เทียบเงื่อนไขจากค่าที่ส่งมาว่าเป็น Circle และ isDraw เป็นจริงหรือไม่
            float centerX = (x1 + x2) / 2;
            float centerY = (y1 + y2) / 2;
            float radius = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)) / 2;
            canvas.drawCircle(centerX, centerY, radius, p1); // วาดวงกลม
        }
    }

}