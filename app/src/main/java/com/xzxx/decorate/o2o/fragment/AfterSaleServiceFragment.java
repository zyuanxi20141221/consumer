package com.xzxx.decorate.o2o.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xzxx.decorate.o2o.adapter.RecyclerAdapter;
import com.xzxx.decorate.o2o.bean.Order;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.ui.OrderDetailActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * 售后服务订单页面
 */
public class AfterSaleServiceFragment extends BaseFragment {

    private List<Order> listOrder = new ArrayList<>();

    @Override
    protected void loadData() {
        Order order = new Order();
        order.setMaster_name("王师傅");
        order.setMaster_order_count(600);
        order.setMaster_start((float) 4.9);
        order.setOrder_address("广东省深圳市龙岗区");
        order.setMaster_title("电视维修");
        order.setOrder_name("洗衣机维修");
        order.setOrder_date("2018年5月19日");
        order.setOrder_price(300);
        order.setOrder_state(4);
        listOrder.add(order);

        Order order2 = new Order();
        order2.setMaster_name("王师傅");
        order2.setMaster_order_count(600);
        order2.setMaster_start((float) 4.9);
        order2.setOrder_address("广东省深圳市龙岗区");
        order2.setMaster_title("电视维修");
        order2.setOrder_name("洗衣机维修");
        order2.setOrder_date("2018年5月19日");
        order2.setOrder_price(300);
        order2.setOrder_state(4);
        listOrder.add(order2);

        Order order3 = new Order();
        order3.setMaster_name("王师傅");
        order3.setMaster_order_count(600);
        order3.setMaster_start((float) 4.9);
        order3.setOrder_address("广东省深圳市龙岗区");
        order3.setMaster_title("电视维修");
        order3.setOrder_name("洗衣机维修");
        order3.setOrder_date("2018年5月19日");
        order3.setOrder_price(300);
        order3.setOrder_state(4);
        listOrder.add(order3);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.layout_fragment_all_order, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.id_recyclerView_all_order);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(getContext(), listOrder);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
