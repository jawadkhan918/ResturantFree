package com.rapidzz.project;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import junit.framework.Test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    String loginURL = "http://www.pakwedds.com/Restaurant_app/get_table_list.php";
    private ProgressDialog mProcessDialog;
    public static boolean check = true;
    MyRecyclerAdapter adapter;
    RequestQueue requestQueue;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Button deliveryBtn, tabBtn, takeoutBtn, menuBtn, orderBtn;
    public List<TableModel> listItems = new ArrayList<TableModel>();
    private String[] paths = {"Drawer", "Delivery", "Expense", "Pay In/Out", "Customer", "Member Analyze", "Time Clock", "Receipt", "Report", "Database", "Settings", "Purchase", "LogOut"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_button_view);
        mProcessDialog = new ProgressDialog(this);
        mProcessDialog.setMessage("Loading...");
        mProcessDialog.setCancelable(false);
        requestQueue = Volley.newRequestQueue(this);

        if (listItems.isEmpty())
            getTableList();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);

        adapter = new MyRecyclerAdapter(listItems);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, paths);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new function());


        deliveryBtn = (Button) findViewById(R.id.deliveryBtn);
        deliveryBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), DeliveryActivity.class);
                startActivity(i);
            }
        });


        takeoutBtn = (Button) findViewById(R.id.takeoutBtn);
        takeoutBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), TakeoutActivity.class);
                startActivity(i);
            }
        });


        orderBtn = (Button) findViewById(R.id.orderButton);
        orderBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), MainOrderActivity.class);
                startActivity(i);
            }
        });


        tabBtn = (Button) findViewById(R.id.tabButton);
        tabBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                TabFragment tabFragment = new TabFragment();
                tabFragment.show(fm, "Sample Fragment");
            }
        });


        menuBtn = (Button) findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                spinner.performClick();

            }
        });


    }

    private void getTableList() {
        mProcessDialog.show();
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, loginURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray ja = response.getJSONArray("data");

                            for (int i = 0; i < ja.length(); i++) {

                                JSONObject jsonObject = ja.getJSONObject(i);
                                int status = Integer.parseInt(jsonObject.optString("status").toString());
                                int table_id = Integer.parseInt(jsonObject.optString("table_id").toString());
                                String table_number = jsonObject.optString("table_number").toString();
                                int table_numperson = Integer.parseInt(jsonObject.optString("table_numperson").toString());

                                int table_status = Integer.parseInt(jsonObject.optString("table_status").toString());
                                int table_active = Integer.parseInt(jsonObject.optString("table_active").toString());

                                String table_name = jsonObject.getString("table_name");

                                TableModel model = new TableModel(status, table_id, table_number, table_numperson, table_name, table_status, table_active);
                                listItems.add(model);
                                Log.i("name is", table_name);
                                adapter.notifyDataSetChanged();
                                mProcessDialog.dismiss();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            mProcessDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mProcessDialog.dismiss();
                        Log.e("Volley", "Error" + error.toString());

                    }
                }
        );

        int socketTimeout = 20000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jor.setRetryPolicy(policy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jor);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnDinein:
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.btnTakeout:
                Intent takeIntent = new Intent(MainActivity.this, TableGuestActivity.class);
                startActivity(takeIntent);
                break;

        }
    }

    public class function implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
                                   long id) {
            String selection = ((TextView) arg1).getText().toString();
            if (selection.equals("Drawer")) {
                Toast.makeText(getApplicationContext(), "Drawer", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Delivery")) {
                Intent intent = new Intent(getApplicationContext(), DeliverySpinnerActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "delivery", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Expense")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Expense ", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Pay In/Out")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Pay In/out", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Customer")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Customer", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Member Analyze")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Member Analyze", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Time Clock")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Time Clock", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Receipt")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Receipt", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Report")) {
                Intent intent = new Intent(getApplicationContext(), ReportSpinnerAcitvity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Report", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Database")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "db", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Settings")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Settings")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("Purchase")) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Purchase", Toast.LENGTH_SHORT).show();
            } else if (selection.equals("LogOut")) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();

                Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();

            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    public void guestMethod(String tableNo) {
        //      tToast("Go button cli
        FragmentManager fm = getFragmentManager();
        //FragmentManager fm = this.getFragmentManager();
        NumberGuestsFragment guests = new NumberGuestsFragment(tableNo);
        guests.show(fm, "Sample Fragment");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        //    private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 0;
        RelativeLayout table1,table2;
        List<TableModel> listItems;
        TextView table1Manager;

        public MyRecyclerAdapter(List<TableModel> listItems) {
            this.listItems = listItems;
         //   table1 = (RelativeLayout)findViewById(R.id.table1);
          //  table2 = (RelativeLayout)findViewById(R.id.table2);



        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_ITEM) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_buttons, parent, false);
                return new VHItem(v);

            }
            throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
        }

        private TableModel getItem(int position) {


            return listItems.get(position);

        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TableModel currentItem = getItem(position);
            VHItem VHitem = (VHItem) holder;
            Log.i("1", currentItem.getTable_name());
            Log.i("2", currentItem.getTable_name());
            if (VHitem.table1.getVisibility() == View.GONE && check == true) {
                check = false;
                VHitem.table1.setVisibility(View.VISIBLE);
                VHitem.table1Text.setText(currentItem.getTable_name());
            } else {
                check = true;
                VHitem.table2.setVisibility(View.VISIBLE);
                VHitem.table2Text.setText(currentItem.getTable_name());
            }

        }

        @Override
        public int getItemViewType(int position) {
            return TYPE_ITEM;
        }

        @Override
        public int getItemCount() {
            return listItems.size();
        }

        class VHItem extends RecyclerView.ViewHolder {
            TextView txtName;
            ImageView iv;
            public RelativeLayout table1;
            public RelativeLayout table2;
            public int position;
            TextView table1Manager, table1Guest, table1Time, table2Manager, table2Guest, table2Time, table1Text, table2Text;
            Button mangoBtn;
            TextView mango;

            public VHItem(View itemView) {
                super(itemView);

                this.table1Text = (TextView) itemView.findViewById(R.id.textView1);
                this.table2Text = (TextView) itemView.findViewById(R.id.textView2);

                this.table1 = (RelativeLayout) itemView.findViewById(R.id.table1);
                this.table2 = (RelativeLayout) itemView.findViewById(R.id.table2);
                table1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        table1Manager = (TextView)findViewById(R.id.table1Manager);
                       // Toast.makeText(MainActivity.this,table1Text.getText().toString(),Toast.LENGTH_SHORT).show();
                        guestMethod(table1Text.getText().toString());
                    }
                });
                table2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        }
    }


}
