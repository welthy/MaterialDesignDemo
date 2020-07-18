/*
NavigationView的使用
需配合DrawLayout作为滑出的界面。
注意点：
- NavigationView需放在最后
- NavigationView需设置属性  android:layout_gravity="left"
- NavigationView设置item的点击事件是通过setNavigationItemSelectedListener设置监听器。
- 通过navigationView.getHeaderView(0)获取头布局。
 */

package com.welthy.materialdesigndemo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class NavigationViewActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private View header;
    private TextView headerTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationview_layout);

        navigationView = findViewById(R.id.navigationview);
        header = navigationView.getHeaderView(0);

        navigationView.setItemIconTintList(null);
        headerTv = header.findViewById(R.id.header_tv);
        headerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationViewActivity.this,"User点击",Toast.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigationview01:
                        Toast.makeText(NavigationViewActivity.this,"navigationview01 点击",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigationview02:
                        Toast.makeText(NavigationViewActivity.this,"navigationview02 点击",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigationview03:
                        Toast.makeText(NavigationViewActivity.this,"navigationview03 点击",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}
