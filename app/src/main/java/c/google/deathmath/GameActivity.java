package c.google.deathmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Random random = new Random();
    int pointA;
    int pointB;
    TextView tv_math;
    TextView tv_result;
    TextView tv_pointA;
    TextView tv_pointB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv_math   = (TextView)findViewById(R.id.tv_math);
        tv_result = (TextView)findViewById(R.id.tv_result);
        tv_pointA = (TextView)findViewById(R.id.tv_pointA);
        tv_pointB = (TextView)findViewById(R.id.tv_pointB);

        pointA = random.nextInt(30);
        pointB = random.nextInt(5);
        tv_pointA.setText(""+pointA);
        tv_pointB.setText(""+pointB);
        getDataIntent(pointA, pointB);

    }

    public void getDataIntent(int pointA, int pointB){
        Intent myIntent = getIntent();

        int value = myIntent.getIntExtra("result", 0);
        if (value==0){
            int result;
            tv_pointA.setText(""+pointA);
            tv_math.setText("x");
            result = pointA*pointB;
            tv_result.setText(""+result);
        }else  if (value==1){
            if (pointB<1){
                pointB+=1;
            }
            double resultbagi;
            tv_math.setText("/");
            resultbagi = (double)pointA/pointB;
            tv_result.setText(String.format(String.valueOf(resultbagi)));
        }else if (value==2){
            int result;
            tv_math.setText("+");
            result = pointA+pointB;
            tv_result.setText(""+result);
        }else if (value==3){
            int result;
            tv_math.setText("-");
            result = pointA-pointB;
            tv_result.setText(""+result);
        }
    }
}
