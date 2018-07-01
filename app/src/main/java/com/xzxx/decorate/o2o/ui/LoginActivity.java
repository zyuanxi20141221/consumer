package com.xzxx.decorate.o2o.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.HomeFragment;
import com.xzxx.decorate.o2o.consumer.MainActivity;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/6/27.
 * 登陆页面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private IconButton iconButton;
    private EditText pwdInput;
    private TextView textTitle;
    private TextView verificationText;
    private TextView textLoginPwd;
    private TextView textRegister;
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
        textTitle = findViewById(R.id.id_login_title);
        pwdInput = findViewById(R.id.id_pwd_input);
        verificationText = findViewById(R.id.id_login_verification);
        textRegister = findViewById(R.id.id_login_register);
        textLoginPwd = findViewById(R.id.id_login_password);
        ll_login_select = findViewById(R.id.id_ll_login_select);
        ll_login_password = findViewById(R.id.id_ll_login_password);
        ll_login_verification = findViewById(R.id.id_ll_login_verification);
        iconButton = findViewById(R.id.id_login);
    }

    private void initEvent() {
        textRegister.setOnClickListener(this);
        verificationText.setOnClickListener(this);
        textLoginPwd.setOnClickListener(this);
        iconButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_login:
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainIntent);
                break;
            case R.id.id_login_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.id_login_verification:
                ll_login_select.setVisibility(View.GONE);
                textLoginPwd.setVisibility(View.VISIBLE);
                ll_login_password.setVisibility(View.GONE);
                ll_login_verification.setVisibility(View.VISIBLE);
                textTitle.setText(getString(R.string.verification_login));
                break;
            case R.id.id_login_password:
                ll_login_select.setVisibility(View.VISIBLE);
                textLoginPwd.setVisibility(View.GONE);
                ll_login_password.setVisibility(View.VISIBLE);
                ll_login_verification.setVisibility(View.GONE);
                textTitle.setText(getString(R.string.login));
                break;
            default:
                break;
        }
    }
}
