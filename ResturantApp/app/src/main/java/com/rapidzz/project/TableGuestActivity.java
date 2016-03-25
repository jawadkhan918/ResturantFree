package com.rapidzz.project;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talhazk on 11-Mar-16.
 */
public class TableGuestActivity extends AppCompatActivity {
    Button sendBtn, nameGuests, addGuests, backBtn, clearBtn, customerBtn, guestBtn, searchBtn, cat1Btn, cat2Btn, cat3Btn, cat4Btn, cat5Btn, cat6Btn, dish1, dish2, dish3, dish4, dish5, dish6, dish7;
    String loginURL = "http://www.pakwedds.com/Restaurant_app/get_item_list.php";
    RequestQueue requestQueue;
    public CategoriesModel catModel, itemModel;
    public List<CategoriesModel> listCategories = new ArrayList<CategoriesModel>();
    public List<CategoriesModel> listItems = new ArrayList<CategoriesModel>();
    private RecyclerView mCategoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_guest_activity);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestQueue = Volley.newRequestQueue(this);
      
        if (listCategories.isEmpty())
            getDishes();


/*

        cat1Btn.setVisibility(View.VISIBLE);
        cat1Btn.setText(catModel.getCatName());
*/
/*

        if(listCategories!=null) {
            for (int i = 1; i <= listCategories.size(); i++) {
                if (i == 1) {
                    cat1Btn.setVisibility(View.VISIBLE);
                    cat1Btn.setText(catModel.getCatName());
                }else if(i==2){
                    cat2Btn.setVisibility(View.VISIBLE);
                    cat2Btn.setText(catModel.getCatName());
                }else if(i==3){
                    cat3Btn.setVisibility(View.VISIBLE);
                    cat3Btn.setText(catModel.getCatName());
                }else if(i==4){
                    cat4Btn.setVisibility(View.VISIBLE);
                    cat4Btn.setText(catModel.getCatName());
                }
            }
        }
*/

        nameGuests = (Button) findViewById(R.id.customerButton);
        addGuests = (Button) findViewById(R.id.guestButton);
        backBtn = (Button) findViewById(R.id.backButton);
        clearBtn = (Button) findViewById(R.id.clearButton);
        customerBtn = (Button) findViewById(R.id.customerButton);
        guestBtn = (Button) findViewById(R.id.guestButton);
        searchBtn = (Button) findViewById(R.id.searchButton);
        cat1Btn = (Button) findViewById(R.id.saladButton);
        cat2Btn = (Button) findViewById(R.id.sandwichButton);
        cat3Btn = (Button) findViewById(R.id.mainButton);
        cat4Btn = (Button) findViewById(R.id.appetizerButton);
        cat5Btn = (Button) findViewById(R.id.sweetButton);
        cat6Btn = (Button) findViewById(R.id.drinkButton);
        dish1 = (Button) findViewById(R.id.dish1);
        dish2 = (Button) findViewById(R.id.dish2);
        dish3 = (Button) findViewById(R.id.dish3);
        dish4 = (Button) findViewById(R.id.dish4);
        dish5 = (Button) findViewById(R.id.dish5);
        dish6 = (Button) findViewById(R.id.dish6);
        sendBtn = (Button) findViewById(R.id.sendButton);

/*
        cat1Btn.requestFocus();

*/


        sendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), OrderingTabs.class);
                startActivity(i);
                finish();
            }
        });


        //backBtn = (Button) findViewById(R.id.orderBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        addGuests.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                //FragmentManager fm = this.getFragmentManager();
                AddNoOfGuestsFragment fragment = new AddNoOfGuestsFragment();
                fragment.show(fm, "Fragment");
            }
        });


        nameGuests.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                //FragmentManager fm = this.getFragmentManager();

                AddNameOfGuestsFragment fragment = new AddNameOfGuestsFragment();
                fragment.show(fm, "Name Fragment");
            }
        });


        cat1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("item cal 12", "" + itemModel.getItemName());
                if (itemModel.getCatId() == catModel.getCatId()) {
                    dish1.setVisibility(View.VISIBLE);
                    dish1.setText(itemModel.getItemName());
                    Log.i("item cal if statement", "" + itemModel.getItemName());
                }


                //dish5.setVisibility(View.VISIBLE);
                // dish6.setVisibility(View.INVISIBLE);

                Toast.makeText(getApplicationContext(), "cat1", Toast.LENGTH_SHORT).show();
            }
        });

        cat2Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "cat2", Toast.LENGTH_SHORT).show();

            }
        });

        cat3Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "cat3", Toast.LENGTH_SHORT).show();

            }
        });


        cat4Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.INVISIBLE);
                dish6.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "cat4", Toast.LENGTH_SHORT).show();

            }
        });


        cat5Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "cat5", Toast.LENGTH_SHORT).show();

            }
        });


        cat6Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dish5.setVisibility(View.VISIBLE);
                dish6.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "cat6", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void getDishes() {
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, loginURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {


                            JSONArray ja = response.getJSONArray("data");
//                            JSONArray jaDishes = response.getJSONArray("dishes");;


                            for (int i = 0; i < ja.length(); i++) {

                                JSONObject jsonObject = ja.getJSONObject(i);
                                int catId = Integer.parseInt(jsonObject.optString("cat_id").toString());
                                String catName = jsonObject.getString("cat_name");

                                int k = i;
                                Log.i("loop", "" + k);
                                dataCatModel(catId, catName);
                                setButtons(k, catName);


                                JSONArray jd = jsonObject.getJSONArray("dishes");
//

                                for (int j = 0; j < jd.length(); j++) {
                                    JSONObject jsonObjectDishes = jd.getJSONObject(j);
                                    //   if(jsonObjectDishes != null){
                                    int itemId = Integer.parseInt(jsonObjectDishes.optString("cat_id").toString());
                                    String itemName = jsonObjectDishes.getString("item_name");
                                    int itemPrice = Integer.parseInt(jsonObjectDishes.optString("item_price").toString());

                                    dataItemModel(itemId, itemName, itemPrice);
                                    Log.i("cat id of item", "" + itemId);
                                    Log.i("name of item", itemName);
                                    Log.i("price of item", "" + itemPrice);

                                }


                                Log.i("cat id", "" + catId);
                                Log.i("name is", catName);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error" + error.toString());

                    }
                }
        );

        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jor.setRetryPolicy(policy);
        //  mRequestQueue.add(request);
        requestQueue.add(jor);


    }

    private void dataCatModel(int catId, String catName) {
        catModel = new CategoriesModel(catId, catName);
        listCategories.add(catModel);

    }

    private void dataItemModel(int itemId, String itemName, int itemPrice) {
        itemModel = new CategoriesModel(itemId, itemName, itemPrice);
        listItems.add(itemModel);
    }

    private void setButtons(int k, String catName) {
        Log.i("the value of k", "" + k);

        switch (k) {
            case 0:
                cat1Btn.setVisibility(View.VISIBLE);
                cat1Btn.setText(catName);
                break;
            case 1:
                cat2Btn.setVisibility(View.VISIBLE);
                cat2Btn.setText(catName);
                break;
            case 2:
                cat3Btn.setVisibility(View.VISIBLE);
                cat3Btn.setText(catName);
                break;
            case 3:
                cat4Btn.setVisibility(View.VISIBLE);
                cat4Btn.setText(catName);
                break;
            case 4:
                cat5Btn.setVisibility(View.VISIBLE);
                cat5Btn.setText(catName);
                break;
            case 5:
                cat6Btn.setVisibility(View.VISIBLE);
                cat6Btn.setText(catName);
                break;
        }


    }
}

