package com.xzxx.decorate.o2o.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/6/25.
 * 设置页面
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private View viewContactService;
    private LinearLayout ll_change_mobile;
    private RelativeLayout ll_change_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setting);
        initView();
        initEvent();
    }

    void initView() {
        ll_change_mobile = findViewById(R.id.id_ll_setting_change_mobile);
        ll_change_password = findViewById(R.id.id_ll_setting_change_password);
        viewContactService = findViewById(R.id.id_setting_contact_service);

    }

    void initEvent() {
        ll_change_mobile.setOnClickListener(this);
        ll_change_password.setOnClickListener(this);
        viewContactService.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_ll_setting_change_mobile) {
            Intent changeMobile = new Intent(SettingActivity.this, ChangeMobieActivity.class);
            startActivity(changeMobile);
        } else if (v.getId() == R.id.id_ll_setting_change_password) {
            Intent changePassword = new Intent(SettingActivity.this, ForgetPasswordActivity.class);
            startActivity(changePassword);
        } else if (v.getId() == R.id.id_setting_contact_service) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.show();
            alertDialog.setContentView(R.layout.dialog_call);
            Window window = alertDialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawableResource(android.R.color.white);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.AlertDialog_AppCompat);
        }
    }
}
