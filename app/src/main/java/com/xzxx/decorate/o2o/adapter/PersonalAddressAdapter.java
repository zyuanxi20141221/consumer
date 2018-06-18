package com.xzxx.decorate.o2o.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xzxx.decorate.o2o.bean.PersonalAddress;
import com.xzxx.decorate.o2o.consumer.R;
import java.util.List;

/**
 * Created by zf on 2018/6/17.
 */
public class PersonalAddressAdapter extends BaseAdapter {

    private List<PersonalAddress> mList;
    private LayoutInflater mInflater;

    public PersonalAddressAdapter(Context context, List<PersonalAddress> list) {
        this.mList = list;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_personal_address, null);

            viewHolder.ll = convertView.findViewById(R.id.id_ll_default_address);
            viewHolder.address = convertView.findViewById(R.id.item_personal_address_txt);
            viewHolder.contact =  convertView.findViewById(R.id.id_item_personal_contact_name);
            viewHolder.number = convertView.findViewById(R.id.id_item_personal_contact_number);
            viewHolder.image_edit = convertView.findViewById(R.id.id_item_personal_address_pen);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            PersonalAddress address = mList.get(position);
            viewHolder.address.setText(address.getAddress());
            viewHolder.contact.setText(address.getContactName());
            viewHolder.number.setText(address.getPhoneNumber());
            if(address.isDefaultAddress()){
                viewHolder.ll.setVisibility(View.VISIBLE);
            } else {
                viewHolder.ll.setVisibility(View.GONE);
            }
        }
        return convertView;
    }

    class ViewHolder {

        public LinearLayout ll;
        public TextView address;
        public TextView contact;
        public TextView number;
        public ImageView image_edit;
    }
}
