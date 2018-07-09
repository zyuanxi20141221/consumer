package com.xzxx.decorate.o2o.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xzxx.decorate.o2o.bean.Order;
import com.xzxx.decorate.o2o.consumer.R;
import java.util.List;

/**
 * Created by zf on 2018/7/2.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public static interface OnItemClickListener {
        void onItemClick(int position);
    }

    private List<Order> list;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public RecyclerAdapter(Context context, List<Order> data) {
        mContext = context;
        list = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_listview_allorder, parent, false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (list != null && list.size() > 0) {
            Order order = list.get(position);
            if (order != null) {
                holder.master_name_text.setText(order.getMaster_name());
//                Glide.with(mContext)
//                        .load(order.getMaster_photo())
//                        .into(holder.master_photo_image);
                holder.master_order_count_text.setText(order.getMaster_order_count() + "");
                holder.master_title_text.setText(order.getMaster_title());
                if (order.getOrder_state() == 1) {
                    holder.order_state_text.setText(mContext.getString(R.string.to_be_pay));
                    holder.ll_to_be_pay.setVisibility(View.VISIBLE);
                    holder.ll_to_bo_recomment.setVisibility(View.GONE);
                } else if (order.getOrder_state() == 2) {
                    holder.order_state_text.setText(mContext.getString(R.string.completed));
                    holder.ll_to_be_pay.setVisibility(View.GONE);
                    holder.ll_to_bo_recomment.setVisibility(View.VISIBLE);
                    holder.image_recomment_or_lookup.setImageDrawable(mContext.getResources().getDrawable(R.drawable.icon_comment));
                    holder.text_recomment_or_lookup.setText(R.string.just_comment);
                } else if (order.getOrder_state() == 3) {
                    holder.order_state_text.setText(mContext.getString(R.string.completed));
                    holder.ll_to_be_pay.setVisibility(View.GONE);
                    holder.ll_to_bo_recomment.setVisibility(View.VISIBLE);
                    holder.image_recomment_or_lookup.setImageDrawable(mContext.getResources().getDrawable(R.drawable.icon_check));
                    holder.text_recomment_or_lookup.setText(R.string.lookup_comment);
                }
                holder.order_name_text.setText(order.getOrder_name());
                holder.order_date_text.setText(order.getOrder_date());
                holder.order_address_text.setText(order.getOrder_address());
                holder.order_price_text.setText(order.getOrder_price() + "");

                holder.itemView.setTag(position);

                holder.itemView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onItemClick(position);
                    }
                });
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

        private LinearLayout ll_to_be_pay;
        private LinearLayout ll_to_bo_recomment;
        private ImageView image_recomment_or_lookup;
        private TextView text_recomment_or_lookup;

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

            ll_to_be_pay = itemView.findViewById(R.id.ll_all_order_just_pay);
            ll_to_bo_recomment = itemView.findViewById(R.id.ll_all_order_recomment);

            image_recomment_or_lookup = itemView.findViewById(R.id.image_recomment_or_lookup);
            text_recomment_or_lookup = itemView.findViewById(R.id.text_recomment_or_lookup);
        }
    }
}
