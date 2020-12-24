package com.example.std;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fr extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText ed;
    private Button ad,pr,nxt;
    private ListView listwiev;


    private ArrayList<String> itm;
    private ArrayAdapter<String> adpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fr);

        ed = (EditText)findViewById(R.id.ed);
        ad= (Button)findViewById(R.id.ad);
        pr=(Button)findViewById(R.id.pr) ;
        nxt=(Button)findViewById(R.id.nxt);


        listwiev=(ListView)findViewById(R.id.listwiev);

        itm=Flhlp5.readD(this);

        adpr=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,itm);
        listwiev.setAdapter(adpr);

        ad.setOnClickListener(this);
        listwiev.setOnItemClickListener(this);

        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre();
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opn();
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ad:
                String itentr = ed.getText().toString();
                adpr.add(itentr);
                ed.setText("");

                Flhlp5.wrtdat(itm,this);
                Toast.makeText(Fr.this, "Add", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        itm.remove(i);
        adpr.notifyDataSetChanged();
        Toast.makeText(Fr.this, "Deleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public  void pre(){
        Intent intent= new Intent(this, Th.class);
        startActivity(intent);
    }

    public  void opn(){
        Intent intent= new Intent(this, Sa.class);
        startActivity(intent);
    }

}