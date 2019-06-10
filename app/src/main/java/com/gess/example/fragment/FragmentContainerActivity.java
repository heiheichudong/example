package com.gess.example.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.gess.example.R;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentContainerActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        FragmentContainerStack.getInstance().addFragment(this,AFragment.newInstance("A","A"));
    }

    public void frag(View view){
        switch (view.getId()){
            case R.id.btn_frag:
                FragmentContainerStack.getInstance().addFragment(this,BFragment.newInstance("B","B"));
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
