package com.example.admin.quickscan.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.fragments.CategoryFragment;

/**
 * Created by ADMIN on 24-01-2016.
 */
public class CategoryActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_category);
        loadFragment(new CategoryFragment(), "Category");
    }

    public void loadFragment(Fragment fragment, String tag){
        mFragmentManager.beginTransaction()
                .commit();
    }
}
