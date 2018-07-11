package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.fragment.BaseFragment;
import com.xzxx.decorate.o2o.fragment.FragmentFactory;
import java.lang.reflect.Field;
import util.BasicUtils;

/**
 * Created by zf on 2018/7/12.
 * 我的优惠券页面
 */
public class PersonalCouponActivity extends AppCompatActivity {

    private TabLayout mTabLayout = null;
    private ViewPager mViewPager;
    private PersonalCouponActivity.PageAdatper pageAdatper;
    private int[] mTabTitles = new int[]{R.string.avliable_coupon, R.string.unavliable_coupon, R.string.invalie_coupon};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_personal_coupon);

        mTabLayout = findViewById(R.id.tab_layout_coupon);
        mViewPager = findViewById(R.id.tab_viewpager_coupon);
        reflex(mTabLayout);
        pageAdatper = new PersonalCouponActivity.PageAdatper(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(pageAdatper);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void reflex(final TabLayout tabLayout) {
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
                    int dp = BasicUtils.dip2px(tabLayout.getContext(), 25);
                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);
                        TextView mTextView = (TextView) mTextViewField.get(tabView);
                        tabView.setPadding(0, 0, 0, 0);
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width;
                        params.leftMargin = dp;
                        params.rightMargin = dp;
                        tabView.setLayoutParams(params);
                        tabView.invalidate();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
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
            BaseFragment fragment = FragmentFactory.createCouponFragment(position);
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
