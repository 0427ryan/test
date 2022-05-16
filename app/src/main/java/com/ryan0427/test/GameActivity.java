package com.ryan0427.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private int arr[][] = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    private TextView[] views;

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
        views = new TextView[]{
                findViewById(R.id.cell00),findViewById(R.id.cell01),findViewById(R.id.cell02),findViewById(R.id.cell03),
                findViewById(R.id.cell10),findViewById(R.id.cell11),findViewById(R.id.cell12),findViewById(R.id.cell13),
                findViewById(R.id.cell20),findViewById(R.id.cell21),findViewById(R.id.cell22),findViewById(R.id.cell23),
                findViewById(R.id.cell30),findViewById(R.id.cell31),findViewById(R.id.cell32),findViewById(R.id.cell33)
        };
        refresh();
    }

    public void refresh(){
        for(int i = 0 ; i < 16 ; i++){
            int value = arr[i / 4][i % 4];
            views[i].setText(value > 0 ? String.valueOf(value) : "");
        }
    }

    public void toLeft(View view){
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(arr[i][j] != 0){
                    continue;
                }
                int temp = 4;
                for(int k = j + 1 ; k < 4 ; k++){
                    if(arr[i][k] != 0){
                        temp = k;
                        break;
                    }
                }
                if(temp == 4)
                    continue;
                arr[i][j] = arr[i][temp];
                arr[i][temp] = 0;
                if(j != 0 && arr[i][j - 1] == arr[i][j]){
                    arr[i][j - 1] *= 2;
                }
            }
        }
        refresh();
    }
    public void toRight(View view){

        refresh();
    }
    public void toTop(View view){

        refresh();
    }
    public void toBottom(View view){

        refresh();
    }
}