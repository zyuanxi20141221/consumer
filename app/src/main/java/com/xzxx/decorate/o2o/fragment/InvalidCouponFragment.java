package com.xzxx.decorate.o2o.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/12.
 * 失效优惠券
 */
public class InvalidCouponFragment extends BaseFragment {

    @Override
    protected void loadData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.layout_invalid_coupon, container, false);
        return view;
    }
}
