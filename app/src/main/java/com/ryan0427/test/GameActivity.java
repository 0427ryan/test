package com.ryan0427.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    private int arr[][] = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Playing");
        init();
    }


    public void init(){
        arr = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
    }

    public void refresh(View view){

    }

    public void toLeft(View view){

        refresh(view);
    }
    public void toRight(View view){

        refresh(view);
    }
    public void toTop(View view){

        refresh(view);
    }
    public void toBottom(View view){

        refresh(view);
    }
}