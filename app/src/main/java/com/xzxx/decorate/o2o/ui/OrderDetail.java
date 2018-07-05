package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.fragment.BaseFragment;
import com.xzxx.decorate.o2o.fragment.FragmentFactory;

/**
 * Created by zf on 2018/7/3.
 * 订单详情页面
 */
public class OrderDetail extends AppCompatActivity {

    private TabLayout mTabLayout = null;
    private ViewPager mViewPager;
    private OrderDetail.PageAdatper pageAdatper;
    private int[] mTabTitles = new int[]{R.string.order_content, R.string.order_progress};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_order_detail);
        mTabLayout = findViewById(R.id.order_detail_tab_layout);
        mViewPager = findViewById(R.id.order_detail_tab_viewpager);
        pageAdatper = new OrderDetail.PageAdatper(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(pageAdatper);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class PageAdatper extends FragmentPagerAdapter {

        public PageAdatper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createOrderFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return mTabTitles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getString(mTabTitles[position]);
        }
    }
}
