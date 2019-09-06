package com.gess.example.material;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.gess.example.R;

public class MaterialDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
    }

    public void design(View view) {
        switch (view.getId()){
            case R.id.design_tab:
                startActivity(new Intent(this, TabTestActivity.class));
                break;
        }
    }
}
