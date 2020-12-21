package com.example.mdplr;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView elapse, rem;
    Button plbtn;
    SeekBar pl, vol;
    MediaPlayer mp;
    int totaltm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plbtn = (Button) findViewById(R.id.plbtn);
        elapse = (TextView) findViewById(R.id.elapse);
        rem = (TextView) findViewById(R.id.rem);



        mp = MediaPlayer.create(this, R.raw.mus);
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);
        totaltm = mp.getDuration();

        pl = (SeekBar) findViewById(R.id.pl);
        pl.setMax(totaltm);
        pl.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mp.seekTo(progress);
                            pl.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        vol = (SeekBar) findViewById(R.id.vol);
        vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float volnm = i/ 100f;
                mp.setVolume(volnm,volnm);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
             while (mp!=null)
             {
             try {
                 Message msg = new Message();
                 msg.what = mp.getCurrentPosition();
                 handler.sendMessage(msg);
                 Thread.sleep(1000);
             } catch (InterruptedException e){}
             }
            }
        }).start();
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage (Message mss)
        {
          int currentPosition = mss.what;
          pl.setProgress(currentPosition);

          String elapsedTime = createTimeLabel(currentPosition);
            elapse.setText(elapsedTime);

            String reaningTime = createTimeLabel(totaltm-currentPosition);
            rem.setText("-"+reaningTime);

        }
    };


    public String createTimeLabel (int time)
    {
String tmlb = "";
int min = time/1000/60;
        int sec = time/1000%60;
        tmlb = min + ":";
        if (sec<10) tmlb+="0";
        tmlb+=sec;
        return tmlb;


    }


    public void plbtnClick  (View view) {
        if (!mp.isPlaying()) {
            mp.start();
            plbtn.setBackgroundResource(R.drawable.pau);
        } else {
            mp.pause();
            plbtn.setBackgroundResource(R.drawable.pla);
        }

    }

}
