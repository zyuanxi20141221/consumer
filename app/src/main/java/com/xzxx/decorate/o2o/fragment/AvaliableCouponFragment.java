package com.xzxx.decorate.o2o.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/12.
 * 可用优惠券
 */
public class AvaliableCouponFragment extends BaseFragment {

    @Override
    protected void loadData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.layout_avaliable_coupon, container, false);
        return view;
    }
}
