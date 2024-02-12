package com.example.lecture_9_container;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SearchViewActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener, AdapterView.OnItemClickListener {
    SearchView searchView;
    ListView listView;
    ArrayAdapter<String> adapter;
    String [] datas = {
            "Arjun", "Ankit", "Arvind",
            "Dipesh","Dinesh","Deven",
            "Java","Jeniva","Test","Thailand"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        searchView.setOnQueryTextListener(this);
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String itemValue = datas[position];
//        Toast.makeText(this, "Position: "+id + " Item clicked : "+itemValue,
//                Toast.LENGTH_SHORT).show();
    }
}