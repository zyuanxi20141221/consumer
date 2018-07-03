package com.xzxx.decorate.o2o.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xzxx.decorate.o2o.bean.Order;
import com.xzxx.decorate.o2o.consumer.R;

import java.util.List;

/**
 * Created by zf on 2018/7/2.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Order> list;
    private Context mContext;

    public RecyclerAdapter(Context context, List<Order> data) {
        mContext = context;
        list = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_listview_allorder, parent, false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list !=null && list.size() > 0) {
            Order order = list.get(position);
            if (order != null) {
                holder.master_name_text.setText(order.getMaster_name());
                Glide.with(mContext)
                        .load(order.getMaster_photo())
                        .into(holder.master_photo_image);
                holder.master_order_count_text.setText(order.getMaster_order_count() + "");
                holder.master_title_text.setText(order.getMaster_title());
                holder.order_state_text.setText(order.getOrder_state() + "");
                holder.order_name_text.setText(order.getOrder_name());
                holder.order_date_text.setText(order.getOrder_date());
                holder.order_address_text.setText(order.getOrder_address());
                holder.order_price_text.setText(order.getOrder_price() + "");
            }
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView master_name_text;
        private ImageView master_photo_image;
        private TextView master_order_count_text;
        private TextView master_star_text;
        private TextView master_title_text;
        private TextView order_state_text;
        private TextView order_name_text;
        private TextView order_date_text;
        private TextView order_address_text;
        private TextView order_price_text;

        public ViewHolder(View itemView) {
            super(itemView);
            master_name_text = itemView.findViewById(R.id.id_master_name);
            master_photo_image = itemView.findViewById(R.id.id_master_photo);
            master_order_count_text = itemView.findViewById(R.id.id_master_order_count);
            master_star_text = itemView.findViewById(R.id.id_master_star);
            master_title_text = itemView.findViewById(R.id.id_master_title);
            order_state_text = itemView.findViewById(R.id.order_state);
            order_name_text = itemView.findViewById(R.id.order_name);
            order_date_text = itemView.findViewById(R.id.order_date);
            order_address_text = itemView.findViewById(R.id.order_address);
            order_price_text = itemView.findViewById(R.id.order_price);
        }
    }
}
