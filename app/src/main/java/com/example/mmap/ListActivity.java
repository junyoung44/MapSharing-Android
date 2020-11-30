package com.example.mmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView map_list;
    ArrayList<item> items = new ArrayList<item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        items.add(new item("김준영"));
        items.add(new item("김태현"));
        items.add(new item("김희동"));

        Adapter adapter = new Adapter(getApplicationContext(),R.layout.listitem,items);

        map_list=(ListView) findViewById(R.id.map_list);
        map_list.setAdapter(adapter);



        map_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),MapListActivity.class);
                intent.putExtra("map_name", items.get(position).name);

                Toast.makeText(getApplicationContext(),items.get(position).name,Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });
        Button append_btn = findViewById(R.id.append_btn);
        append_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewListActivity.class);
                startActivity(intent);
            }
        });
    }

    class Adapter extends BaseAdapter {
        Context context;
        int layout;
        ArrayList<item> items;
        LayoutInflater inf;
        public Adapter(Context context, int layout, ArrayList<item> items){
            this.context=context;
            this.layout=layout;
            this.items=items;
            inf=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null) {
                convertView = inf.inflate(layout, null);
            }

            TextView item_name = (TextView)convertView.findViewById(R.id.item_name);
            item t=items.get(position);
            item_name.setText(t.name);

            return convertView;
        }

        public void addItem(item item){
            items.add(item);
        }
    }

}