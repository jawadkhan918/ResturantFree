package com.rapidzz.project;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rapidzz.project.expandablerecycler.ExpandableRecyclerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryAdapter extends ExpandableRecyclerAdapter<CategoryAdapter.CategoryListItem> {
    public static final int TYPE_PERSON = 1001;
Context mContext;
    String tableNo,guest;
    HashMap<Integer,Order> orderList;
    public CategoryAdapter(Context context,String tableNo,String guest) {
        super(context);
        mContext = context;
        setItems(getSampleItems());
        orderList = new HashMap<Integer,Order>();
        this.tableNo = tableNo;
        this.guest = guest;

    }

    public static class CategoryListItem extends ExpandableRecyclerAdapter.ListItem {
        public String Text;
        public Items item;
        public Categories category;
        public CategoryListItem(Categories group) {
            super(TYPE_HEADER);

            category = group;
        }

        public CategoryListItem(Items itemGroup) {
            super(TYPE_PERSON);

            item = itemGroup;
        }
    }

    public class CategoryViewHolder extends ExpandableRecyclerAdapter.HeaderViewHolder {
        TextView name;
       // ImageView mImageView;

        public CategoryViewHolder(View view) {
            super(view, (ImageView) view.findViewById(R.id.item_arrow));

            name = (TextView) view.findViewById(R.id.item_header_name);
         //   mImageView = (ImageView)view.findViewById(R.id.item_image);
        }

        public void bind(int position) {
            super.bind(position);

            name.setText(visibleItems.get(position).category.getCat());
           /* Picasso.with(mContext)
                    .load(visibleItems.get(position).category.getmImage())
                    .resize(150, 150)                        // optional
                    .into(mImageView);*/
        }
    }

    public class ItemViewHolder extends ExpandableRecyclerAdapter.ViewHolder implements View.OnClickListener{
        TextView name,item_qty;
        ImageView mImageView;
        int parentPosition;

        public ItemViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.item_name);
            item_qty = (TextView) view.findViewById(R.id.item_qty);
            mImageView = (ImageView)view.findViewById(R.id.item_image);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    parentPosition = getAdapterPosition();
                    Items itemObj = visibleItems.get(parentPosition).item;
                  //  Toast.makeText(mContext,""+TableGuestActivity.dishesList.size(),Toast.LENGTH_SHORT).show();
                  //  Toast.makeText(mContext,visibleItems.get(parentPosition).item.getItemName(),Toast.LENGTH_SHORT).show();
                    if(orderList.containsKey(itemObj.getItemId())){

                        Intent i = new Intent(mContext, ItemDetailActivity.class);
                        i.putExtra("title",visibleItems.get(parentPosition).item.getItemName());
                        i.putExtra("itemID",visibleItems.get(parentPosition).item.getItemId());
                        Toast.makeText(mContext, "" + visibleItems.get(parentPosition).item.getItemId(), Toast.LENGTH_SHORT).show();

                        mContext.startActivity(i);
                      /*  Order order = orderList.get(itemObj.getItemId());
                        order.setQty(order.getQty()+1);*/
                    }else{
                        Intent i = new Intent(mContext, ItemDetailActivity.class);
                        i.putExtra("title",visibleItems.get(parentPosition).item.getItemName());
                        i.putExtra("itemID",visibleItems.get(parentPosition).item.getItemId());

                        mContext.startActivity(i);

                      //  orderList.put(itemObj.getItemId(),new Order(itemObj.getItemId(),1));
                    }
                    notifyDataSetChanged();
                  //  v.setBackgroundColor(Color.parseColor("#000000"));


                }
            });
        }

        public void bind(int position) {


            if(orderList.containsKey(visibleItems.get(position).item.getItemId())){
              //  item_qty.setText(""+orderList.get(visibleItems.get(position).item.getItemId()).getItemqty());
            }else{
                item_qty.setText("");
            }
            name.setText(visibleItems.get(position).item.getItemName());
            Picasso.with(mContext)
                    .load(visibleItems.get(position).item.getItemImage())
                    .resize(150, 150)                        // optional
                    .into(mImageView);

        }

        @Override
        public void onClick(View v) {


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return new CategoryViewHolder(inflate(R.layout.item_header, parent));
            case TYPE_PERSON:
            default:
                return new ItemViewHolder(inflate(R.layout.item_person, parent));
        }
    }

    @Override
    public void onBindViewHolder(ExpandableRecyclerAdapter.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                ((CategoryViewHolder) holder).bind(position);
                break;
            case TYPE_PERSON:
            default:
                ((ItemViewHolder) holder).bind(position);
                break;
        }
    }

    private List<CategoryListItem> getSampleItems() {
        List<CategoryListItem> items = new ArrayList<>();
        List<Categories> mCat = CategoriesList.get().getCategories();
        List<Items> mItem = ItemList.get().getItems();
        for(int i = 0;i<mCat .size();i++){
            items.add(new CategoryListItem(mCat.get(i)));
            for(int j = 0;j<mItem.size();j++){
               if(mItem.get(j).getCatId() == mCat.get(i).getId())
                   items.add(new CategoryListItem(mItem.get(j)));
            }
        }
        return items;
    }
}
