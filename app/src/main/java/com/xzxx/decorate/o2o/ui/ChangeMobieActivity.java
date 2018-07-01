package com.xzxx.decorate.o2o.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/1.
 * 更换手机号码页面
 */
public class ChangeMobieActivity extends AppCompatActivity implements View.OnClickListener {

    private IconButton iconButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chage_mobile);
        iconButton = findViewById(R.id.id_change_mobile_next);
        initEvent();
    }

    void initEvent() {
        iconButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_change_mobile_next) {
            Intent intent = new Intent(ChangeMobieActivity.this, NewMobileActivity.class);
            startActivity(intent);
        }
    }
}
