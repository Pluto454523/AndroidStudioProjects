package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterViewFilpperActivity extends AppCompatActivity {
    private AdapterViewFlipper adapterViewFlipper;
    private int [] IMAGES = {
            R.drawable.deosai_land, R.drawable.dudipatsar_lake,
            R.drawable.rama_lake,R.drawable.shangrila_lower_kachura_lake
    };
    private String [] NAMES = {
            "deosai_land","dudipatsar_lake",

            "rama_lake","shangrila_lower_kachura_lake"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_filpper);
        adapterViewFlipper = (AdapterViewFlipper)

                findViewById(R.id.adapterViewFilpper);

        CustomAdapter customAdapter =

                new CustomAdapter(getApplicationContext(),NAMES, IMAGES);

        adapterViewFlipper.setAdapter(customAdapter);
        adapterViewFlipper.setFlipInterval(1000); // ก ําหนดเวลําในกํารเปลี่ยน
        adapterViewFlipper.setAutoStart(true); // สั่งให้เริ่มท ํางําน
    }
}
class CustomAdapter extends BaseAdapter {
    Context context;
    int [] images;
    String [] names;
    LayoutInflater inflater;
    public CustomAdapter(Context appContext,String [] names,int [] images)
    {
        this.context = appContext;
        this.images = images;
        this.names = names;
        inflater = (LayoutInflater.from(appContext));
    }
    @Override
    public int getCount() {
        return names.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_item, null);
        TextView name = (TextView) view.findViewById(R.id.name);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        name.setText( names[position]);
        image.setImageResource(images[position]);
        return view;
    }
}