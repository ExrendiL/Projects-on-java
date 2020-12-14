package com.example.user.cungalunga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View v)
    {
        EditText num1 = (EditText)findViewById(R.id.editText2);
        EditText num2 = (EditText)findViewById(R.id.editText3);
        TextView res = (TextView)findViewById(R.id.Res);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int resS = n1 + n2;
        res.setText(Integer.toString(resS));
    }
    public void onButtonClick3(View v)
    {
        EditText num1 = (EditText)findViewById(R.id.editText2);
        EditText num2 = (EditText)findViewById(R.id.editText3);
        TextView res = (TextView)findViewById(R.id.Res);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int resS = n1 - n2;
        res.setText(Integer.toString(resS));
    }
    public void onButtonClick1(View e)
    {
        EditText num1 = (EditText)findViewById(R.id.editText2);
        EditText num2 = (EditText)findViewById(R.id.editText3);
        TextView res = (TextView)findViewById(R.id.Res);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int resS = n1 * n2;
        res.setText(Integer.toString(resS));
    }
    public void onButtonClick2(View w)
    {
        EditText num1 = (EditText)findViewById(R.id.editText2);
        EditText num2 = (EditText)findViewById(R.id.editText3);
        TextView res = (TextView)findViewById(R.id.Res);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int resS = n1 / n2;
        res.setText(Integer.toString(resS));
    }
    
}
