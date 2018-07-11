package com.xzxx.decorate.o2o.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.phillipcalvin.iconbutton.IconButton;
import com.xzxx.decorate.o2o.consumer.R;
import com.xzxx.decorate.o2o.ui.ReleaseOrderActivity;

/**
 * Created by zf on 2018/7/12.
 */
public class CommonDialog {

    public static void cancelOrderDialog(final Context context) {
        final AlertDialog cancelOrderDialog = new AlertDialog.Builder(context).create();
        cancelOrderDialog.show();
        cancelOrderDialog.setContentView(R.layout.dialog_cacel_order);
        Window cancelOrderWindow = cancelOrderDialog.getWindow();
        cancelOrderWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams
                .WRAP_CONTENT);
        cancelOrderWindow.setBackgroundDrawableResource(android.R.color.white);
        cancelOrderWindow.setGravity(Gravity.BOTTOM);
        cancelOrderWindow.setWindowAnimations(R.style.AlertDialog_AppCompat);
        TextView cancel = cancelOrderDialog.findViewById(R.id.id_cancel_order_no);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelOrderDialog.dismiss();
            }
        });
        TextView sure = cancelOrderDialog.findViewById(R.id.id_cancel_order_sure);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelOrderDialog.dismiss();
                final AlertDialog cancelOrderReasonDialog = new AlertDialog.Builder(context).create();
                cancelOrderReasonDialog.show();
                cancelOrderReasonDialog.setContentView(R.layout.dialog_cancel_order_reason);
                Window cancelOrderReasonWindow = cancelOrderReasonDialog.getWindow();
                cancelOrderReasonWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager
                        .LayoutParams.WRAP_CONTENT);
                cancelOrderReasonWindow.setBackgroundDrawableResource(android.R.color.white);
                cancelOrderReasonWindow.setGravity(Gravity.BOTTOM);
                cancelOrderReasonWindow.setWindowAnimations(R.style.AlertDialog_AppCompat);

                IconButton commit = cancelOrderReasonDialog.findViewById(R.id.btn_cancel_order_commit);
                commit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cancelOrderReasonDialog.dismiss();
                        Toast.makeText(context, "订单取消成功", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        TextView republish = cancelOrderDialog.findViewById(R.id.id_cancel_order_republish);
        republish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelOrderDialog.dismiss();
                Intent intent = new Intent(context, ReleaseOrderActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public static void costDialog(Context context) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_order_cost_detail);
        Window window = alertDialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawableResource(android.R.color.white);
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.AlertDialog_AppCompat);
        final TextView closeText = window.findViewById(R.id.id_order_content_dialog_close);
        closeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
