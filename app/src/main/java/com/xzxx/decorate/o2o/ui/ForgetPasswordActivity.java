package com.xzxx.decorate.o2o.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/1.
 * 忘记密码页面
 */
public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private IconButton iconButton;
    private ImageView forget_password_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forget_password);
        forget_password_back = findViewById(R.id.id_forget_password_back);
        iconButton = findViewById(R.id.id_forget_password_ok);
        initEvent();
    }

    private void initEvent() {
        forget_password_back.setOnClickListener(this);
        iconButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_forget_password_back) {
            finish();
        } else if (v.getId() == R.id.id_forget_password_ok) {
            Intent intent = new Intent(ForgetPasswordActivity.this, SettingLoginPasswodActivity.class);
            startActivity(intent);
        }
    }
}
