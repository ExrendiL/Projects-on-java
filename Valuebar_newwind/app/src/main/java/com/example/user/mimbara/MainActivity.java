package com.example.user.mimbara;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.RatingBar;
public class MainActivity extends AppCompatActivity {
private Button but,btn,b3;
    private EditText pass;
    private TextView t;
    private RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         addListenerOnButton();
    }
    public void addListenerOnButton()
    {
        pass = (EditText)findViewById(R.id.editText);
        but = (Button)findViewById(R.id.button);
        btn = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.b3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(".Lol");
                startActivity(in);

            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(MainActivity.this,pass.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        rb = (RatingBar)findViewById(R.id.ratingBar);
        t = (TextView)findViewById(R.id.textView3);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                t.setText("Value: "+ String.valueOf(rating));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,n.getText(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder a =  new AlertDialog.Builder(MainActivity.this);
                a.setMessage("Close?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                                            }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog al = a.create();
                al.setTitle("Close app");
                al.show();
            }
        });
    }
}
