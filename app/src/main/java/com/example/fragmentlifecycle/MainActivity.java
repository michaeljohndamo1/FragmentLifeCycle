package com.example.fragmentlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.container) != null){
            if(savedInstanceState != null){
                return;
            }

            HeadLinesFragment headLinesFragment = new HeadLinesFragment();

            headLinesFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                    .add(R.id.container,headLinesFragment)
                    .commit();


        }

    }
}
