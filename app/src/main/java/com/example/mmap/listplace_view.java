package com.example.mmap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class listplace_view extends ConstraintLayout {
    TextView place_name;
    public listplace_view(@NonNull Context context) {
        super(context);
        init(context);
    }

    public listplace_view(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listplace,this,true);

        place_name=(TextView) findViewById(R.id.place_name);

    }

    public void setName(String name){
        place_name.setText(name);
    }
}
