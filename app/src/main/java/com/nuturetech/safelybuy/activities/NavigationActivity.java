package com.nuturetech.safelybuy.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.nuturetech.safelybuy.R;
import com.nuturetech.safelybuy.fragment.DashboardFragment;
import com.nuturetech.safelybuy.interfaces.OnFragmentInteractionListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {
    Unbinder unbinder;
    @BindView(R.id.dashboard_layout) DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

        unbinder = ButterKnife.bind(this);

        DashboardFragment dashboardFragment = new DashboardFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, dashboardFragment);
        ft.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        drawerLayout.setDrawerElevation(20);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

       toggle.setHomeAsUpIndicator(R.drawable.nav_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void clickedOn(@NonNull final Fragment fragment) {
        final String tag = fragment.getClass().toString();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //Handle navigation view item clicks here
        int id = menuItem.getItemId();

        if (id == R.id.nav_home){
            clickedOn(new DashboardFragment());
        }
        if (id == R.id.nav_products){
            //startActivity(new Intent(this, MainActivity.class));
            //finish();
        }
        if (id == R.id.nav_services){
            //startActivity(new Intent(this, MainActivity.class));
            //finish();
        }
        if (id == R.id.nav_order){
            //startActivity(new Intent(this, MainActivity.class));
            //finish();
        }
        if (id == R.id.nav_profile){
            //startActivity(new Intent(this, MainActivity.class));
            //finish();
        }
        if (id == R.id.nav_settings){
            //startActivity(new Intent(this, MainActivity.class));
            //finish();
        }
        if (id == R.id.nav_logout){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        drawerLayout.setDrawerElevation(0);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_calculate:
                Toast.makeText(this, "Calculator pressed", Toast.LENGTH_LONG).show();
                return true;
            case R.id.nav_how_works:
                Toast.makeText(this, "How it works pressed", Toast.LENGTH_LONG).show();
                return true;
            case R.id.nav_search:
                Toast.makeText(this, "Search pressed", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
