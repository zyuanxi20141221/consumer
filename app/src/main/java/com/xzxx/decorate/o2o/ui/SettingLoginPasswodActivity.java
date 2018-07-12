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
import android.widget.TextView;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;

import org.w3c.dom.Text;

/**
 * Created by zf on 2018/6/29.
 * 设置登陆密码页面
 */
public class SettingLoginPasswodActivity extends AppCompatActivity implements View.OnClickListener {

    private IconButton iconButton;
    private ImageView backImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setting_login_password);
        backImage = findViewById(R.id.id_setting_login_password_back);
        iconButton = findViewById(R.id.id_setting_login_password_ok);
        backImage.setOnClickListener(this);
        iconButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_setting_login_password_back) {
            finish();

        } else if (v.getId() == R.id.id_setting_login_password_ok) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.show();
            alertDialog.setContentView(R.layout.dialog_register_success);
            Window window = alertDialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawableResource(android.R.color.white);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.AlertDialog_AppCompat);
            final TextView loginText = window.findViewById(R.id.id_register_just_login);
            loginText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingLoginPasswodActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
