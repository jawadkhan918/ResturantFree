package com.rapidzz.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talhazk on 16-Mar-16.
 */

public class OrderedFragment extends Fragment {


    public LinearLayout popUp;
    Button paymentBtn;
    public  static List<KitchenModel> listItems = new ArrayList<KitchenModel>();
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recyclerview_ordered_layout, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getListItems());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        popUp = (LinearLayout) rootView.findViewById(R.id.pop_up);
        paymentBtn = (Button) rootView.findViewById(R.id.paymentButton);

        return rootView;
    }

    public  List<KitchenModel> getListItems()
    {
        if(!listItems.isEmpty())
            listItems.clear();

        for (int i = 0; i<10 ; i++) {
            KitchenModel item = new KitchenModel("Delivery","Enable Delivery"," RS 1312");
            listItems.add(item);
        }
        return listItems;

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
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ordered_fragment, parent, false);
                return new VHItem(v);

            }
            throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
        }

        private KitchenModel getItem(int position) {

            return listItems.get(position);
        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            //          KitchenModel currentItem = getItem(position);
            VHItem VHitem = (VHItem) holder;
            //    tempPath=currentItem.getPath();
//            VHitem.txtName.setText(currentItem.getUserName());
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
            TextView txtName;
            ImageView iv;

            public VHItem(View itemView) {
                super(itemView);

                //               this.txtName = (TextView) itemView.findViewById(R.id.txtName);
                //     this.iv = (ImageView)itemView.findViewById(R.id.ivListItem);
                //             itemView.setClickable(true);

      itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int position = getAdapterPosition();
                        Toast.makeText(v.getContext(), "clickable " + position, Toast.LENGTH_SHORT).show();
                        if(popUp.getVisibility()==View.GONE)
                        {
                            popUp.setVisibility(View.VISIBLE);
                            paymentBtn.setVisibility(View.GONE);
                        }
                        else {
                            popUp.setVisibility(View.GONE);
                            paymentBtn.setVisibility(View.VISIBLE);

                        }
/*
                        Intent intent;
                        intent = new Intent(getApplicationContext(), FullActivity.class);
                          // Selected image id
                        intent.putExtra("id", positionImg);
                        startActivity(intent);
*/
                    }
                });
            }
        }



    }
}



