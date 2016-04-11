package com.rapidzz.project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rapidzz.project.R;

public class DecisionActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnDinein,btnTakeout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

    }

    public void init(){
        btnDinein = (Button)findViewById(R.id.btnDinein);
        btnTakeout = (Button)findViewById(R.id.btnTakeout);
        btnDinein.setOnClickListener(this);
        btnTakeout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDinein:
                Intent i = new Intent(DecisionActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.btnTakeout:
                Intent takeIntent = new Intent(DecisionActivity.this, TableGuestActivity.class);
                startActivity(takeIntent);
                break;



        }

    }
}
