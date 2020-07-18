/**
 * TextInputLayout是22.2.0新添加的控件， 要和EditText(或EditText的子类）结合使用，并且只能包含一个EditText(或EditText的子类）
 *
 * 若直接使用EditText时，在全屏情况下，hint会隐藏。若使用TextInputEditText时，则hint仍可以显示。
 *
 */

package com.welthy.materialdesigndemo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout tilUser,tilPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textinput_layout);

        tilUser = findViewById(R.id.til_user);
        tilPwd = findViewById(R.id.til_pwd);

        tilPwd.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() >= 15){
                    tilPwd.setErrorEnabled(true);
                    tilPwd.setError("密码不能超过15位");
                    tilPwd.getEditText().setFocusable(true);
                    tilPwd.getEditText().setFocusableInTouchMode(true);
                    tilPwd.getEditText().requestFocus();
                }else {
                    tilPwd.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
