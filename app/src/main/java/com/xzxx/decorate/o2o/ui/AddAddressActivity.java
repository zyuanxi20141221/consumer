package com.xzxx.decorate.o2o.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * 添加地址页面
 * Created by zf on 2018/6/17.
 */
public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_add_address_save;
    private LinearLayout ll_personal_address_zone;
    private LinearLayout ll_personal_address_detail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_address);
        txt_add_address_save = findViewById(R.id.txt_add_address_save);
        ll_personal_address_zone = findViewById(R.id.ll_personal_address_zone);
        ll_personal_address_detail = findViewById(R.id.ll_personal_address_detail);
        txt_add_address_save.setOnClickListener(this);
        ll_personal_address_zone.setOnClickListener(this);
        ll_personal_address_detail.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_add_address_save:
                Toast.makeText(getApplicationContext(), "添加地址成功", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.ll_personal_address_zone:
                Intent selectCityIntent = new Intent(this,SelectCityAddressActivity.class);
                startActivity(selectCityIntent);
                break;
            case R.id.ll_personal_address_detail:

                break;
        }
    }
}
