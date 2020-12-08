package com.example.casis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView txt,txt2,txt3,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Random rnd = new Random();




        Button btn = (Button)findViewById(R.id.button);
        final TextView txn = (TextView)findViewById(R.id.txt);
        final TextView txn2 = (TextView)findViewById(R.id.txt2);
        final TextView txn3 = (TextView)findViewById(R.id.txt3);

          final TextView ress = (TextView)findViewById(R.id.res);
        final TextView ress1 = (TextView)findViewById(R.id.res1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double w,f,c,k;
                txn.setText(String.valueOf(rnd.nextInt(6)));
                txn2.setText(String.valueOf(rnd.nextInt(6)));
                txn3.setText(String.valueOf(rnd.nextInt(6)));

                String S1 = txn.getText().toString();
                String S2 = txn2.getText().toString();
                String S3 = txn3.getText().toString();

                w = Double.parseDouble(S1);
                f = Double.parseDouble(S2);
                k = Double.parseDouble(S3);

                c = w+f+k;

                String S = Double.toString(c);




               ress.setText(S);
                if (c==10.0){ ress1.setText("win middle");}
                if (c==11.0){ ress1.setText("win liltle bit");}
               if (c==12.0){ ress1.setText("win ok");}
               if (c==13.0){ ress1.setText("win good");}
                if (c==14.0){ ress1.setText("win bonus");}
                if (c==15.0){ ress1.setText("win kush bitch kush");}

                if (c==9.0){ ress1.setText(" ");}
                if (c==8.0){ ress1.setText(" ");}
                if (c==7.0){ ress1.setText(" ");}
                if (c==6.0){ ress1.setText(" ");}
                if (c==5.0){ ress1.setText(" ");}
                if (c==4.0){ ress1.setText(" ");}
                if (c==3.0){ ress1.setText(" ");}
                if (c==2.0){ ress1.setText(" ");}
                if (c==1.0){ ress1.setText("fail");}
                if (c==0.0){ ress1.setText("fail realy fail");}
            }


        });
    }

}
