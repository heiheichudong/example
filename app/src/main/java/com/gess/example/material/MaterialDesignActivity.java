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
        switch (view.getId()) {
            case R.id.design_tab:
                startActivity(new Intent(this, TabbedActivity.class));
                break;
            case R.id.design_drawer:
                startActivity(new Intent(this, DrawerActivity.class));
                break;
            case R.id.design_bottom_nav:
                startActivity(new Intent(this, BottomNavigationActivity.class));
                break;
            case R.id.design_flow:
                startActivity(new Intent(this, ItemListActivity.class));
                break;
            case R.id.design_basic:
                startActivity(new Intent(this, BasicActivity.class));
                break;
            case R.id.design_fullscreen:
                startActivity(new Intent(this, FullscreenActivity.class));
                break;
            case R.id.design_fragment:
                startActivity(new Intent(this, FragmentActivity.class));
                break;
        }
    }
}
