package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/6/27.
 * 登陆页面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pwdInput;
    private TextView verificationText;
    private TextView textLoginPwd;
    private View ll_login_select;
    private View ll_login_password;
    private View ll_login_verification;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        initView();
        initEvent();
    }

    private void initView() {
        pwdInput = (EditText) findViewById(R.id.id_pwd_input);
        verificationText = (TextView) findViewById(R.id.id_login_verification);
        textLoginPwd = (TextView) findViewById(R.id.id_login_password);
        ll_login_select = findViewById(R.id.id_ll_login_select);
        ll_login_password = findViewById(R.id.id_ll_login_password);
        ll_login_verification = findViewById(R.id.id_ll_login_verification);
    }

    private void initEvent() {
        verificationText.setOnClickListener(this);
        textLoginPwd.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_login_verification:
                ll_login_select.setVisibility(View.GONE);
                textLoginPwd.setVisibility(View.VISIBLE);
                ll_login_password.setVisibility(View.GONE);
                ll_login_verification.setVisibility(View.VISIBLE);
                break;
            case R.id.id_login_password:
                ll_login_select.setVisibility(View.VISIBLE);
                textLoginPwd.setVisibility(View.GONE);
                ll_login_password.setVisibility(View.VISIBLE);
                ll_login_verification.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }
}
