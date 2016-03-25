package com.rapidzz.project;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Talhazk on 09-Mar-16.
 */
public class DeliveryActivity extends AppCompatActivity {
    Button confimbtn;
    EditText telText,nameText,address1Text,address2Text,address3Text,zipCodeText,mailText;
    RadioGroup optionRadioGroup,timingRadioGroup ;
    RadioButton deliveryRadioBtn,nowRadioBtn,pickUpRadioBtn,timeRadioBtn;
    TextView timeText;
    String telString,nameString,address1String,address2String,address3String,zipCodeString,mailString ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.delivery_activity_layout);

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        supportActionBar.show();
      //  bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
     //   supportActionBar.


        telText = (EditText)findViewById(R.id.tel);
        nameText = (EditText)findViewById(R.id.name);
        address1Text = (EditText)findViewById(R.id.address1);
        address2Text = (EditText)findViewById(R.id.address2);
        address3Text = (EditText)findViewById(R.id.address3);
        zipCodeText = (EditText)findViewById(R.id.zipCode);
        mailText = (EditText)findViewById(R.id.mail);


        telString = telText.getText().toString();
        nameString = nameText.getText().toString();
        address1String = address1Text.getText().toString();
        address2String = address2Text.getText().toString();
        address3String = address3Text.getText().toString();
        zipCodeString = zipCodeText.getText().toString();
        mailString = mailText.getText().toString();

/*

        // get action bar
        android.app.ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
*/
         optionRadioGroup= (RadioGroup) findViewById(R.id.optionGroup);

        optionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.deliveryRadio) {
                    Toast.makeText(getApplicationContext(), "delivery",
                            Toast.LENGTH_SHORT).show();
                    timingRadioGroup.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.pickUpRadio) {
                    Toast.makeText(getApplicationContext(), "pickup",
                            Toast.LENGTH_SHORT).show();
                    //timingRadioGroup.setEnabled(false);
                    timingRadioGroup.setVisibility(View.INVISIBLE);
                }

            }
        });

        timingRadioGroup= (RadioGroup) findViewById(R.id.timingGroup);

        timingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.nowRadio) {
                    Toast.makeText(getApplicationContext(), "now radio",
                            Toast.LENGTH_SHORT).show();
                    timeText.setVisibility(View.INVISIBLE);
                } else if (checkedId == R.id.timeRadio) {
                    Toast.makeText(getApplicationContext(), "time radio and time show",
                            Toast.LENGTH_SHORT).show();
                    timeText.setVisibility(View.VISIBLE);
                }

            }
        });

        confimbtn = (Button)findViewById(R.id.confirmButton);
        confimbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            //    if (feildCheck()) {
                    // TODO Auto-generated method stub
                    Intent i = new Intent(getApplicationContext(), TableGuestActivity.class);
                    startActivity(i);
                /*}else if(feildCheck()&&Utility.validate(mailString)){
                    Toast.makeText(getApplicationContext(),"invalid email",Toast.LENGTH_SHORT).show();
*/
              /*  } else {
                    Toast.makeText(getApplicationContext(),"please fill the feilds",Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public Boolean feildCheck(){
        if((telString.isEmpty()||nameString.isEmpty()||address1String.isEmpty()||zipCodeString.isEmpty())){
            return false;
        }

        return true;
    }
}


//1866