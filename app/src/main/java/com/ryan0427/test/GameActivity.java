package com.ryan0427.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import java.security.SecureRandom;

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
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
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

    public void addNewCell(){
        SecureRandom rand = new SecureRandom();
        int num = (rand.nextInt(2) + 1) * 2;
        int bound = 16;
        for(int i = 0 ; i < 4 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                if(arr[i][j] != 0){
                    bound--;
                }
            }
        }
        int place = rand.nextInt(bound);
        for(int i = 0 ; i < 4 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                if(arr[i][j] == 0 && --place == 0){
                    arr[i][j] = num;
                    return;
                }
            }
        }
    }

    public void toLeft(View view){
        for(int row = 0 ; row < 4 ; row++){
            for(int col = 0 ; col < 3 ; col++){
                int index1, index2;
                for(index1 = col; index1 < 4 && arr[row][index1] == 0 ; index1++);
                for(index2 = index1+1; index2 < 4 && arr[row][index2] == 0 ; index2++);
                if(index1 >= 4){
                    break;
                }
                if(index1 != col){
                    arr[row][col] = arr[row][index1];
                    arr[row][index1] = 0;
                }
                if(index2 < 4 && arr[row][col] == arr[row][index2]){
                    arr[row][col] *= 2;
                    arr[row][index2] = 0;
                }
            }
        }
        addNewCell();
        refresh();
    }
    public void toRight(View view){
        for(int row = 0 ; row < 4 ; row++){
            for(int col = 0 ; col < 3 ; col++){
                int index1, index2;
                for(index1 = col; index1 < 4 && arr[row][3 - index1] == 0 ; index1++);
                for(index2 = index1+1; index2 < 4 && arr[row][3 - index2] == 0 ; index2++);
                if(index1 >= 4){
                    break;
                }
                if(index1 != col){
                    arr[row][3 - col] = arr[row][3 - index1];
                    arr[row][3 - index1] = 0;
                }
                if(index2 < 4 && arr[row][3 - col] == arr[row][3 - index2]){
                    arr[row][3 - col] *= 2;
                    arr[row][3 - index2] = 0;
                }
            }
        }
        addNewCell();
        refresh();
    }
    public void toTop(View view){
        for(int col = 0 ; col < 4 ; col++){
            for(int row = 0 ; row < 3 ; row++){
                int index1, index2;
                for(index1 = row; index1 < 4 && arr[index1][col] == 0 ; index1++);
                for(index2 = index1+1; index2 < 4 && arr[index2][col] == 0 ; index2++);
                if(index1 >= 4){
                    break;
                }
                if(index1 != row){
                    arr[row][col] = arr[index1][col];
                    arr[index1][col] = 0;
                }
                if(index2 < 4 && arr[row][col] == arr[index2][col]){
                    arr[row][col] *= 2;
                    arr[index2][col] = 0;
                }
            }
        }
        addNewCell();
        refresh();
    }
    public void toBottom(View view){
        for(int col = 0 ; col < 4 ; col++){
            for(int row = 0 ; row < 3 ; row++){
                int index1, index2;
                for(index1 = row     ; index1 < 4 && arr[3 - index1][col] == 0 ; index1++);
                for(index2 = index1+1; index2 < 4 && arr[3 - index2][col] == 0 ; index2++);
                if(index1 >= 4){
                    break;
                }
                if(index1 != row){
                    arr[3 - row][col] = arr[3 - index1][col];
                    arr[3 - index1][col] = 0;
                }
                if(index2 < 4 && arr[3 - row][col] == arr[3 - index2][col]){
                    arr[3 - row][col] *= 2;
                    arr[3 - index2][col] = 0;
                }
            }
        }
        addNewCell();
        refresh();
    }
}