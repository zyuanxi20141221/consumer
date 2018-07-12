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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/6/25.
 * 设置页面
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rl_setting_change_mobile;
    private RelativeLayout rl_setting_change_password;
    private RelativeLayout rl_setting_about_us;
    private RelativeLayout rl_setting_contact_service;
    private RelativeLayout rl_setting_clear_cache;
    private RelativeLayout rl_setting_service_leader;

    private ImageView setting_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setting);
        initView();
        initEvent();
    }

    void initView() {
        setting_back = findViewById(R.id.id_setting_back);
        rl_setting_change_mobile = findViewById(R.id.rl_setting_change_mobile);
        rl_setting_change_password = findViewById(R.id.rl_setting_change_password);
        rl_setting_about_us = findViewById(R.id.rl_setting_about_us);
        rl_setting_contact_service = findViewById(R.id.rl_setting_contact_service);
        rl_setting_clear_cache = findViewById(R.id.rl_setting_clear_cache);
        rl_setting_service_leader = findViewById(R.id.rl_setting_service_leader);
    }

    void initEvent() {
        setting_back.setOnClickListener(this);
        rl_setting_change_mobile.setOnClickListener(this);
        rl_setting_change_password.setOnClickListener(this);
        rl_setting_about_us.setOnClickListener(this);
        rl_setting_contact_service.setOnClickListener(this);
        rl_setting_clear_cache.setOnClickListener(this);
        rl_setting_service_leader.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_setting_back) {
            finish();
        } else if (v.getId() == R.id.rl_setting_change_mobile) {
            Intent changeMobile = new Intent(SettingActivity.this, ChangeMobieActivity.class);
            startActivity(changeMobile);
        } else if (v.getId() == R.id.rl_setting_change_password) {
            Intent changePassword = new Intent(SettingActivity.this, ForgetPasswordActivity.class);
            startActivity(changePassword);
        } else if (v.getId() == R.id.rl_setting_contact_service) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.show();
            alertDialog.setContentView(R.layout.dialog_call_service);
            Window window = alertDialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawableResource(android.R.color.white);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.AlertDialog_AppCompat);

            TextView dialog_call_service_cancel = alertDialog.findViewById(R.id.dialog_call_service_cancel);
            TextView dialog_call_service_ok = alertDialog.findViewById(R.id.dialog_call_service_ok);
            dialog_call_service_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            dialog_call_service_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "正在呼叫客服", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
