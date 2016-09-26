package com.example.admin.quickscan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.fragments.BillFragment;
import com.example.admin.quickscan.fragments.CategoryFragment;
import com.example.admin.quickscan.fragments.DashboardFragment;
import com.example.admin.quickscan.fragments.ProductFragment;
import com.example.admin.quickscan.recycler_scroll_click;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadFragment(new DashboardFragment(), DashboardFragment.class.getSimpleName(), false);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            loadFragment(new DashboardFragment(), "Dashboard", false);
        } else if (id == R.id.nav_services) {
          //  loadFragment(new ServicesFragment(), "Services", false);
               //loadFragment(new CategoryFragment(), "Category",false);
          //   startActivity(new Intent(this,CustomDialogClass.class));
            new CustomDialogClass(this).show();
        } else if (id == R.id.nav_bill) {
           // loadFragment(new BillFragment(), "Bill", false);
           loadFragment(new ProductFragment(), "Product", false);
        } else if (id == R.id.nav_feedback) {
            new FeedbackDialog(this).show();
        } else if (id == R.id.nav_logout) {
            //startActivity(new Intent(this, LoginActivity.class));
            startActivity(new Intent(this, recycler_scroll_click.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadFragment(Fragment fragment, String tag, boolean addToBackStack) {

        if (addToBackStack)
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .replace(R.id.flHomeContainer, fragment, tag)
                    .commit();
        else
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flHomeContainer, fragment, tag)
                    .commit();
    }


}
