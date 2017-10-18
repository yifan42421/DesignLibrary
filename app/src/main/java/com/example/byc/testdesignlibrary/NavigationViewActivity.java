package com.example.byc.testdesignlibrary;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationViewActivity extends AppCompatActivity {

    private NavigationView nv;
    private TextView tv_main;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        initView();
    }

    private void initView() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        tv_main = (TextView) findViewById(R.id.main_tv);
        nv = (NavigationView) findViewById(R.id.navigation_view);
        nv.setItemIconTintList(null);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                tv_main.setText("您点击了 " + item.getTitle());
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
