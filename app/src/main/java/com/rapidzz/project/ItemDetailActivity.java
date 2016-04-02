package com.rapidzz.project;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtItemTitle;
    EditText edQty, edRemarks;
    RadioButton radioSizeBtn;
    private RadioGroup radioSize;
    Button btnAdd;
    String mTitle = "", mRemarks = "", size = "", additional, reduction;
    double qty;
    int position = -1;
    int itemId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        txtItemTitle = (TextView) findViewById(R.id.txtItemTitle);
        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            mTitle = null;
        } else {
            mTitle = extras.getString("title");
            itemId = extras.getInt("itemID");
            txtItemTitle.setText("" + mTitle);

            Log.e("DISHPOS", "" + extras.getString("dishPos"));
            if (extras.getString("dishPos") != null || "".equals(extras.getString("dishPos"))) {
                Toast.makeText(ItemDetailActivity.this, "" + extras.getString("dishPos"), Toast.LENGTH_SHORT).show();
                position = Integer.parseInt(extras.getString("dishPos"));
                mRemarks = TableGuestActivity.dishesList.get(position).getDishRemarks();
                qty = TableGuestActivity.dishesList.get(position).getDishQty();
                size = TableGuestActivity.dishesList.get(position).getDishSize();
                additional = TableGuestActivity.dishesList.get(position).getDishAdd();
                reduction = TableGuestActivity.dishesList.get(position).getDishAdd();

            }
        }
        init();

    }

    public void init() {
        txtItemTitle = (TextView) findViewById(R.id.txtItemTitle);
        edQty = (EditText) findViewById(R.id.edQty);
        edRemarks = (EditText) findViewById(R.id.edRemarks);
        btnAdd = (Button) findViewById(R.id.btnAddItem);
        radioSize = (RadioGroup) findViewById(R.id.radioSize);
        if (qty > 0)
            edQty.setText("" + qty);
        edRemarks.setText("" + mRemarks);
        if (size.equals("Small")) {
            radioSizeBtn = (RadioButton) findViewById(R.id.radioSmall);
            radioSize.check(R.id.radioSmall);
        } else if (size.equals("Medium")) {
            radioSizeBtn = (RadioButton) findViewById(R.id.radioMedium);
            radioSize.check(R.id.radioMedium);
        } else if (size.equals("Large")) {
            radioSizeBtn = (RadioButton) findViewById(R.id.radioLarge);
            radioSize.check(R.id.radioLarge);
        }
        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddItem:
                if(position>= 0)
                    updateOrder();

                else{
                    addOrder();
                }
                break;
            case R.id.btnTakeout:
                break;
        }
    }

    public void addOrder() {
        if (!"".equals(edQty.getText().toString())) {
            double qty = Double.parseDouble(edQty.getText().toString());
            String remarks = edRemarks.getText().toString();
            int selectedId = radioSize.getCheckedRadioButtonId();
            radioSizeBtn = (RadioButton) findViewById(selectedId);
            TableGuestActivity.dishesList.add(new Dishes(itemId, qty, "", "", remarks, radioSizeBtn.getText().toString(), mTitle));
            Toast.makeText(ItemDetailActivity.this, "" + itemId, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void updateOrder(){
        if (!"".equals(edQty.getText().toString())) {
            double qty = Double.parseDouble(edQty.getText().toString());
            String remarks = edRemarks.getText().toString();
            int selectedId = radioSize.getCheckedRadioButtonId();
            radioSizeBtn = (RadioButton) findViewById(selectedId);
            itemId = TableGuestActivity.dishesList.get(position).getDishId();
            TableGuestActivity.dishesList.remove(position);
            TableGuestActivity.dishesList.add(position, new Dishes(itemId, qty, "", "", remarks, radioSizeBtn.getText().toString(), mTitle));
            Toast.makeText(ItemDetailActivity.this, "" + itemId, Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
