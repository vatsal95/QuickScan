package com.example.admin.quickscan.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.models.BillDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillFragment extends Fragment {

    public BillFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cust_bill,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)  {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvBill);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<BillDetails> billDetailsList = new ArrayList<>();
        billDetailsList.add(new BillDetails(R.drawable.dash1,1,1,"Pizza","Rs.75","12/10/15"));
        billDetailsList.add(new BillDetails(R.drawable.dash1,1,1,"Pizza","Rs.75","12/10/15"));
        billDetailsList.add(new BillDetails(R.drawable.dash1,1,1,"Pizza","Rs.75","12/10/15"));
        billDetailsList.add(new BillDetails(R.drawable.dash1,1,1,"Pizza","Rs.75","12/10/15"));

        recyclerView.setAdapter(new RecylerBillAdpter(billDetailsList));

    }
    public class RecylerBillAdpter extends RecyclerView.Adapter<RecylerBillAdpter.ViewHolder>{

        private List<BillDetails> billDetailsList;

        public RecylerBillAdpter(List<BillDetails> billDetailsList) {
            this.billDetailsList = billDetailsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.cust_bill, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            BillDetails billDetails=billDetailsList.get(position);
            holder.product_image.setImageResource(billDetails.getProduct_pic());
            holder.product_name.setText(billDetails.getProduct_name());
            holder.product_price.setText(billDetails.getProduct_price());
            holder.qty.setText(billDetails.getQty());
            holder.date_order.setText(billDetails.getProduct_date());
        }

        @Override
        public int getItemCount() {
            return billDetailsList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView product_image;
            private TextView product_name,product_price,qty,date_order;
            public ViewHolder(View itemView) {
                super(itemView);
                product_image= (ImageView) itemView.findViewById(R.id.ivbill_product);
                product_name= (TextView) itemView.findViewById(R.id.tvbill_pro_name);
                product_price= (TextView) itemView.findViewById(R.id.tvbill_pro_price);
                qty= (TextView) itemView.findViewById(R.id.tvbill_pro_qty);
                date_order= (TextView) itemView.findViewById(R.id.tvbill_pro_date);
            }
        }
    }

}
