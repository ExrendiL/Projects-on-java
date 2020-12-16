package com.example.tmone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button st_btn;
    private TextView cnt_txt;
    private CountDownTimer cdt;
    private long timeLeftInMiliSeconds = 600000;
    boolean trun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        st_btn = (Button)findViewById(R.id.st_btn);
        cnt_txt = (TextView)findViewById(R.id.cnt_txt);

        st_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startstop();
            }
        });

        updatetimer();

    }
    public void startstop(){
        if(trun){
         stoptimer();
        } else { starttimer();}
    }
    public void starttimer(){
        cdt = new CountDownTimer(timeLeftInMiliSeconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMiliSeconds = l;
                updatetimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        st_btn.setText("PAUSE");
        trun=true;
    }
    public void stoptimer(){
        cdt.cancel();
        st_btn.setText("START");
        trun=false;
    }

    public void updatetimer(){
        int min = (int) timeLeftInMiliSeconds / 60000;
        int sec = (int) timeLeftInMiliSeconds % 60000 / 1000;
        String tlt;

        tlt = "" + min;
        tlt += ":";
        if(sec < 10) tlt +="0" ;
        tlt  += sec;
        cnt_txt.setText(tlt);
    }

}