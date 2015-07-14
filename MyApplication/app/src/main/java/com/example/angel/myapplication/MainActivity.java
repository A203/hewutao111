package com.example.angel.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import java.lang.*;
public class MainActivity extends Activity {
    EditText yourHeight=null;
    EditText yourWeight=null;
    Button calculateButton=null;
    TextView result=null;
    float yourBMI=0;
    RadioGroup groupSex=null;
    RadioButton radioButtonMan=null;
    RadioButton radioButtonWoman=null;
    boolean isMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yourHeight=(EditText) findViewById(R.id.myHeight);
      yourWeight=(EditText) findViewById(R.id.myWeight);
        calculateButton=(Button) findViewById(R.id.buttonCalculate);
        result=(TextView) findViewById(R.id.textViewResult);
        groupSex=(RadioGroup) findViewById(R.id.radioGroup1);
        radioButtonMan=(RadioButton) findViewById(R.id.radioMan);
        radioButtonWoman=(RadioButton) findViewById(R.id.radioWoman);
        isMan=true;
        groupSex.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                if(id==radioButtonWoman.getId()){
                    isMan=false;
                }

            }

        });
        calculateButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yourHeight.getText().toString().trim().equals("")) {
                    result.setText("必须填写身高（CM）");
                    return;
                }
                if (yourWeight.getText().toString().trim().equals("")) {
                    result.setText("必须填写体重（KG）");
                    return;
                }
                int height = Integer.parseInt(yourHeight.getText().toString().trim());
                int weight = Integer.parseInt(yourWeight.getText().toString().trim());
                yourBMI = (float) (weight / (Math.pow(height / 100.0, 2)));
                String strResult = "";

                StringBuffer strbuf=new StringBuffer();
                strbuf.append("你的BMI为："+yourBMI);
                if (isMan) {
                    if (yourBMI < 20) {
                        strResult = "您的体重偏轻，多吃点吧有钱";
                    } else if (yourBMI >= 20 && yourBMI <= 25) {
                        strResult = "适中";
                    } else if (yourBMI > 25 && yourBMI <= 30) {
                        strResult = "过重";
                    } else if (yourBMI > 30 && yourBMI <= 35) {
                        strResult = "肥胖";
                    } else {
                        strResult = "死猪该减肥了，别吃零食了出去运动吧!";
                    }
                } else {
                    if (yourBMI < 19) {
                        strResult = "您的体重偏轻，多吃点吧有钱";
                    } else if (yourBMI >= 19 && yourBMI <= 24) {
                        strResult = "适中";
                    } else if (yourBMI > 24 && yourBMI <= 29) {
                        strResult = "过重";
                    } else if (yourBMI > 29 && yourBMI <= 34) {
                        strResult = "肥胖";
                    } else {
                        strResult = "死猪该减肥了，别吃零食了出去运动吧!";
                    }
                }
                strbuf.append(strResult);
                result.setText(strbuf.toString());

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
