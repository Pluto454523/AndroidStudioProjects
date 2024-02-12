package com.example.lecture_9_container;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowViewActivity extends AppCompatActivity {

    String [] items = {
            "arsenal", "chelsea", "leicester", "liverpool",
            "manchester_city", "manchester_united"
    };

    Integer [] logos = {

            R.drawable.arsenal_logo,R.drawable.chelsea_logo,
            R.drawable.leicester_logo,R.drawable.liverpool_logo,
            R.drawable.manchester_city_logo,
            R.drawable.manchester_united_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_view);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        ImageView imageShowView = (ImageView) findViewById(R.id.imageShowView);
        imageShowView.setImageResource(logos[position]);

        TextView title = (TextView) findViewById(R.id.textShowView);
        title.setText(items[position]);
    }
}