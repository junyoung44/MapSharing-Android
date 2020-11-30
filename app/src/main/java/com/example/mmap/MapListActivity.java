package com.example.mmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MapListActivity extends AppCompatActivity {

    ListView place_list;
    Adapter adapter =new Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);

        place_list=findViewById(R.id.place_list);
        place_list.setAdapter(adapter);

        TextView map_name=(TextView) findViewById(R.id.map_name);

        Intent intent=getIntent();
        map_name.setText(intent.getStringExtra("map_name"));

        adapter.addItem(new place("맛집1"));
        adapter.addItem(new place("맛집2"));
        adapter.addItem(new place("맛집3"));
    }


    class Adapter extends BaseAdapter {
        ArrayList<place> places = new ArrayList<place>();

        @Override
        public int getCount() {
            return places.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            listplace_view view = new listplace_view((getApplicationContext()));

            place place=places.get(position);
            view.setName(place.getName());
            return view;
        }

        public void addItem(place place){
            places.add(place);
        }
    }
}
