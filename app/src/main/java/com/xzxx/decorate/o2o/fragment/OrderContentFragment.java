package com.xzxx.decorate.o2o.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/3.
 * 订单详情之订单内容
 */
public class OrderContentFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout ll_more;
    private TextView text_more;

    @Override
    protected void loadData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.layout_order_content, container, false);
        text_more = view.findViewById(R.id.id_order_content_move);
        ll_more = view.findViewById(R.id.ll_order_content_more);
        text_more.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_order_content_move:
                text_more.setVisibility(View.GONE);
                ll_more.setVisibility(View.VISIBLE);
                break;
        }
    }
}
