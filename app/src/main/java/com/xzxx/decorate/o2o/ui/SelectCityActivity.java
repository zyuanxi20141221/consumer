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
 * 选择服务城市列表页面
 * Created by zf on 2018/6/16.
 */
public class SelectCityActivity extends AppCompatActivity {

    private String[] historycitys = new String[]{"深圳", "泉州"};

    private String[] opencitys = new String[]{"厦门", "北京", "上海", "深圳", "广州", "杭州", "长沙", "武汉"};

    private FlowLayout mFlowLayoutHistoryCity;

    private FlowLayout mFlowLayoutOpenCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_city);
        mFlowLayoutHistoryCity = (FlowLayout) findViewById(R.id.flow_layout_history_city);
        mFlowLayoutOpenCity = (FlowLayout) findViewById(R.id.flow_layout_open_city);
        initHistoryCitys();
        initOpenCitys();
    }


    public void initHistoryCitys() {
        for (int i = 0; i < historycitys.length; i++) {
            int ranHeight = BasicUtils.dip2px(this, 30);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ranHeight);
            lp.setMargins(BasicUtils.dip2px(this, 6), 0, BasicUtils.dip2px(this, 6), 0);
            TextView tv = new TextView(this);
            tv.setPadding(BasicUtils.dip2px(this, 15), 0, BasicUtils.dip2px(this, 15), 0);
            tv.setTextColor(Color.parseColor("#000000"));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setText(historycitys[i]);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setLines(1);
            mFlowLayoutHistoryCity.addView(tv, lp);
        }
    }

    public void initOpenCitys() {
        for (int i = 0; i < opencitys.length; i++) {
            int ranHeight = BasicUtils.dip2px(this, 30);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ranHeight);
            lp.setMargins(BasicUtils.dip2px(this, 6), 0, BasicUtils.dip2px(this, 6), 0);
            TextView tv = new TextView(this);
            tv.setPadding(BasicUtils.dip2px(this, 15), 0, BasicUtils.dip2px(this, 15), 0);
            tv.setTextColor(Color.parseColor("#000000"));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setText(opencitys[i]);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setLines(1);
            mFlowLayoutOpenCity.addView(tv, lp);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
