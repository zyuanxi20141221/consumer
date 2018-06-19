package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * 师傅资料页面
 * Created by zf on 2018/6/19.
 */
public class MaterInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_master_information);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
