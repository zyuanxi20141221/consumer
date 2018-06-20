package com.xzxx.decorate.o2o.consumer;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.xzxx.decorate.o2o.view.FlowLayout;
import java.util.HashMap;
import java.util.Map;

public class ClassifyFragment extends Fragment implements AdapterView.OnItemClickListener {

    private String[] data = new String[]{"热门服务", "上门安装", "家电维修", "开锁换锁", "管道疏通", "防水补漏"};
    private ListView listView;
    private MyAdapter adapter;
    private FlowLayout flowLayout;
    private Map<String, String[]> listMap = new HashMap<String, String[]>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_classify, null);

        listView = (ListView) view.findViewById(R.id.id_listView_classify);
        flowLayout = (FlowLayout) view.findViewById(R.id.id_flowLayout_classify);
        adapter = new MyAdapter(getContext(), R.layout.item_listview_classify, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        initData();
        return view;
    }

    private void initData() {
        for (int i = 0; i < data.length; i++) {
            listMap.put(data[i], new String[]{"五金卫浴", "电路灯具", "网购家具", "热水器", "空调安装", "墙纸", "木地板"});
        }
        showFlowText(listMap.get(data[0]));
        adapter.setSelectPosition(0);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.v("ClassifyFragment", "position " + position);
        flowLayout.removeAllViews();
        showFlowText(listMap.get(data[position]));
        adapter.setSelectPosition(position);
        adapter.notifyDataSetChanged();
    }

    public void showFlowText(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int ranHeight = dip2px(getContext(), 30);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ranHeight);
            lp.setMargins(dip2px(getContext(), 2), 0, dip2px(getContext(), 2), 0);
            TextView tv = new TextView(getContext());
            tv.setPadding(dip2px(getContext(), 12), 0, dip2px(getContext(), 12), 0);
            tv.setTextColor(Color.parseColor("#000000"));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            tv.setText(data[i]);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setLines(1);
            tv.setBackgroundResource(R.drawable.bg_flow_layout_tag);
            flowLayout.addView(tv, lp);
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private class MyAdapter extends ArrayAdapter<String> {

        private Context mContext;
        private int resourceId;
        private String[] array;
        private int selectedPosition;

        public MyAdapter(@NonNull Context context, int resource, String[] data) {
            super(context, resource);
            this.mContext = context;
            this.array = data;
            this.resourceId = resource;
        }

        public void setSelectPosition(int position) {
            this.selectedPosition = position;
        }

        @Override
        public int getCount() {
            return array.length;
        }

        @Nullable
        @Override
        public String getItem(int position) {
            return array[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(resourceId, null);
                viewHolder.ll = convertView.findViewById(R.id.id_item_ll_listView_classify);
                viewHolder.view = convertView.findViewById(R.id.id_item_view_listview_classify);
                viewHolder.title = convertView.findViewById(R.id.id_item_text_listView_classify);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            String title = getItem(position);
            Log.v("ClassifyFragment", "title " + title);
            viewHolder.title.setText(title);
            if (selectedPosition == position) {
                viewHolder.ll.setBackgroundColor(Color.WHITE);
                viewHolder.view.setVisibility(View.VISIBLE);
            } else {
                viewHolder.ll.setBackgroundColor(Color.rgb(0xE8, 0xE8, 0XE8));
                viewHolder.view.setVisibility(View.GONE);
            }
            return convertView;
        }

        private class ViewHolder {
            private LinearLayout ll;
            private View view;
            private TextView title;
        }
    }
}
