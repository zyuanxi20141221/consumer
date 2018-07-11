package com.xzxx.decorate.o2o.consumer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xzxx.decorate.o2o.bean.PersonalAddress;
import com.xzxx.decorate.o2o.ui.PersonalAddressActivity;
import com.xzxx.decorate.o2o.ui.PersonalCouponActivity;
import com.xzxx.decorate.o2o.ui.PersonalInfoActivity;
import com.xzxx.decorate.o2o.ui.SettingActivity;

public class PersonalFragment extends Fragment implements View.OnClickListener {

    private TextView personal_txt;
    private RelativeLayout ll_personal_address;
    private RelativeLayout ll_personal_setting;
    private RelativeLayout ll_personal_coupon;

    private TextView txt_personal_all_order;
    private LinearLayout ll_personal_wait_service;
    private LinearLayout ll_personal_wait_pay;
    private LinearLayout ll_personal_wait_evaluation;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, null);
        personal_txt = view.findViewById(R.id.id_personal_info);

        txt_personal_all_order = view.findViewById(R.id.txt_personal_all_order);
        ll_personal_wait_service = view.findViewById(R.id.ll_personal_wait_service);
        ll_personal_wait_pay = view.findViewById(R.id.ll_personal_wait_pay);
        ll_personal_wait_evaluation = view.findViewById(R.id.ll_personal_wait_evaluation);

        ll_personal_address = view.findViewById(R.id.ll_personal_address);
        ll_personal_setting = view.findViewById(R.id.ll_personal_setting);
        ll_personal_coupon = view.findViewById(R.id.ll_personal_coupon);
        initEvent();
        return view;
    }

    private void initEvent() {
        personal_txt.setOnClickListener(this);
        ll_personal_address.setOnClickListener(this);
        ll_personal_setting.setOnClickListener(this);
        ll_personal_coupon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_personal_all_order:

                break;
            case R.id.ll_personal_wait_service:

                break;
            case R.id.ll_personal_wait_pay:

                break;
            case R.id.ll_personal_wait_evaluation:

                break;
            case R.id.ll_personal_address:
                Intent addressIntent = new Intent(getActivity(), PersonalAddressActivity.class);
                startActivity(addressIntent);
                break;
            case R.id.ll_personal_setting:
                Intent settintIntent = new Intent(getActivity(), SettingActivity.class);
                startActivity(settintIntent);
                break;
            case R.id.ll_personal_coupon:
                Intent couponIntent = new Intent(getActivity(), PersonalCouponActivity.class);
                startActivity(couponIntent);
                break;
            case R.id.id_personal_info:
                Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
