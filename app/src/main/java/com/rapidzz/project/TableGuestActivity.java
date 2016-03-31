package com.rapidzz.project;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
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

    String loginURL = "http://www.pakwedds.com/Restaurant_app/get_item_list.php";
    RequestQueue requestQueue;
    private Categories catModel;
    private Items itemModel;
    public List<Categories> listCategories;
    public List<Items> listItems;
    private RecyclerView mCategoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_guest_activity);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppCompatImageView b = (AppCompatImageView) this.findViewById(R.id.new_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TableGuestActivity.this,"CALLED",Toast.LENGTH_SHORT).show();
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
        makeStringReq(loginURL);
    }


  public void makeStringReq(String url) {

          mProcessDialog.show();

      //RequestFuture<String> requestFuture = RequestFuture.newFuture();
      StringRequest strReq = new StringRequest(Request.Method.POST,
              url, new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {
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

              Log.e("TYPPPPEEEE",type);
              if(response != null) {
                  try {
                      JSONObject jo = new JSONObject(response);
                      String status = jo.getString("status");
                      Log.e("STTAUS",status);
                      if (jo.has("data")) {

                          JSONArray cast = jo.getJSONArray("data");
                          if (cast != null) {

                              for (int i = 0; i < cast.length(); i++) {
                                  JSONObject jsonObj = cast.getJSONObject(i);
                                  Log.e("DATA",""+jsonObj);

                                  JSONArray dishes = jsonObj.getJSONArray("dishes");
                                  Log.e("DATA",""+dishes);
                                List<Items> mItemList = ItemList.get().getItems();
                                  for(int j = 0; j < dishes.length(); j++) {
                                      JSONObject dishObj = dishes.getJSONObject(j);
                                      Items item = new Items(dishObj.getString("item_name"),dishObj.getString("item_image"), dishObj.getDouble("item_price"), dishObj.getInt("item_id"), dishObj.getInt("cat_id"));
                                      mItemList.add(item);
                                  }
                                  Categories cat = new Categories(jsonObj.getInt("cat_id"),jsonObj.getString("cat_name"),jsonObj.getString("cat_image"));
                                  listCategories.add(cat);

                                  Log.e("ARRAY",cast.getJSONObject(i).getString("cat_id"));
                                  //JSONObject data = cast.getJSONObject(i);
                              }
                          }
                      }
                      Bundle extras = getIntent().getExtras();
                      String mTitle;
                      if(extras == null) {
                          mTitle= null;
                          adapter = new CategoryAdapter(TableGuestActivity.this,"","");
                      } else {

                          adapter = new CategoryAdapter(TableGuestActivity.this,extras.getString("tableID"),extras.getString("guest"));
                      }

                      adapter.setMode(ExpandableRecyclerAdapter.MODE_ACCORDION);
                      recycler.setAdapter(adapter);
                  } catch (Exception ex){
                    Log.e("EXception",""+ex);
                  }
              }
              Log.e("RESPONSE",response);

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
              Map<String, String> map = new HashMap<String, String>();

              return map;

          }

      };
      int socketTimeout = 20000;//30 seconds - change to what you want
      RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
              DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
      strReq.setRetryPolicy(policy);

      RequestQueue requestQueue = Volley.newRequestQueue(this);
      requestQueue.add(strReq);
  }
}

