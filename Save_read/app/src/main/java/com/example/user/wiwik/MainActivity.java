package com.example.user.wiwik;

import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText ed;
    private TextView  tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText)findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView);

    }
    public void read(View view)
    {
        try {
            FileInputStream fis = openFileInput("Slopa.txt");
            InputStreamReader isr = new InputStreamReader (fis);
            BufferedReader buff = new BufferedReader(isr);
            StringBuffer str = new StringBuffer();
            String f ;
            while ((f = buff.readLine()) != null){
               str.append(f + "\n");
            }
            tv.setText(str.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write (View view)
    {
        String oi = ed.getText().toString();
        try {
            FileOutputStream fos = openFileOutput("Slopa.txt",MODE_PRIVATE);
            try {
                fos.write(oi.getBytes());
                fos.close();
                ed.setText("");
                Toast.makeText(MainActivity.this, "Text saved", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
