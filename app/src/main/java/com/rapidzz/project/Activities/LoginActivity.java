package com.rapidzz.project.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rapidzz.project.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Talhazk on 10-Mar-16.
 */

public class LoginActivity extends Activity {

    Button loginBtn,btn0,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn1 ,clearBtn;
    TextView tView;
    String formattedDate;
    EditText password;
    public static String pass="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tView = (TextView) findViewById(R.id.timeView);
        password = (EditText) findViewById(R.id.passText);

        loginBtn = (Button) findViewById(R.id.btnLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          String checker= checkPass();
                if(checker.equals("login")){
                    pass="";
                    Intent i = new Intent(getApplicationContext(), DecisionActivity.class);
                startActivity(i);
              }else if(checker.equals("empty")){
                    Toast.makeText(LoginActivity.this, "Please enter Password", Toast.LENGTH_SHORT).show();

                }else if(checker.equals("wrong")){
                    Toast.makeText(LoginActivity.this, "Password is wrong", Toast.LENGTH_SHORT).show();

                }
               }
        });
        // Now we display formattedDate value in TextView
        //TextView txtView = new TextView(this);
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // update TextView here!
                                Calendar c = Calendar.getInstance();
                          //      System.out.println("Current time => "+c.getTime());


                                SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");


                                formattedDate = df.format(c.getTime());
                                // formattedDate have current date/time


                                tView.setText(formattedDate);
                                tView.setGravity(Gravity.CENTER);
                                tView.setTextSize(20);

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }

        };
        t.start();
/*
        tView.setText(formattedDate);
        tView.setGravity(Gravity.CENTER);
        tView.setTextSize(20);
*/

        clearBtn = (Button) findViewById(R.id.clearButton);
        clearBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass = "";
                password.setText(pass);
            }
        });


        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               pass+="1";
               password.setText(pass);
            }
        });

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="2";
                password.setText(pass);
            }
        });

        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="3";
                password.setText(pass);
            }
        });

        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="4";
                password.setText(pass);
            }
        });

        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="5";
                password.setText(pass);
            }
        });

        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="6";
                password.setText(pass);}
        });

        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="7";
                password.setText(pass);
            }
        });

        btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="8";
                password.setText(pass);
            }
        });

        btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="9";
                password.setText(pass);
            }
        });

        btn0 = (Button) findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pass+="0";
                password.setText(pass);
            }
        });




    }

    public String checkPass(){
        if(pass.isEmpty()){
            return "empty";

        }else if(pass.equals("123456")){
            return "login";
        }else
        return "wrong";
    }





}
