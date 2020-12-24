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

public class Mo extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText ed;
    private Button ad,nxt;
    private ListView listwiev;


    private ArrayList<String> itm;
    private ArrayAdapter<String> adpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo);
        nxt=(Button)findViewById(R.id.nxt);
        ed = (EditText)findViewById(R.id.ed);
        ad= (Button)findViewById(R.id.ad);


        listwiev=(ListView)findViewById(R.id.listwiev);

        itm=Flhlp.readD(this);

        adpr=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,itm);
        listwiev.setAdapter(adpr);

        ad.setOnClickListener(this);
        listwiev.setOnItemClickListener(this);
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
                Flhlp.wrtdat(itm,this);
                Toast.makeText(Mo.this, "Add", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        itm.remove(i);
        adpr.notifyDataSetChanged();
        Toast.makeText(Mo.this, "Deleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
        public void opn(){
            Intent intent= new Intent(this, Tu.class);
            startActivity(intent);

}

}