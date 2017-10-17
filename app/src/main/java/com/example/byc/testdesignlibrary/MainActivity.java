package com.example.byc.testdesignlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_coordinatorlayout;
    private Button btn_navigationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btn_coordinatorlayout = (Button) findViewById(R.id.btn_coordinatorlayout);
        btn_navigationview = (Button) findViewById(R.id.btn_navigationview);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_coordinatorlayout:
                goActivity(CoordinatorLayoutActivity.class);
                break;
            case R.id.btn_navigationview:
                goActivity(NavigationViewActivity.class);
                break;
            default:
                break;
        }
    }

    private void goActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
}
