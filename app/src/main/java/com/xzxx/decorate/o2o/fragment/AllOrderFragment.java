package com.xzxx.decorate.o2o.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.xzxx.decorate.o2o.adapter.AllOrderAdapter;
import com.xzxx.decorate.o2o.bean.Order;
import com.xzxx.decorate.o2o.consumer.R;
import java.util.ArrayList;
import java.util.List;

public class AllOrderFragment extends BaseFragment {

    private ListView listView;
    private AllOrderAdapter adapter;
    private List<Order> listOrder = new ArrayList<>();

    @Override
    protected void loadData() {

    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.layout_fragment_all_order, null);
        listView = view.findViewById(R.id.id_listView_all_order);
        adapter = new AllOrderAdapter(listOrder, getContext());
        listView.setAdapter(adapter);
        return view;
    }
}
