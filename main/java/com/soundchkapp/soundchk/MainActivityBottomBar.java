package com.soundchkapp.soundchk;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.util.Log;
import android.graphics.PorterDuff;

//public class MainActivityBottomBar extends AppCompatActivity {
public class MainActivityBottomBar extends AppCompatActivity {

    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom_bar);

        final ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        boolean feed, cam, fave;
        feed = false;
        cam = false;
        fave = false;

        //mBottomNav.getMenu().getItem(0).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
        //mBottomNav.getMenu().getItem(1).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
        //mBottomNav.getMenu().getItem(2).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);

        mBottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                vpPager.setCurrentItem(0);
                                //mBottomNav.getMenu().getItem(0).getIcon().setColorFilter(getResources().getColor(R.color.colorWhiteBg), PorterDuff.Mode.SRC_IN);
                                //mBottomNav.getMenu().getItem(1).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
                                //mBottomNav.getMenu().getItem(2).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
                                return true;
                                //break;
                            case R.id.menu_camera:
                                vpPager.setCurrentItem(1);
                                //mBottomNav.getMenu().getItem(0).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
                                //mBottomNav.getMenu().getItem(1).getIcon().setColorFilter(getResources().getColor(R.color.colorWhiteBg), PorterDuff.Mode.SRC_IN);
                                //mBottomNav.getMenu().getItem(2).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
                                return true;
                                //break;
                            case R.id.menu_favorites:
                                vpPager.setCurrentItem(2);
                                //mBottomNav.getMenu().getItem(0).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
                                //mBottomNav.getMenu().getItem(1).getIcon().setColorFilter(getResources().getColor(R.color.color_home_dark), PorterDuff.Mode.SRC_IN);
                                //mBottomNav.getMenu().getItem(2).getIcon().setColorFilter(getResources().getColor(R.color.colorWhiteBg), PorterDuff.Mode.SRC_IN);
                                return true;
                                //break;
                        }
                        return false;
                    }
                });


        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                mBottomNav.getMenu().getItem(position).setChecked(true);


                mSelectedItem = mBottomNav.getMenu().getItem(position).getItemId();
                //mBottomNav.getMenu().getItem(position).getIcon().setColorFilter(getColor(R.color.colorWhiteBg), PorterDuff.Mode.SRC_IN);

                // uncheck the other items.
                for (int i = 0; i< mBottomNav.getMenu().size(); i++) {
                    MenuItem menuItem = mBottomNav.getMenu().getItem(i);
                    menuItem.setChecked(menuItem.getItemId() == mSelectedItem);
                }
                /**/
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
/*


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom_bar);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(1);
        }
        selectFragment(selectedItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        Log.d("TAG", "onresume???");
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else {
            super.onBackPressed();
        }
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;

        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.menu_home:
                FeedFragment feedfrag = new FeedFragment();
                frag = feedfrag;
                break;
            case R.id.menu_favorites:
                FaveFragment favefrag = new FaveFragment();
                frag = favefrag;
                break;
            case R.id.menu_camera:
                CameraFragment camfrag = new CameraFragment();
                frag = camfrag;
                break;
        }

        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i< mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());

        }

        updateToolbarText(item.getTitle());

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, frag, frag.getTag());
            ft.commit();
        }
    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
        }
    }

*/
    // EXTRA STUFF --------

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FeedFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return CameraFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return FaveFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }



}
