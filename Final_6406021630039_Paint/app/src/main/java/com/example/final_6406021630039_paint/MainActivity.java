package com.example.final_6406021630039_paint;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView line, rectangle, circle, selectedShape, red, green, blue, selectedColor;
    TextView nameTextView;
    public static String selectedShapeString = "red";
    public static int selectedColorCode = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        line = findViewById(R.id.line);
        line.setBackground( getBG( Color.parseColor("#FFFB00")) );
        line.setOnClickListener(this);
        rectangle = findViewById(R.id.rectangle);
        rectangle.setBackground(getBG( Color.parseColor("#FFFB00")) );
        rectangle.setOnClickListener(this);
        circle = findViewById(R.id.circle);
        circle.setBackground(getBG( Color.parseColor("#FFFB00")) );
        circle.setOnClickListener(this);
        selectedShape = findViewById(R.id.selectedShapeTextView);
        selectedShape.setBackground(getBG( Color.parseColor("#FFFB00")) );
        selectedShape.setOnClickListener(this);
        selectedColor = findViewById(R.id.selectedColorTextView);
        selectedColor.setBackground(getBG( Color.parseColor("#FFFB00")) );
        selectedColor.setOnClickListener(this);
        red = findViewById(R.id.red);
        red.setBackground( getBG(Color.RED) );
        red.setOnClickListener(this);
        green = findViewById(R.id.green);
        green.setBackground( getBG(Color.GREEN) );
        green.setOnClickListener(this);
        blue = findViewById(R.id.blue);
        blue.setBackground( getBG(Color.BLUE) );
        blue.setOnClickListener(this);
        nameTextView = findViewById(R.id.nameTextView);
        FrameLayout frameLayout = findViewById(R.id.frame_layout);
        GraphicsView graphicsView = new GraphicsView(this);
        frameLayout.addView(graphicsView);
    }
    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.line) {
            selectedShapeString = "line";

        } else if (viewId == R.id.rectangle) {
            selectedShapeString = "rectangle";

        } else if (viewId == R.id.circle) {
            selectedShapeString = "circle";

        } else if (viewId == R.id.red) {
            selectedColorCode = Color.RED;
            selectedColor.setText( "red" );

        } else if (viewId == R.id.green) {
            selectedColorCode = Color.GREEN;
            selectedColor.setText( "green" );

        } else if (viewId == R.id.blue) {
            selectedColorCode = Color.BLUE;
            selectedColor.setText( "blue" );
        }

        selectedShape.setText(selectedShapeString);
    }
    public GradientDrawable getBG(int color){

        // set bg and stroke
        GradientDrawable gd = new GradientDrawable();
        gd.setStroke( 3, Color.BLACK);
        gd.setColor(color);
        return gd;
    }
}
