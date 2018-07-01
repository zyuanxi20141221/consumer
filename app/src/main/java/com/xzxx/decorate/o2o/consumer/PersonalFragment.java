package com.xzxx.decorate.o2o.consumer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xzxx.decorate.o2o.ui.PersonalInfoActivity;
import com.xzxx.decorate.o2o.ui.SettingActivity;

public class PersonalFragment extends Fragment implements View.OnClickListener {

    private ImageView personal_address;
    private ImageView personal_setting;
    private ImageView perSonal_coupon;
    private TextView personal_txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, null);
        personal_address = view.findViewById(R.id.id_personal_address);
        personal_setting = view.findViewById(R.id.id_personal_setting);
        perSonal_coupon = view.findViewById(R.id.id_personal_coupon);
        personal_txt = view.findViewById(R.id.id_personal_info);
        initEvent();
        return view;
    }

    private void initEvent() {
        personal_address.setOnClickListener(this);
        personal_setting.setOnClickListener(this);
        perSonal_coupon.setOnClickListener(this);
        personal_txt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_personal_info:
                Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.id_personal_address:

                break;
            case R.id.id_personal_setting:
                Intent settintIntent = new Intent(getActivity(), SettingActivity.class);
                startActivity(settintIntent);
                break;
            case R.id.id_personal_coupon:

                break;
            default:
                break;
        }
    }
}
