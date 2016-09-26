package com.example.admin.quickscan.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.models.DashboardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    private ViewPager mViewPager;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout_feedbackdialog for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(viewPagerAdapter);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvDashboardItem);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        List<DashboardItem> list = new ArrayList<>();
        list.add(new DashboardItem("Resort Information", R.drawable.dash1,1));
        list.add(new DashboardItem("Local Attraction", R.drawable.dash1,1));
        list.add(new DashboardItem("Daily Schedule", R.drawable.dash1,1));
        list.add(new DashboardItem("World Class Spa", R.drawable.dash1,1));

        recyclerView.setAdapter(new RecyclerAdapterItem(list));
    }

    public static class ViewPagerFragment extends Fragment {

        private int resourceId;

        public ViewPagerFragment() {
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                resourceId = getArguments().getInt("resourceId");
            }
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.pager_item, null);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(resourceId);

        }
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private int[] mResources = {
                R.drawable.dash1,
                R.drawable.dash3,
                R.drawable.dash2
        };

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("resourceId", mResources[position]);
            viewPagerFragment.setArguments(bundle);
            return viewPagerFragment;
        }

        @Override
        public int getCount() {
            return mResources.length;
        }
    }

    public class RecyclerAdapterItem extends RecyclerView.Adapter<RecyclerAdapterItem.ViewHolder> {

        private List<DashboardItem> list;

        public RecyclerAdapterItem(List<DashboardItem> list) {
            this.list = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.recycler_item, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.imgtext1.setText(list.get(position).getItemName());
            holder.imgView1.setImageResource(list.get(position).getItemImageUrl());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private ImageView imgView1;
            private TextView imgtext1;

            public ViewHolder(View itemView) {
                super(itemView);
                imgtext1 = (TextView) itemView.findViewById(R.id.imgtext1);
                imgView1 = (ImageView) itemView.findViewById(R.id.imgView1);
            }
        }
    }
}


