package com.xzxx.decorate.o2o.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.view.VerticalStepView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2018/7/4.
 * 订单详情之订单进度
 */
public class OrderProgressFragment extends BaseFragment {

    private View mView;
    private VerticalStepView verticalStepView;

    @Override
    protected void loadData() {
        verticalStepView = mView.findViewById(R.id.id_order_stepview);
        List<String> list = new ArrayList<>();
        list.add("师傅已接单");
        list.add("师傅上门中");
        list.add("订单待付款");
        list.add("订单已完成");
        list.add("订单待评价");

        List<String> list_time = new ArrayList<>();
        list_time.add("4月27日 15:35");
        list_time.add("4月28日 10:22");
        list_time.add("4月28日 12:22");

        verticalStepView.setStepsViewIndicatorComplectingPosition(2)//设置完成的步数
                .reverseDraw(false)
                .setStepViewTexts(list)
                .setStepViewTimeTexts(list_time)
                .setTextSize(15)
                .setLinePaddingProportion(1)//设置indicator线与线间距的比例系数
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(getActivity(), R.color.lightblack)
                )//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(getActivity(), R.color.lightblack))//设置StepsViewIndicator未完成线的颜色
                //.setStepViewComplectedTextColor(ContextCompat.getColor(getActivity(), R.color.orange))
                //设置StepsView text完成线的颜色
                //.setStepViewUnComplectedTextColor(ContextCompat.getColor(getActivity(), R.color.black))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(getActivity(), R.drawable.default_icon))
                //设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(getActivity(), R.drawable.default_icon))
                //设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(getActivity(), R.drawable.attention));
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        mView = mView.inflate(getActivity(), R.layout.fragment_vertical_stepview, null);
        return mView;
    }
}
