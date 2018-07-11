package com.xzxx.decorate.o2o.fragment;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.view.CommonDialog;

/**
 * Created by zf on 2018/7/3.
 * 订单详情之订单内容
 */
public class OrderContentFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout ll_more;
    private TextView text_more;
    private RelativeLayout rl_view;
    private LinearLayout ll_order_content_cancel;
    private LinearLayout ll_order_content_contact;

    @Override
    protected void loadData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.layout_order_content, container, false);
        text_more = view.findViewById(R.id.id_order_content_more);
        ll_more = view.findViewById(R.id.ll_order_content_more);
        rl_view = view.findViewById(R.id.id_order_content_cost);
        ll_order_content_cancel = view.findViewById(R.id.ll_order_content_cancel);
        ll_order_content_contact = view.findViewById(R.id.ll_order_content_contact);
        text_more.setOnClickListener(this);
        rl_view.setOnClickListener(this);
        ll_order_content_cancel.setOnClickListener(this);
        ll_order_content_contact.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_order_content_more:
                text_more.setVisibility(View.GONE);
                ll_more.setVisibility(View.VISIBLE);
                break;
            case R.id.id_order_content_cost:
                CommonDialog.costDialog(getActivity());
                break;
            case R.id.ll_order_content_cancel:
                CommonDialog.cancelOrderDialog(getActivity());
                break;
            case R.id.ll_order_content_contact:

                break;
            default:
                break;
        }
    }
}
