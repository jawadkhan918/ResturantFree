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

            TableGuestActivity.dishesList.add(new Dishes(1,qty, "","",  remarks,radioSizeBtn.getText().toString()));
            finish();
           }
    }
}
