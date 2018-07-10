package com.xzxx.decorate.o2o.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xzxx.decorate.o2o.bean.Order;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.ui.MyEvaluationActivity;
import com.xzxx.decorate.o2o.ui.ServiceEvaluationActivity;

import java.util.List;

/**
 * Created by zf on 2018/7/2.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ll_all_order_just_pay:
                Toast.makeText(mContext, "just pay click", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_all_order_contact:
                Toast.makeText(mContext, "contact click", Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_order_just_comment:
                Intent evaluationIntent = new Intent(mContext, ServiceEvaluationActivity.class);
                mContext.startActivity(evaluationIntent);
                break;
            case R.id.ll_order_look_comment:
                Intent myEvaluationIntent = new Intent(mContext, MyEvaluationActivity.class);
                mContext.startActivity(myEvaluationIntent);
                break;
            case R.id.ll_order_cancel:
                final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
                alertDialog.show();
                alertDialog.setContentView(R.layout.dialog_cacel_order);
                Window window = alertDialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawableResource(android.R.color.white);
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.AlertDialog_AppCompat);
                TextView cancel = alertDialog.findViewById(R.id.id_cancel_order_no);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                TextView sure = alertDialog.findViewById(R.id.id_cancel_order_sure);
                sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                TextView republish = alertDialog.findViewById(R.id.id_cancel_order_republish);
                republish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case R.id.ll_order_start_chat:
                Toast.makeText(mContext, "start chat click", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private List<Order> list;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    private LinearLayout ll_all_order_just_pay; //立即支付
    private LinearLayout ll_all_order_contact;  //联系师傅
    private LinearLayout ll_order_just_comment; //立即评价
    private LinearLayout ll_order_look_comment; //查看评价
    private LinearLayout ll_order_cancel;       //取消订单
    private LinearLayout ll_order_start_chat;   //发起微聊

    public RecyclerAdapter(Context context, List<Order> data) {
        mContext = context;
        list = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_listview_allorder, parent, false);

        ll_all_order_just_pay = view.findViewById(R.id.ll_all_order_just_pay);
        ll_all_order_just_pay.setOnClickListener(this);

        ll_all_order_contact = view.findViewById(R.id.ll_all_order_contact);
        ll_all_order_contact.setOnClickListener(this);

        ll_order_just_comment = view.findViewById(R.id.ll_order_just_comment);
        ll_order_just_comment.setOnClickListener(this);

        ll_order_look_comment = view.findViewById(R.id.ll_order_look_comment);
        ll_order_look_comment.setOnClickListener(this);

        ll_order_cancel = view.findViewById(R.id.ll_order_cancel);
        ll_order_cancel.setOnClickListener(this);

        ll_order_start_chat = view.findViewById(R.id.ll_order_start_chat);
        ll_order_start_chat.setOnClickListener(this);

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
                if (order.getOrder_state() == 0) { //待服务
                    holder.order_state_text.setText(mContext.getString(R.string.to_be_service));
                    holder.ll_all_order_to_bo_service.setVisibility(View.VISIBLE);
                    holder.ll_to_be_pay.setVisibility(View.GONE);
                    holder.ll_all_order_complete.setVisibility(View.GONE);
                } else if (order.getOrder_state() == 1) { //服务中
                    holder.order_state_text.setText(mContext.getString(R.string.in_service));
                    holder.ll_all_order_to_bo_service.setVisibility(View.VISIBLE);
                    holder.ll_to_be_pay.setVisibility(View.GONE);
                    holder.ll_all_order_complete.setVisibility(View.GONE);
                } else if (order.getOrder_state() == 2) { //待支付
                    holder.order_state_text.setText(mContext.getString(R.string.to_be_pay));
                    holder.ll_to_be_pay.setVisibility(View.VISIBLE);
                    holder.ll_all_order_complete.setVisibility(View.GONE);
                    holder.ll_all_order_to_bo_service.setVisibility(View.GONE);
                } else if (order.getOrder_state() == 3) { //已完成 未评价
                    holder.order_state_text.setText(mContext.getString(R.string.completed));
                    holder.ll_to_be_pay.setVisibility(View.GONE);
                    holder.ll_all_order_complete.setVisibility(View.VISIBLE);
                    holder.ll_order_just_comment.setVisibility(View.VISIBLE);
                    holder.ll_order_look_comment.setVisibility(View.GONE);
                } else if (order.getOrder_state() == 4) {  //已完成 已评价
                    holder.order_state_text.setText(mContext.getString(R.string.completed));
                    holder.ll_to_be_pay.setVisibility(View.GONE);
                    holder.ll_all_order_complete.setVisibility(View.VISIBLE);

                    holder.ll_order_just_comment.setVisibility(View.GONE);
                    holder.ll_order_look_comment.setVisibility(View.VISIBLE);
                }
                holder.order_name_text.setText(order.getOrder_name());
                holder.order_date_text.setText(order.getOrder_date());
                holder.order_address_text.setText(order.getOrder_address());
                holder.order_price_text.setText(order.getOrder_price() + "");

                holder.itemView.setTag(position);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
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

        private LinearLayout ll_to_be_pay; //立即支付
        private LinearLayout ll_all_order_complete; //订单已完成，待评价
        private LinearLayout ll_order_just_comment;
        private LinearLayout ll_order_look_comment;
        private LinearLayout ll_all_order_to_bo_service;

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
            ll_all_order_complete = itemView.findViewById(R.id.ll_all_order_complete);

            ll_order_just_comment = itemView.findViewById(R.id.ll_order_just_comment);
            ll_order_look_comment = itemView.findViewById(R.id.ll_order_look_comment);

            ll_all_order_to_bo_service = itemView.findViewById(R.id.ll_all_order_to_bo_service);
        }
    }
}
