package com.xzxx.decorate.o2o.consumer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClassifyFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_classify, null);

        listView = (ListView) view.findViewById(R.id.id_listView_classify);
        adapter = new ArrayAdapter<>(getContext(), R.layout.item_listview_classify, R.id.id_item_text_listview_classify,  new String[] {"热门", "上门安装", "家电维修", "修锁换锁"});
        listView.setAdapter(adapter);
        return view;
    }
}
