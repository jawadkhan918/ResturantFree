package com.rapidzz.project.Activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.rapidzz.project.util.DividerItemDecoration;
import com.rapidzz.project.Model.KitchenModel;
import com.rapidzz.project.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talhazk on 18-Mar-16.
 */
public class ReportSpinnerAcitvity extends AppCompatActivity {
    public  static List<KitchenModel> listItems = new ArrayList<KitchenModel>();
    MyRecyclerAdapter adapter;
    Bitmap tempBitmap;
    String tempPath;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_layout);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MyRecyclerAdapter(listItems);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapter);
        getListItems();
        //    Toast.makeText(getApplicationContext(),tempPath , Toast.LENGTH_SHORT).show();
        //    Toast.makeText(getApplicationContext(),DataSave.listItems.get(0).getUserName() , Toast.LENGTH_SHORT).show();
        //    Toast.makeText(getApplicationContext(),"Alpha" , Toast.LENGTH_SHORT).show();

    }

    public  void  getListItems()
    {/*
        if(!listItems.isEmpty())
            listItems.clear();

        for (int i = 0; i<10 ; i++) {
            KitchenModel item = new KitchenModel("Class "+i);
            listItems.add(item);
        }
        return listItems;
*/
        KitchenModel movie = new KitchenModel("Sales", "Action & Adventure", "2015");
        listItems.add(movie);

        movie = new KitchenModel("Payment", "Animation, Kids & Family", "2015");
        listItems.add(movie);

        movie = new KitchenModel("Discount", "Action", "2015");
        listItems.add(movie);

        movie = new KitchenModel("Cash Out", "Animation", "2015");
        listItems.add(movie);

        movie = new KitchenModel("Staff Sales", "Science Fiction & Fantasy", "2015");
        listItems.add(movie);

        movie = new KitchenModel("Delivery", "Action", "2015");
        listItems.add(movie);

        movie = new KitchenModel("Profit", "Animation", "2009");
        listItems.add(movie);

        movie = new KitchenModel("Statistics", "Science Fiction", "2009");
        listItems.add(movie);

        movie = new KitchenModel("Sale Types", "Animation", "2014");
        listItems.add(movie);

        movie = new KitchenModel("Table Sales", "Action & Adventure", "2008");
        listItems.add(movie);

        movie = new KitchenModel("Category Amount", "Science Fiction", "1986");
        listItems.add(movie);

        movie = new KitchenModel("Category Quantity", "Animation", "2000");
        listItems.add(movie);

        movie = new KitchenModel("Item", "Science Fiction", "1985");
        listItems.add(movie);

        movie = new KitchenModel("Void Item", "Action & Adventure", "1981");
        listItems.add(movie);

        movie = new KitchenModel("Modifier Inventory", "Action & Adventure", "1965");
        listItems.add(movie);


        adapter.notifyDataSetChanged();
    }

    private  class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        //    private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 0;


        List<KitchenModel> listItems;

        public MyRecyclerAdapter(List<KitchenModel> listItems) {
            this.listItems = listItems;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_ITEM) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.report, parent, false);
                return new VHItem(v);

            }
            throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
        }

        private KitchenModel getItem(int position) {

            return listItems.get(position);
        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            KitchenModel currentItem = getItem(position);
            VHItem VHitem = (VHItem) holder;
            //    tempPath=currentItem.getPath();
           VHitem.checkBoxTxt.setText(currentItem.getDesc());
           if(currentItem.getDesc().equals("Sales") || currentItem.getDesc().equals("Profit")){
               VHitem.checkBoxTxt.setChecked(true);
           }

            //   VHitem.iv.setImageBitmap(camera.loadImageFromStorage(currentItem.getPath(),currentItem.getUserName()));


        }

        //    need to override this method
        @Override
        public int getItemViewType(int position) {
            return TYPE_ITEM;
        }

        //increasing getItemcount to 1. This will be the row of header.
        @Override
        public int getItemCount() {
            return listItems.size();
        }

        class VHItem extends RecyclerView.ViewHolder {
            public CheckBox checkBoxTxt;
            ImageView iv;

            public VHItem(View itemView) {
                super(itemView);

                this.checkBoxTxt = (CheckBox) itemView.findViewById(R.id.checkbox);
                //     this.iv = (ImageView)itemView.findViewById(R.id.ivListItem);
              //  itemView.setClickable(true);

      /*itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int positionImg = getAdapterPosition();
                        Toast.makeText(v.getContext(), "clickable " + positionImg, Toast.LENGTH_SHORT).show();

                        Intent intent;
                        intent = new Intent(getApplicationContext(), FullActivity.class);
                          // Selected image id
                        intent.putExtra("id", positionImg);
                        startActivity(intent);
                    }
                });
            }
        }
*/
            }
        }
    }
}
