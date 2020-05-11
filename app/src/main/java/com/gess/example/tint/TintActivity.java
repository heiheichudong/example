package com.gess.example.tint;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gess.example.R;

import java.util.ArrayList;

public class TintActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tint);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("CLEAR");
        strings.add("SRC");
        strings.add("DST");
        strings.add("SRC_OVER");
        strings.add("DST_OVER");
        strings.add("SRC_IN");
        strings.add("DST_IN");
        strings.add("SRC_OUT");
        strings.add("DST_OUT");
        strings.add("SRC_ATOP");
        strings.add("DST_ATOP");
        strings.add("XOR");
        strings.add("DARKEN");
        strings.add("LIGHTEN");
        strings.add("MULTIPLY");
        strings.add("SCREEN");
        strings.add("ADD");
        strings.add("OVERLAY");
        recyclerView = ((RecyclerView) findViewById(R.id.rv_tint));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TintAdapter adapter = new TintAdapter(this,strings);
        recyclerView.setAdapter(adapter);
    }
}
