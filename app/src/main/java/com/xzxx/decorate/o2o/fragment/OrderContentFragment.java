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
import com.xzxx.decorate.o2o.consumer.R;

/**
 * Created by zf on 2018/7/3.
 * 订单详情之订单内容
 */
public class OrderContentFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout ll_more;
    private TextView text_more;
    private RelativeLayout rl_view;

    @Override
    protected void loadData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.layout_order_content, container, false);
        text_more = view.findViewById(R.id.id_order_content_move);
        ll_more = view.findViewById(R.id.ll_order_content_more);
        rl_view = view.findViewById(R.id.id_order_content_cost);
        text_more.setOnClickListener(this);
        rl_view.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_order_content_move:
                text_more.setVisibility(View.GONE);
                ll_more.setVisibility(View.VISIBLE);
                break;
            case R.id.id_order_content_cost:
                final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.show();
                alertDialog.setContentView(R.layout.dialog_order_cost_detail);
                Window window = alertDialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawableResource(android.R.color.white);
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.AlertDialog_AppCompat);
                final TextView closeText = window.findViewById(R.id.id_order_content_dialog_close);
                closeText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;
            default:
                break;
        }
    }
}
