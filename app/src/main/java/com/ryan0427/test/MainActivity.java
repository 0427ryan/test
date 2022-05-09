package com.ryan0427.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int arr[][] = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent switchActivityIntent = new Intent(this, GameActivity.class);
        startActivity(switchActivityIntent);
//        R.id.downbt
        Log.d("test", "On Create");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("test", "On Start");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("test", "On Resume");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("test", "On Stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("test", "On Destroy");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("test", "On Pause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("test", "On Restart");
    }

}
