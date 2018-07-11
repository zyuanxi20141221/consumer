package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/11.
 * 申请售后服务页面
 */
public class ApplyAfterServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout ll_apply_reason;
    private IconButton btn_apply_after_service_commit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_apply_after_service);
        btn_apply_after_service_commit = findViewById(R.id.btn_apply_after_service_commit);
        ll_apply_reason = findViewById(R.id.ll_apply_reason);
        initEvent();
    }

    private void initEvent() {
        btn_apply_after_service_commit.setOnClickListener(this);
        ll_apply_reason.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_apply_after_service_commit:
                final AlertDialog alertDialogApply = new AlertDialog.Builder(this).create();
                alertDialogApply.show();
                alertDialogApply.setContentView(R.layout.dialog_apply_success);
                Window windowApply = alertDialogApply.getWindow();
                windowApply.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                windowApply.setBackgroundDrawableResource(android.R.color.white);
                windowApply.setGravity(Gravity.BOTTOM);
                windowApply.setWindowAnimations(R.style.AlertDialog_AppCompat);

                TextView backOrder = alertDialogApply.findViewById(R.id.txt_after_service_back_to_order);
                backOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialogApply.dismiss();
                    }
                });
                break;
            case R.id.ll_apply_reason:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.show();
                alertDialog.setContentView(R.layout.dialog_apply_reason);
                Window window = alertDialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawableResource(android.R.color.white);
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.AlertDialog_AppCompat);

                IconButton iconButton = alertDialog.findViewById(R.id.btn_apply_reason_close);
                iconButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;
        }
    }
}
