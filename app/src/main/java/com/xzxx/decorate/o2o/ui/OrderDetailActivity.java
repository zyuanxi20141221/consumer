package com.xzxx.decorate.o2o.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.fragment.BaseFragment;
import com.xzxx.decorate.o2o.fragment.FragmentFactory;

/**
 * Created by zf on 2018/7/3.
 * 订单详情页面
 */
public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout = null;
    private ViewPager mViewPager;
    private OrderDetailActivity.PageAdatper pageAdatper;
    private ImageView order_back_button;
    private TextView order_menu;
    private int[] mTabTitles = new int[]{R.string.order_content, R.string.order_progress};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_order_detail);
        mTabLayout = findViewById(R.id.order_detail_tab_layout);
        mViewPager = findViewById(R.id.order_detail_tab_viewpager);
        order_back_button = findViewById(R.id.order_back_button);
        order_menu = findViewById(R.id.order_menu);
        pageAdatper = new OrderDetailActivity.PageAdatper(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(pageAdatper);
        mTabLayout.setupWithViewPager(mViewPager);

        order_back_button.setOnClickListener(this);
        order_menu.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_back_button:
                finish();
                break;
            case R.id.order_menu:
                View contentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                        .layout_order_popwindow, null, false);
                PopupWindow window = new PopupWindow(contentView, 400, 500, true);
                window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                window.setOutsideTouchable(true);
                window.setTouchable(true);
                window.showAsDropDown(order_menu, 0, 5);

                LinearLayout ll_order_pop_window_apply = contentView.findViewById(R.id.ll_order_pop_window_apply);
                LinearLayout ll_order_pop_window_complain = contentView.findViewById(R.id.ll_order_pop_window_complain);
                LinearLayout ll_order_pop_window_delete = contentView.findViewById(R.id.ll_order_pop_window_delete);

                ll_order_pop_window_apply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent applyIntent = new Intent(OrderDetailActivity.this, ApplyAfterServiceActivity.class);
                        startActivity(applyIntent);
                    }
                });
                ll_order_pop_window_complain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent complainIntent = new Intent(OrderDetailActivity.this, ComplaintActivity.class);
                        startActivity(complainIntent);
                    }
                });
                ll_order_pop_window_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
        }
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
