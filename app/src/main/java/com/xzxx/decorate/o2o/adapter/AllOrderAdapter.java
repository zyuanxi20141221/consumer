package com.xzxx.decorate.o2o.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xzxx.decorate.o2o.bean.Order;
import com.xzxx.decorate.o2o.consumer.R;
import java.util.List;

/**
 * Created by zf on 2018/6/21.
 */
public class AllOrderAdapter extends BaseAdapter {

    private Context mContext;
    private List<Order> orders;
    private LayoutInflater mInflater;

    public AllOrderAdapter(List<Order> list, Context context) {
        this.orders = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
             viewHolder = new ViewHolder();
             convertView = mInflater.inflate(R.layout.item_listview_allorder, null);
             viewHolder.master_name_text = convertView.findViewById(R.id.id_master_name);
             viewHolder.master_photo_image = convertView.findViewById(R.id.id_master_photo);
             viewHolder.master_order_count_text = convertView.findViewById(R.id.id_master_order_count);
             viewHolder.master_title_text = convertView.findViewById(R.id.id_master_title);
             viewHolder.order_state_text = convertView.findViewById(R.id.order_state);
             viewHolder.order_name_text = convertView.findViewById(R.id.order_name);
             viewHolder.order_date_text = convertView.findViewById(R.id.order_date);
             viewHolder.order_address_text = convertView.findViewById(R.id.order_address);
             viewHolder.order_price_text = convertView.findViewById(R.id.order_price);
             convertView.setTag(viewHolder);
        } else {
             viewHolder = (ViewHolder) convertView.getTag();

        }

        return convertView;
    }

    private class ViewHolder {

        private TextView master_name_text;
        private ImageView master_photo_image;
        private TextView master_order_count_text;
        private TextView master_start_text;
        private TextView master_title_text;

        private TextView order_state_text;
        private TextView order_name_text;
        private TextView order_date_text;
        private TextView order_address_text;
        private TextView order_price_text;
    }
}
