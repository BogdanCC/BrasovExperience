package com.example.android.testingapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by bogda on 1/16/2018.
 */

public class MainAppActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        // Make the app full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set a Toolbar to replace the ActionBar.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Find our drawer view and setup the drawer toggle and drawer view */
        mDrawer = findViewById(R.id.drawer_layout);
        mDrawer.addDrawerListener(drawerToggle);
        nvDrawer = findViewById(R.id.nvView);
        drawerToggle = setupDrawerToggle();
        setupDrawerContent(nvDrawer);

        /**
         * 1. Find the view pager that will allow the user to swipe between fragments
         * 2. Create an adapter that knows which fragment should be shown on each page
         * 3. Set the adapter onto the view pager
         * */
        viewPager = findViewById(R.id.viewpager);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        /**
         * Connect the tab layout with the view pager. This will
         *   1. Update the tab layout when the view pager is swiped
         *   2. Update the view pager when a tab is selected
         *   3. Set the tab layout's tab names with the view pager's adapter's titles
         *      by calling onPageTitle() */
        // Find the tab layout that shows the tabs
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.bringToFront();
        tabLayout.getTabAt(0).setIcon(R.mipmap.mountain);
        tabLayout.getTabAt(1).setIcon(R.mipmap.castle);
        tabLayout.getTabAt(2).setIcon(R.mipmap.camera);
    }

    /**
     * `onPostCreate` called when activity start-up is complete after `onStart()`
     *   NOTE 1: Make sure to override the method with only a single `Bundle` argument
     *   Note 2: Make sure you implement the correct `onPostCreate(Bundle savedInstanceState)` method.
     *   There are 2 signatures and only `onPostCreate(Bundle state)` shows the hamburger icon.
     * */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.open,  R.string.close);
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.places:
                fragmentClass = PlacesFragment.class;
                showTabs();
                break;
            case R.id.reside:
                fragmentClass = ResideFragment.class;
                hideTabs();
                break;
            case R.id.food:
                fragmentClass = FoodFragment.class;
                hideTabs();
                break;
            case R.id.sub_1:
                fragmentClass = FameFragment.class;
                hideTabs();
                break;
            case R.id.sub_2:
                fragmentClass = FeedbackFragment.class;
                hideTabs();
                break;
            default:
                fragmentClass = PlacesFragment.class;
                showTabs();
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Methods to show and hide tabs depending on what fragment is being shown */
    public void hideTabs(){
        viewPager.setVisibility(View.GONE);
        tabLayout.setVisibility(View.GONE);
    }
    public void showTabs() {
        viewPager.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.VISIBLE);
    }

}
