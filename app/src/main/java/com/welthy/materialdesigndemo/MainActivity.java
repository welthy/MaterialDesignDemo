package com.welthy.materialdesigndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnToolbar;
    Button btnCardView;
    Button btnCoordinator;
    Button btnNavigationView;
    Button btnTablayout;
    Button btnTextInputLayout;
    Button btnSnackbar;
    Button btnFloatActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView(){
		Log.d("11", "22");
        btnToolbar = findViewById(R.id.btn_toolbar);
        btnCardView = findViewById(R.id.btn_cardview);
        btnCoordinator = findViewById(R.id.btn_coordinatorlayout);
        btnNavigationView = findViewById(R.id.btn_navigationview);
        btnTablayout = findViewById(R.id.btn_tablayout);
        btnTextInputLayout = findViewById(R.id.btn_textinputlayout);
        btnSnackbar = findViewById(R.id.btn_snackbar);
        btnFloatActionButton = findViewById(R.id.btn_floatingactionbutton);
    }

    private void initEvent(){
        btnToolbar.setOnClickListener(this);
        btnCardView.setOnClickListener(this);
        btnCoordinator.setOnClickListener(this);
        btnFloatActionButton.setOnClickListener(this);
        btnNavigationView.setOnClickListener(this);
        btnSnackbar.setOnClickListener(this);
        btnTablayout.setOnClickListener(this);
        btnTextInputLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_toolbar:
                Intent toolbarIt = new Intent(MainActivity.this,ToolBarActivity.class);
                startActivity(toolbarIt);
                break;
            case R.id.btn_cardview:
                Intent cardViewIt = new Intent(MainActivity.this,CardViewActivity.class);
                startActivity(cardViewIt);
                break;
            case R.id.btn_coordinatorlayout:
                Intent coordinatorIt = new Intent(MainActivity.this,CoordinatorActivity.class);
                startActivity(coordinatorIt);
                break;
            case R.id.btn_floatingactionbutton:
                Intent floatingactioIt = new Intent(MainActivity.this,FloatActionBtnActivity.class);
                startActivity(floatingactioIt);
                break;
            case R.id.btn_navigationview:
                Intent navigationIt = new Intent(MainActivity.this,NavigationViewActivity.class);
                startActivity(navigationIt);
                break;
            case R.id.btn_snackbar:
                Intent snackbarIt = new Intent(MainActivity.this,SnackBarActivity.class);
                startActivity(snackbarIt);
                break;
            case R.id.btn_tablayout:
                Intent tablayoutIt = new Intent(MainActivity.this,TablayoutActivity.class);
                startActivity(tablayoutIt);
                break;
            case R.id.btn_textinputlayout:
                Intent textinputIt = new Intent(MainActivity.this,TextInputLayoutActivity.class);
                startActivity(textinputIt);
                break;
        }
    }
}