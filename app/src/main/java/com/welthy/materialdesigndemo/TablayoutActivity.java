/*
标签指示器布局。
本次仅展示TabLayout的效果，通常会搭配ViewPager使用，在构建好ViewPager后，只需通过tabLayout.setupWithViewPager(viewpager)绑定即可。
 */

package com.welthy.materialdesigndemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TablayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
    }
}
