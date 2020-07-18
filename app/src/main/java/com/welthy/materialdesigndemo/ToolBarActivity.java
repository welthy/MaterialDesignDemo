/**
 * TooBar效果展示。
 * 实现方式：
 * 1、导入design包
 * 2、新建继承自NoActionBar的主题，并应用与需要使用ToolBar的Activity
 * 3、在布局文件中新增ToolBar
 * 4、Activity需继承在AppCompatActivity，因为需调用setSupportActionBar(toolbar)设置toobar。
 *
 */

package com.welthy.materialdesigndemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.lang.reflect.Method;

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.toolbar_layout);

        toolbar = findViewById(R.id.toolbar);
        initToolbar();
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        //设置主标题
        toolbar.setTitle("ToolBar");
        //设置子标题
        toolbar.setSubtitle("ToolbarActivity");
        //设置主标题字体颜色
        toolbar.setTitleTextColor(Color.BLUE);
        //设置子标题字体颜色
        toolbar.setSubtitleTextColor(Color.GREEN);
        //设置最左端的导航键图标
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
        //设置左端导航键监听事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarActivity.this,"导航键点击",Toast.LENGTH_SHORT).show();
            }
        });
        //设置导航键和主标题之间的图标
        toolbar.setLogo(R.mipmap.ic_launcher);
        //设置Menu风格
        toolbar.setPopupTheme(R.style.PopToolbarMenuTheme);
    }

    //重写该方法，并加载menu菜单，否则menu不显示
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu01:
                Toast.makeText(ToolBarActivity.this,"Menu01 点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu02:
                Toast.makeText(ToolBarActivity.this,"Menu02 点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu03:
                Toast.makeText(ToolBarActivity.this,"Menu03 点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu04:
                Toast.makeText(ToolBarActivity.this,"Menu04 点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu05:
                Toast.makeText(ToolBarActivity.this,"Menu05 点击",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
