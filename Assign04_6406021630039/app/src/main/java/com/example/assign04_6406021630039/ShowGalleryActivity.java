package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ShowGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnLufy, btnNami, btnSanji, btnUsop, btnSolo, btnShank, btnCoby, btnMihawk;
    private ImageView fullView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gallery);

        fullView = (ImageView) findViewById(R.id.fullView);
        fullView.setImageResource(R.drawable.lufy);

        btnLufy = (ImageButton) findViewById(R.id.btnLufy);
        btnLufy.setOnClickListener(this);

        btnNami = (ImageButton) findViewById(R.id.btnNami);
        btnNami.setOnClickListener(this);

        btnSanji = (ImageButton) findViewById(R.id.btnSanji);
        btnSanji.setOnClickListener(this);

        btnUsop = (ImageButton) findViewById(R.id.btnUsop);
        btnUsop.setOnClickListener(this);

        btnLufy = (ImageButton) findViewById(R.id.btnLufy);
        btnLufy.setOnClickListener(this);

        btnSolo = (ImageButton) findViewById(R.id.btnSolo);
        btnSolo.setOnClickListener(this);

        btnShank = (ImageButton) findViewById(R.id.btnShank);
        btnShank.setOnClickListener(this);

        btnCoby = (ImageButton) findViewById(R.id.btnCoby);
        btnCoby.setOnClickListener(this);

        btnMihawk = (ImageButton) findViewById(R.id.btnMihawk);
        btnMihawk.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        Resources resources = getResources();
        String imageName = "";
        if (viewId == R.id.btnLufy) {
            imageName = "lufy";
        } else if (viewId == R.id.btnNami) {
            imageName = "nami";
        } else if (viewId == R.id.btnSanji) {
            imageName = "sanji";
        } else if (viewId == R.id.btnUsop) {
            imageName = "usop";
        } else if (viewId == R.id.btnSolo) {
            imageName = "solo";
        } else if (viewId == R.id.btnShank) {
            imageName = "shank";
        } else if (viewId == R.id.btnCoby) {
            imageName = "coby";
        } else if (viewId == R.id.btnMihawk) {
            imageName = "mihawk";
        }

        int imageId = resources.getIdentifier(imageName, "drawable", getPackageName());
        fullView.setImageResource(imageId);

    }
}