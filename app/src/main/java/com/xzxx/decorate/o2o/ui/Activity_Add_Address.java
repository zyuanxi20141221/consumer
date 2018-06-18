package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/6/17.
 */
public class Activity_Add_Address extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_address);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
