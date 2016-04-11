package com.rapidzz.project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rapidzz.project.R;

/**
 * Created by Talhazk on 10-Mar-16.
 */
public class TakeoutActivity  extends AppCompatActivity {
    Button orderBtn;
    Button backBtn,clearBtn,customerBtn,guestBtn,searchBtn,saladBtn,sandwichBtn ,mainBtn,appetizerBtn,sweetBtn,drinkBtn,dish1,dish2,dish3,dish4,dish5,dish6,dish7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeout_layout);
       /* backBtn = (Button) findViewById(R.id.backButton);
        clearBtn = (Button) findViewById(R.id.clearButton);
//        customerBtn = (Button) findViewById(R.id.customerButton);
  //      guestBtn = (Button) findViewById(R.id.guestButton);
        searchBtn = (Button) findViewById(R.id.searchButton);
        saladBtn = (Button) findViewById(R.id.saladButton);
        sandwichBtn = (Button) findViewById(R.id.sandwichButton);
        mainBtn = (Button) findViewById(R.id.mainButton);
        appetizerBtn = (Button) findViewById(R.id.appetizerButton);
        sweetBtn = (Button) findViewById(R.id.sweetButton);
        drinkBtn = (Button) findViewById(R.id.drinkButton);
        dish1 = (Button) findViewById(R.id.dish1);
        dish2 = (Button) findViewById(R.id.dish2);
        dish3 = (Button) findViewById(R.id.dish3);
        dish4 = (Button) findViewById(R.id.dish4);
        dish5 = (Button) findViewById(R.id.dish5);
        dish6 = (Button) findViewById(R.id.dish6);
        saladBtn.requestFocus();


        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            finish();

                      }
        });



        orderBtn = (Button) findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(i);
                finish();
            }
        });


        saladBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.INVISIBLE);
                dish6.setVisibility(View.INVISIBLE);
            }
        });

        saladBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.INVISIBLE);
                dish6.setVisibility(View.INVISIBLE);
            }
        });

        sandwichBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
            }
        });

        mainBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
            }
        });


        appetizerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.INVISIBLE);
                dish6.setVisibility(View.INVISIBLE);
            }
        });


        sweetBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
            }
        });


        drinkBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
            }
        });

*/

    }
}
