package com.xzxx.decorate.o2o.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.xzxx.decorate.o2o.consumer.R;

/**
 * 选择服务城市并显示定位地点页面
 * Created by zf on 2018/6/17.
 */
public class SelectCityAddressActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_select_city_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_city_show_address);
        ll_select_city_add = findViewById(R.id.ll_select_city_add);
        ll_select_city_add.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_select_city_add:
                Intent addCityIntent = new Intent(this, SelectCityActivity.class);
                startActivity(addCityIntent);
                break;
        }
    }
}
