package com.example.admin.quickscan.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.activities.RegistrationActivity;
import com.example.admin.quickscan.models.ProductDetails;
import com.example.admin.quickscan.recycler_scroll_click;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 19-02-2016.
 */
public class ProductFragment extends Fragment {
    public ProductFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ProductDetails> productDetailsList = new ArrayList<>();
        productDetailsList.add(new ProductDetails(1, "Pizza", "Rs.70","1","12/01/2016", R.drawable.dash1));
        productDetailsList.add(new ProductDetails(1, "Sandwich", "Rs.70","1","12/01/2016", R.drawable.dash1));
        productDetailsList.add(new ProductDetails(1, "Dabeli", "Rs.70","1","12/01/2016", R.drawable.dash1));
        productDetailsList.add(new ProductDetails(1, "Vadapav", "Rs.70","1","12/01/2016", R.drawable.dash1));

        recyclerView.setAdapter(new ProductRecyclerAdapter(productDetailsList));


    }

    public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder> implements View.OnClickListener {

        private List<ProductDetails> productDetailsList;

        public ProductRecyclerAdapter(List<ProductDetails> productDetailsList) {
            this.productDetailsList = productDetailsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.product_detail, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ProductDetails productDetails = productDetailsList.get(position);
            holder.product_image.setImageResource(productDetails.getProduct_Image());
            holder.product_name.setText(productDetails.getProduct_Name());
            holder.product_price.setText(productDetails.getProduct_Price());
            holder.qty.setText(productDetails.getQty());
            holder.order_date.setText(productDetails.getDate_Order());
        }


        @Override
        public int getItemCount() {
            return productDetailsList.size();
        }

        @Override
        public void onClick(View v) {

           // startActivity(new Intent(this,recycler_scroll_click.class));

        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView product_image;
            private TextView product_name, product_price, item_name, item_price,qty,order_date;
            private CheckBox chkproduct;

            public ViewHolder(View itemView) {
                super(itemView);
                product_image = (ImageView) itemView.findViewById(R.id.ivproduct);
                product_name = (TextView) itemView.findViewById(R.id.tvproduct_name);
                product_price = (TextView) itemView.findViewById(R.id.tvproduct_price);

                qty = (TextView) itemView.findViewById(R.id.tvproduct_qty);
                order_date = (TextView) itemView.findViewById(R.id.tvproduct_date);
           /*     item_name= (TextView) itemView.findViewById(R.id.tvproduct_item_name);
                item_price= (TextView) itemView.findViewById(R.id.tvproduct_item_price);
                chkproduct= (CheckBox) itemView.findViewById(R.id.chkProduct);*/
            }
        }

    }
}
