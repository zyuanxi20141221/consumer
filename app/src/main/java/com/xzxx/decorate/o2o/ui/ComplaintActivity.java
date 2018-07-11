package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/11.
 * 我要投诉页面
 */
public class ComplaintActivity extends AppCompatActivity implements View.OnClickListener {

    private IconButton btn_complaint_complete;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_complaint);
        btn_complaint_complete = findViewById(R.id.btn_complaint_commit);
        initEvent();
    }

    private void initEvent() {
        btn_complaint_complete.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_complaint_commit:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.show();
                alertDialog.setContentView(R.layout.dialog_complaint_success);
                Window window = alertDialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawableResource(android.R.color.white);
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.AlertDialog_AppCompat);
                TextView backOrderText = alertDialog.findViewById(R.id.dialog_complaint_return_to_order);
                backOrderText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;
        }
    }
}
