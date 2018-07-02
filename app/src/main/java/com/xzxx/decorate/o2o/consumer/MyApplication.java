package com.xzxx.decorate.o2o.consumer;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static MyApplication application;

    public static List<?> images=new ArrayList<>();
    public static int H,W;

    public static MyApplication getInstance() {
         return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        getScreen(this);
        String[] urls = getResources().getStringArray(R.array.url);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
    }

    public void getScreen(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        H=dm.heightPixels;
        W=dm.widthPixels;
    }
}
