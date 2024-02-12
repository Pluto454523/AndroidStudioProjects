package com.example.lecture_9_container;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListViewActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    private ListView listView;
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
        setContentView(R.layout.activity_custom_list_view);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,items, logos);
        listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter( adapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent,View view,int position,long id)
    {
        String itemValue = (String) listView.getItemAtPosition(position);
        Toast.makeText(this,itemValue,Toast.LENGTH_SHORT).show();

        Intent intentShowView = new Intent(this, ShowViewActivity.class);
        intentShowView.putExtra("position", position);
        startActivity(intentShowView);
    }
}

class CustomListViewAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String [] items;
    private final Integer [] logos;
    public CustomListViewAdapter(Context ctx, String []items, Integer [] logos) {
        super(ctx,R.layout.custom_layout_list_view, items);
        this.context = ctx;
        this.items = items;
        this.logos = logos;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_layout_list_view, null, true);
        TextView title = (TextView) rowView.findViewById(R.id.textView);
        ImageView image = (ImageView) rowView.findViewById(R.id.imageView);
        title.setText(items[position]);
        image.setImageResource(logos[position]);
        return rowView;
    }
}