package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/6/25.
 * 设置页面
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private View viewContactService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setting);
        initView();
        initEvent();
    }

    void initView() {
        viewContactService = findViewById(R.id.id_setting_contact_service);
    }

    void initEvent() {
        viewContactService.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_setting_contact_service) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.show();
            alertDialog.setContentView(R.layout.layout_dialog_call);
            Window window = alertDialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawableResource(android.R.color.white);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.AlertDialog_AppCompat);
        }
    }
}
