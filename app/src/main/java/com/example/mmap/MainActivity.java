package com.example.mmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import net.daum.mf.map.api.MapView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = findViewById(R.id.main_map);
        mapViewContainer.addView(mapView);*/

        Button list_btn=(Button) findViewById(R.id.list_btn);
        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ListActivity.class);
                startActivity(intent);
            }
        });
    }
}