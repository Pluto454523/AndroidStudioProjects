package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;


public class ScrollViewActivity extends AppCompatActivity implements
        View.OnClickListener {
    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private ImageView[] imagesView;
    private int [] resId = {
            R.drawable.pic1, R.drawable.pic2,R.drawable.pic3, R.drawable.pic4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        linearLayout = (LinearLayout) findViewById(R.id.linearVertical);
        imagesView = new ImageView[4];
        for(int n = 0; n < imagesView.length; n++) {
            imagesView[n] = new ImageView(this);
            imagesView[n].setId(25100+n);
            imagesView[n].setPadding(0,0,0,0);
            imagesView[n].setImageResource(resId[n] );
            //imagesView[n].setScaleType(ImageView.ScaleType.FIT_XY);
            imagesView[n].setScaleType(ImageView.ScaleType.FIT_CENTER);
            imagesView[n].setOnClickListener(this);
            linearLayout.addView( imagesView[n]);
        }
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(this,""+v.getId(),Toast.LENGTH_SHORT).show();
    }
}