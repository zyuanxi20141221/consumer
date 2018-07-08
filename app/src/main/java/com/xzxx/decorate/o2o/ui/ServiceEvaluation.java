package com.xzxx.decorate.o2o.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.view.FlowLayout;

import util.BasicUtils;

/**
 * Created by zf on 2018/7/7.
 * 服务评价页面
 */
public class ServiceEvaluation extends AppCompatActivity {

    private FlowLayout flowLayout;

    private String[] lables = new String[]{"态度良好", "效率很高", "技术专业", "着装整洁", "价格公道", "态度恶劣", "工作拖沓", "技术菜鸟", "漫天要价"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_service_evaluation);
        flowLayout = findViewById(R.id.id_service_eva_flow_layout);
        initData();
    }

    private void initData() {
        showFlowText(lables);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void showFlowText(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int ranHeight = BasicUtils.dip2px(this, 30);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ranHeight);
            lp.setMargins(BasicUtils.dip2px(this, 20), BasicUtils.dip2px(this, 2), BasicUtils.dip2px(this, 10), BasicUtils.dip2px(this, 10));
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
}
