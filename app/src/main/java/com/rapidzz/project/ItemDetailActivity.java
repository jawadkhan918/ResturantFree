package com.rapidzz.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtItemTitle;
    EditText edQty,edRemarks;
    RadioButton radioSizeBtn;
    private RadioGroup radioSize;
    Button btnAdd;
    String add = null;
    String red = null;
    CheckBox kwee,noodle;
    CheckBox garlic,corriander;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        txtItemTitle = (TextView)findViewById(R.id.txtItemTitle);
        Bundle extras = getIntent().getExtras();
        String mTitle;
        if(extras == null) {
            mTitle= null;
        } else {
            mTitle= extras.getString("title");
            txtItemTitle.setText(""+mTitle);
        }
        init();

    }
    public void init(){
        kwee = (CheckBox) findViewById(R.id.chkKweeTiaw) ;
        noodle = (CheckBox) findViewById(R.id.chkNoodle);
        garlic =  (CheckBox) findViewById(R.id.chkNoGarlic);
        corriander = (CheckBox) findViewById(R.id.chkNoCorriander);

        txtItemTitle = (TextView)findViewById(R.id.txtItemTitle);
        edQty = (EditText)findViewById(R.id.edQty);
        edRemarks = (EditText)findViewById(R.id.edRemarks);
        btnAdd = (Button)findViewById(R.id.btnAddItem);
        radioSize = (RadioGroup)findViewById(R.id.radioSize);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddItem:
               addOrder();
                break;
            case R.id.btnTakeout:
                break;



        }
    }
    public void addOrder(){
        if(!"".equals(edQty.getText().toString())){
            double qty = Double.parseDouble(edQty.getText().toString());
            String remarks = edRemarks.getText().toString();
            int selectedId = radioSize.getCheckedRadioButtonId();
            radioSizeBtn = (RadioButton) findViewById(selectedId);

            if(kwee.isChecked()){
                add = "Kwee";
            }else if(noodle.isChecked()){
                if(add.equals(null)){
                    add = "Noodle";
                }else{
                    add += ",Noodle";
                }
            }

            if(garlic.isChecked()){
                red = "No Garlic";
            }else if(corriander.isChecked()){
                if(red.equals(null)){
                    red = "No Corriander";
                }else{
                    red += ",No Corriander";
                }
            }


            TableGuestActivity.dishesList.add(new Dishes(1,qty, add,red,  remarks,radioSizeBtn.getText().toString()));
            finish();
           }
    }
}
