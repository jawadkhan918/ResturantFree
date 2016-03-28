package com.rapidzz.project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rapidzz.project.expandablerecycler.ExpandableRecyclerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends ExpandableRecyclerAdapter<CategoryAdapter.CategoryListItem> {
    public static final int TYPE_PERSON = 1001;
Context mContext;
    public CategoryAdapter(Context context) {
        super(context);
        mContext = context;
        setItems(getSampleItems());
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
        ImageView mImageView;

        public CategoryViewHolder(View view) {
            super(view, (ImageView) view.findViewById(R.id.item_arrow));

            name = (TextView) view.findViewById(R.id.item_header_name);
            mImageView = (ImageView)view.findViewById(R.id.item_image);
        }

        public void bind(int position) {
            super.bind(position);

            name.setText(visibleItems.get(position).category.getCat());
            Picasso.with(mContext)
                    .load(visibleItems.get(position).category.getmImage())
                    .resize(150, 150)                        // optional
                    .into(mImageView);
        }
    }

    public class ItemViewHolder extends ExpandableRecyclerAdapter.ViewHolder {
        TextView name;
        ImageView mImageView;

        public ItemViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.item_name);
            mImageView = (ImageView)view.findViewById(R.id.item_image);
        }

        public void bind(int position) {
            name.setText(visibleItems.get(position).item.getItemName());
            Picasso.with(mContext)
                    .load(visibleItems.get(position).item.getItemImage())
                    .resize(150, 150)                        // optional
                    .into(mImageView);
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
        for(int i = 0;i<mCat .size();i++){
            items.add(new CategoryListItem(mCat.get(i)));
            for(int j = 0;j<mCat.get(i).getItemList().size();j++){
                items.add(new CategoryListItem(mCat.get(i).getItemList().get(j)));
            }
        }

        return items;
    }
}
