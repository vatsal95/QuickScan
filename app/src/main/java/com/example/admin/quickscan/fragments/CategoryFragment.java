package com.example.admin.quickscan.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    public RecyclerView recyclerView;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout_feedbackdialog for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        List<Category> list = new ArrayList<>();
        list.add(new Category(1, "Gujarati", ""));
        list.add(new Category(1, "Punjabi", ""));
        list.add(new Category(1, "South Indian", ""));
        list.add(new Category(1, "Chinese", ""));
        list.add(new Category(1, "Maxican", ""));
        list.add(new Category(1, "Thai", ""));

        recyclerView.setAdapter(new RecyclerAdapterCategory(list));
    }

    public static class RecyclerAdapterCategory extends RecyclerView.Adapter<RecyclerAdapterCategory.ViewHolder> {

        private List<Category> listCategory;
       // private OnItemClickListener mItemClickListener;

        public RecyclerAdapterCategory(List<Category> listCategory) {
            this.listCategory = listCategory;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.list_item_category, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Category category = listCategory.get(position);
            holder.textView.setText(category.getCategoryName());
//            holder.imageView.setImageResource(category.getCategoryName());
        }

        @Override
        public int getItemCount() {
            return listCategory.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
           // OnItemClickListener mItemClickListener;
            private ImageView imageView;
            private TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                imageView = (ImageView) itemView.findViewById(R.id.ivListItemCategory);
                textView = (TextView) itemView.findViewById(R.id.tvListItemCategory);
            }

            @Override
            public void onClick(View v) {

                //Toast.makeText(v.getContext(),getOldPosition()+"clicked",Toast.LENGTH_LONG).show();
            }
        }
       /* public interface OnItemClickListener{
            public void onItemClick(View view,int position);
        }
        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener){
           this.mItemClickListener=mItemClickListener;
        }*/
    }
}
