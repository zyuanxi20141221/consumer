package com.xzxx.decorate.o2o.consumer;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    private FragmentTabHost fragmentTabHost;

    private int texts[] = {R.string.home, R.string.category, R.string.order, R.string.profile};
    private int imageButton[] = {R.drawable.selector_home, R.drawable.selector_classify, R.drawable.selector_order, R.drawable.selector_personal};
    private Class fragmentArray[] = {HomeFragment.class, ClassifyFragment.class, OrderFragment.class, PersonalFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fragmentTabHost = findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.home_container);
        fragmentTabHost.setOnTabChangedListener(this);
        for (int i = 0; i < texts.length; i++) {
            TabHost.TabSpec spec = fragmentTabHost.newTabSpec(getString(texts[i])).setIndicator(getView(i));
            fragmentTabHost.addTab(spec, fragmentArray[i], null);
//            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_bottom);
        }

        fragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        fragmentTabHost.setCurrentTab(0);
    }


    @Override
    public void onTabChanged(String tabId) {

    }

    private View getView(int i) {
        View view = View.inflate(this, R.layout.tabcontent, null);
        ImageView imageView = view.findViewById(R.id.tab_image);
        TextView textView = view.findViewById(R.id.tab_text);
        imageView.setImageResource(imageButton[i]);
        textView.setText(getString(texts[i]));
        return view;
    }
}
