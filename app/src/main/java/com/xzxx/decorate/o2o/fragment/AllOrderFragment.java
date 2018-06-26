package com.xzxx.decorate.o2o.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;
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
        Order order = new Order();
        order.setMaster_name("aaa");
        order.setMaster_order_count(600);
        order.setMaster_start((float) 4.9);
        order.setOrder_address("广东省深圳市龙岗区");
        order.setMaster_title("电视维修");
        order.setOrder_price(300);
        order.setOrder_state(3);
        listOrder.add(order);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.layout_fragment_all_order, container, false);
        listView = view.findViewById(R.id.id_listView_all_order);
        adapter = new AllOrderAdapter(listOrder, getActivity());
        listView.setAdapter(adapter);
        return view;
    }
}