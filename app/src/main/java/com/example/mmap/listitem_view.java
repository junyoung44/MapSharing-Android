package com.example.mmap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
public class listitem_view extends LinearLayout {

    TextView map_name;

    public listitem_view(Context context) {
        super(context);
        init(context);
    }

    public listitem_view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listitem,this,true); //인플레이션 이제 xml 참조 가능

        map_name=(TextView) findViewById(R.id.item_name);

    }

    public void setName(String name){
        map_name.setText(name);
    }
}
