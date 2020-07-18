/*
底部弹出的可交互式的弹框，和Toast差不多。
 */

package com.welthy.materialdesigndemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSnackShow,btnSnackAdd, btnSnackClickDismiss, btnSnackState, btnSnackTvChange;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbar_layout);

        initView();
        initEvent();
    }

    private void initView(){
        btnSnackShow = findViewById(R.id.snack_show);
        btnSnackAdd = findViewById(R.id.snack_add_btn);
        btnSnackClickDismiss = findViewById(R.id.snack_click_dismiss);
        btnSnackState = findViewById(R.id.snack_add_state_callback);
        btnSnackTvChange = findViewById(R.id.snack_change_tv_color);
    }

    private void initEvent(){
        btnSnackShow.setOnClickListener(this);
        btnSnackAdd.setOnClickListener(this);
        btnSnackClickDismiss.setOnClickListener(this);
        btnSnackState.setOnClickListener(this);
        btnSnackTvChange.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.snack_show:
                Snackbar.make(btnSnackShow, "第一次使用SnackBar", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.snack_add_btn:
                Snackbar.make(btnSnackAdd, "第一次使用SnackBar", Snackbar.LENGTH_SHORT).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarActivity.this,"确定点击",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.snack_click_dismiss:
                Snackbar.make(btnSnackClickDismiss, "第一次使用SnackBar", Snackbar.LENGTH_INDEFINITE).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                break;
            case R.id.snack_add_state_callback:
                Snackbar.make(btnSnackState, "第一次使用SnackBar", Snackbar.LENGTH_INDEFINITE).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).addCallback(new Snackbar.Callback() {
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        Toast.makeText(SnackBarActivity.this, "弹出了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(SnackBarActivity.this, "消失了", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.snack_change_tv_color:
                Snackbar snackbar = Snackbar.make(btnSnackTvChange, "第一次使用SnackBar", Snackbar.LENGTH_INDEFINITE).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                snackbar.setActionTextColor(Color.GREEN);

                //修改背景
                snackbar.getView().setBackgroundResource(R.color.colorPrimaryDark);
  /* snackbar 并没有提供修改提示文字颜色的方法。不过可以通过找到
      snackbar的布局design_layout_snackbar_include通过布局可以找到textview的id。
     再通过snackbar.getView().findViewById(R.id.snackbar_text);
   */
                TextView textView = (TextView) snackbar.getView().findViewById(R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                snackbar.show();
                break;
        }
    }
}
