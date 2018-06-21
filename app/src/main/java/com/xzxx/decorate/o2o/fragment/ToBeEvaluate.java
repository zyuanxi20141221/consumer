package com.xzxx.decorate.o2o.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ToBeEvaluate extends BaseFragment {

    @Override
    protected void loadData() {

    }

    @Override
    protected View initView(LayoutInflater inflater) {
        TextView mView = new TextView(mContent);
        mView.setText("待评价");
        mView.setGravity(Gravity.CENTER);
        mView.setTextSize(18);
        mView.setTextColor(Color.BLACK);
        return mView;
    }
}
