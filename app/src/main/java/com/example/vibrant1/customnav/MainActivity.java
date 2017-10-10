package com.example.vibrant1.customnav;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vibrant1.customnav.CustomDesigne.myDrawerLayout;
import com.example.vibrant1.customnav.utils.BadgeDrawerArrowDrawable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    public static int[] drawer_icons = {
            R.drawable.home,
            R.drawable.gallery,
            R.drawable.tv,
            R.drawable.video,
            R.drawable.download3,
            R.drawable.gear
    };
    public static int[] nos = {
            4,
            56,
            0,
            69,
            1,
            0
    };

    int lineAfter = 3;
    ArrayList<String> navigation_items;
    private DrawerListAdapter drawerListAdapter;
    private ListView lv_drawer;

    ActionBarDrawerToggle toggle;
    private BadgeDrawerArrowDrawable badgeDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        init();

        SetDrawer();
    }


    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);


        navigation_items = new ArrayList<>();

//adding menu items for naviations
        navigation_items.add("Home");
        navigation_items.add("Album");
        navigation_items.add("Tv");
        navigation_items.add("Video");
        navigation_items.add("Updates");
        navigation_items.add("Settings");

        lv_drawer = (ListView) findViewById(R.id.lv_drawer);


    }

    private void SetDrawer() {

        final boolean[] runningAnimation = {false};


        DrawerLayout drawer = (myDrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                toolbar.setVisibility(View.GONE);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                toolbar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                Log.i("inData", slideOffset + "        *********");


                if (slideOffset == 0.0f) {
                    drawerClosing();
                } else if (slideOffset > 0.10f && slideOffset < 0.50f) {
                    drawerOpening();
                }


                if (slideOffset == 0 || slideOffset == 1) {
                    runningAnimation[0] = false;
                }


            }
        };

        badgeDrawable = new BadgeDrawerArrowDrawable(getSupportActionBar().getThemedContext());
        badgeDrawable.setText("69");
        badgeDrawable.setBackgroundColor(Color.parseColor("#ffff8929"));

        toggle.setDrawerArrowDrawable(badgeDrawable);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawerListAdapter = new DrawerListAdapter(MainActivity.this, navigation_items, drawer_icons, lineAfter, nos);
        lv_drawer.setAdapter(drawerListAdapter);


        lv_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (navigation_items.get(position).equalsIgnoreCase("Home")) {


                } else if (navigation_items.get(position).equalsIgnoreCase("Album")) {


                } else if (navigation_items.get(position).equalsIgnoreCase("Tv")) {


                } else if (navigation_items.get(position).equalsIgnoreCase("Video")) {


                } else if (navigation_items.get(position).equalsIgnoreCase("Updates")) {


                } else if (navigation_items.get(position).equalsIgnoreCase("Settings")) {


                }

            }
        });

    }

    private void drawerClosing() {

        TranslateAnimation translateAnimation = new TranslateAnimation(toolbar.getX(), 1, toolbar.getY(), 0);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(1000);
        toolbar.startAnimation(translateAnimation);


        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                toolbar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void drawerOpening() {

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, -20);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(150);
        toolbar.startAnimation(translateAnimation);


        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                toolbar.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}