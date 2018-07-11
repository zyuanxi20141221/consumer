package com.xzxx.decorate.o2o.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.view.FlowLayout;

import util.BasicUtils;

/**
 * 评价完成页面
 */
public class EvaluationCompleteActivity extends AppCompatActivity implements View.OnClickListener {

    private FlowLayout flowLayout;

    private String[] lables = new String[]{"态度良好", "效率很高", "技术专业"};

    private IconButton btn_evaluation_complete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_evaluation_complete);
        flowLayout = findViewById(R.id.id_evaluation_tags);
        btn_evaluation_complete = findViewById(R.id.btn_evaluation_complete);
        btn_evaluation_complete.setOnClickListener(this);
        initData();
    }

    private void initData() {
        showFlowText(lables);
    }

    public void showFlowText(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int ranHeight = BasicUtils.dip2px(this, 30);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ranHeight);
            lp.setMargins(BasicUtils.dip2px(this, 10), BasicUtils.dip2px(this, 2), BasicUtils.dip2px(this, 10),
                    BasicUtils.dip2px(this, 10));
            TextView tv = new TextView(this);
            tv.setPadding(BasicUtils.dip2px(this, 12), 0, BasicUtils.dip2px(this, 12), 0);
            tv.setTextColor(Color.parseColor("#000000"));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            tv.setText(data[i]);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setLines(1);
            tv.setBackgroundResource(R.drawable.bg_flow_layout_tag);
            flowLayout.addView(tv, lp);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_evaluation_complete:
                Toast.makeText(getApplicationContext(), "评价提交成功", Toast.LENGTH_LONG).show();
                finish();
                break;
        }
    }
}
