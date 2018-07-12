package com.xzxx.decorate.o2o.consumer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import com.xzxx.decorate.o2o.loader.GlideImageLoader;
import com.xzxx.decorate.o2o.ui.ReleaseOrderActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, AdapterView
        .OnItemClickListener, OnBannerListener, View.OnClickListener {

    private Banner banner;
    private static final int REFRESH_COMPLETE = 0X1112;

    private LinearLayout ll_door_to_door_install;
    private LinearLayout ll_home_maintenance;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    String[] urls = getResources().getStringArray(R.array.url4);
                    List list = Arrays.asList(urls);
                    List arrayList = new ArrayList(list);
                    banner.update(arrayList);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        banner = view.findViewById(R.id.home_banner);
        banner.setImages(MyApplication.images)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
        banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        ll_door_to_door_install = view.findViewById(R.id.ll_door_to_door_install);
        ll_home_maintenance = view.findViewById(R.id.ll_home_maintenance);
        ll_door_to_door_install.setOnClickListener(this);
        ll_home_maintenance.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void OnBannerClick(int position) {

    }

    private void startPublishOroerIntent() {
        Intent publishOrderIntent = new Intent(getActivity(), ReleaseOrderActivity.class);
        startActivity(publishOrderIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_door_to_door_install:
                startPublishOroerIntent();
                break;
            case R.id.ll_home_maintenance:
                startPublishOroerIntent();
                break;
        }
    }
}
