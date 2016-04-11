package com.rapidzz.project.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rapidzz.project.Model.Dishes;
import com.rapidzz.project.R;

import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {

  //  private List<Dishes> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrderDetailAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        recyclerView = (RecyclerView) findViewById(R.id.dish_recycler);

        mAdapter = new OrderDetailAdapter(TableGuestActivity.dishesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);


    }

    private class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.MyViewHolder> {

        private List<Dishes> dishesList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtDishName, txtDishQty;
            ImageButton imgCancel;

            public MyViewHolder(View view) {
                super(view);
                txtDishName = (TextView) view.findViewById(R.id.txtDishName);
                txtDishQty = (TextView) view.findViewById(R.id.txtDishQty);
                imgCancel = (ImageButton)view.findViewById(R.id.imgCross);

                imgCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dishesList.remove(getAdapterPosition());
                        mAdapter.notifyItemRemoved(getAdapterPosition());
                    }
                });
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OrderDetailActivity.this, ItemDetailActivity.class);
                        i.putExtra("title", dishesList.get(getAdapterPosition()).getDishName());
                        i.putExtra("dishPos", "" + getAdapterPosition());
                    //    Toast.makeText(OrderDetailActivity.this,""+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }
                });
            }
        }


        public OrderDetailAdapter(List<Dishes> dishesList) {
            this.dishesList = dishesList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_order_detail, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Dishes dish = dishesList.get(position);
            holder.txtDishName.setText(""+dish.getDishName());
            holder.txtDishQty.setText(""+dish.getDishQty());
        }

        @Override
        public int getItemCount() {
            return dishesList.size();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }
}
