package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/6/25.
 * 个人资料页面
 */
public class PersonalInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_personal_info);
        imageBack = findViewById(R.id.id_personal_info_back);
        imageBack.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_personal_info_back:
                finish();
                break;
        }
    }
}
