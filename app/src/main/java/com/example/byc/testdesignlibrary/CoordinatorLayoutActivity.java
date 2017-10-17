package com.example.byc.testdesignlibrary;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolBar;
    private TabLayout tabLayout;
    private List<Fragment> mFramgents;
    private String[] mTitles = new String[]{
            "主页", "微博", "相册"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        initViews();
    }

    private void initViews() {
        //toolbar
        toolBar = (Toolbar) findViewById(R.id.main_toolbar);
        toolBar.setTitle("My Baby");
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setTitleTextAppearance(this, R.style.ToolBarTextSize);

        //viewpager
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mFramgents = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            FirstFragment fragment = new FirstFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index",i);
            fragment.setArguments(bundle);
            mFramgents.add(fragment);
        }
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFramgents, mTitles);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
