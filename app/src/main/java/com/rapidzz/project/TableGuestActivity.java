package com.rapidzz.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rapidzz.project.expandablerecycler.ExpandableRecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Talhazk on 11-Mar-16.
 */
public class TableGuestActivity extends AppCompatActivity {
    RecyclerView recycler;
    CategoryAdapter adapter;
    private ProgressDialog mProcessDialog;
    public static ArrayList<Dishes> dishesList;
    int number;
    public HashMap<String, String> paramMap;
    String loginURL = "http://www.pakwedds.com/Restaurant_app/get_item_list.php";
    RequestQueue requestQueue;
    private Categories catModel;
    private Items itemModel;
    public List<Categories> listCategories;
    public List<Items> listItems;
    private RecyclerView mCategoryRecyclerView;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_guest_activity);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        paramMap = new HashMap<String, String>();
        AppCompatImageView b = (AppCompatImageView) this.findViewById(R.id.new_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TableGuestActivity.this, OrderDetailActivity.class);
                startActivity(i);


                Toast.makeText(TableGuestActivity.this, "CALLED", Toast.LENGTH_SHORT).show();
            }
        });
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                Log.e("ORDER", "EXTRAS null");
                if (dishesList.size() > 0) {
                    if (extras != null) {
                        JSONObject jsonObj = new JSONObject();
                        JSONArray jsonArray = new JSONArray();
                        Log.e("ORDER", "EXTRAS");
                        try {

                            jsonObj.put("table_id", extras.getInt("tableID")); // Set the first name/pair
                            jsonObj.put("num", extras.getString("guest"));
                            Log.e("ORDERRRR", extras.getString("guest"));
                            for (int i = 0; i < dishesList.size(); i++) {
                                JSONObject pnObj = new JSONObject();
                                pnObj.put("item_id", dishesList.get(i).getDishId());
                                pnObj.put("qty", dishesList.get(i).getDishQty());
                                pnObj.put("size", dishesList.get(i).getDishSize());
                                pnObj.put("aditem", dishesList.get(i).getDishAdd());
                                pnObj.put("reditem", dishesList.get(i).getDishReduction());
                                pnObj.put("reditem", dishesList.get(i).getDishRemarks());
                                jsonArray.put(pnObj);

                            }
                            OrderList.get().addOrder(new Order(extras.getInt("tableID"), extras.getString("guest"), dishesList));
                            jsonObj.put("detail", jsonArray);
                            paramMap.put("order", jsonObj.toString());
                            Log.e("ORDERRRR", paramMap.get("order").toString());
                            makeStringReq("http://www.pakwedds.com/Restaurant_app/do_add_order.php", 2, paramMap);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }else{
                    Toast.makeText(TableGuestActivity.this,"No Dish Added",Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(TableGuestActivity.this, "Submit", Toast.LENGTH_SHORT).show();
            }
        });
        listCategories = CategoriesList.get().getCategories();
        listItems = ItemList.get().getItems();
        mProcessDialog = new ProgressDialog(this);
        mProcessDialog.setMessage("Loading...");
        mProcessDialog.setCancelable(false);
        dishesList = new ArrayList<Dishes>();
        recycler = (RecyclerView) findViewById(R.id.main_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Log.e("CALLED", "ONCREATE CALLED");

        dishesList = new ArrayList<Dishes>();
        makeStringReq(loginURL, 1, null);
    }


    public void makeStringReq(String url, int num, HashMap<String, String> map) {
        number = num;
        mProcessDialog.show();
        int req;
        if (num == 1) {
            req = Request.Method.GET;
        } else {
            req = Request.Method.POST;
        }

        StringRequest strReq = new StringRequest(req,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (number == 1)
                    loadCat(response);
                else if (number == 2)
                    submitOrder(response);
                Log.e("RESPONSE", response);

                mProcessDialog.dismiss();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());
                mProcessDialog.dismiss();
                Toast.makeText(TableGuestActivity.this, "Error " + error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Map<String, String> map = new HashMap<String, String>();

                return paramMap;

            }

        };
        int socketTimeout = 20000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        strReq.setRetryPolicy(policy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strReq);
    }

    public void loadCat(String response) {
        listCategories.clear();
        listItems.clear();
        String type = "";
        try {
            new JSONObject(response);
            type = "Object";
        } catch (JSONException ex) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                new JSONArray(response);
                type = "Array";
            } catch (JSONException ex1) {
                type = "Invalid";
            }
        }

        Log.e("TYPPPPEEEE", type);
        if (response != null) {
            try {
                JSONObject jo = new JSONObject(response);
                String status = jo.getString("status");
                Log.e("STATUS", status);
                if (jo.has("data")) {

                    JSONArray cast = jo.getJSONArray("data");
                    if (cast != null) {

                        for (int i = 0; i < cast.length(); i++) {
                            JSONObject jsonObj = cast.getJSONObject(i);
                            Log.e("DATA", "" + jsonObj);

                            JSONArray dishes = jsonObj.getJSONArray("dishes");
                            Log.e("DATA", "" + dishes);
                            List<Items> mItemList = ItemList.get().getItems();
                            for (int j = 0; j < dishes.length(); j++) {
                                JSONObject dishObj = dishes.getJSONObject(j);
                                Items item = new Items(dishObj.getString("item_name"), dishObj.getString("item_image"), dishObj.getDouble("item_price"), dishObj.getInt("item_id"), dishObj.getInt("cat_id"));
                                mItemList.add(item);
                            }
                            Categories cat = new Categories(jsonObj.getInt("cat_id"), jsonObj.getString("cat_name"), jsonObj.getString("cat_image"));
                            listCategories.add(cat);

                            Log.e("ARRAY", cast.getJSONObject(i).getString("cat_id"));
                            //JSONObject data = cast.getJSONObject(i);
                        }
                    }
                }
                Bundle extras = getIntent().getExtras();
                String mTitle;
                if (extras == null) {
                    mTitle = null;
                    adapter = new CategoryAdapter(TableGuestActivity.this, "", "");
                } else {

                    adapter = new CategoryAdapter(TableGuestActivity.this, extras.getString("tableID"), extras.getString("guest"));
                }

                adapter.setMode(ExpandableRecyclerAdapter.MODE_ACCORDION);
                recycler.setAdapter(adapter);
            } catch (Exception ex) {
                Log.e("EXception", "" + ex);
            }
        }
    }

    public void submitOrder(String response) {
        Log.e("submitOrder", "" + response);
        /*for (int j = 0; j < OrderList.get().getOrders().size(); j++) {
            for (int i = 0; i < MainActivity.listItems.size(); i++) {
                if (OrderList.get().getOrders().get(j).getTableId() == MainActivity.listItems.get(i).getTable_id()) {
                   TableModel tab =  MainActivity.listItems.get(i);
                    MainActivity.listItems.remove(i);
                    MainActivity.listItems.add(i, tab);
                    Log.e("SIZE", MainActivity.listItems.get(i).getTable_name());

                }
            }

        }*/

        finish();
//Toast.makeText(TableGuestActivity.this,""+response,Toast.LENGTH_SHORT);

    }
}

