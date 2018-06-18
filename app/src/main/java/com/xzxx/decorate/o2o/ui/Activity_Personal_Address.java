package com.xzxx.decorate.o2o.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.xzxx.decorate.o2o.adapter.PersonalAddressAdapter;
import com.xzxx.decorate.o2o.bean.PersonalAddress;
import com.xzxx.decorate.o2o.consumer.R;
import java.util.ArrayList;
import java.util.List;

/**
 * 我的地址页面
 * Created by zf on 2018/6/17.
 */
public class Activity_Personal_Address extends AppCompatActivity {

    private ListView listView;
    private PersonalAddressAdapter addressAdapter;
    private List<PersonalAddress> personalAddressList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_personal_address);
        listView = findViewById(R.id.list_personal_address);
        initData();
        addressAdapter = new PersonalAddressAdapter(this, personalAddressList);
        listView.setAdapter(addressAdapter);
        addressAdapter.notifyDataSetChanged();
    }

    private void initData() {
        PersonalAddress address1 = new PersonalAddress();
        address1.setAddress("龙岗区五和路新天下工业城");
        address1.setContactName("王涛");
        address1.setPhoneNumber("15987809987");
        personalAddressList.add(address1);

        PersonalAddress address2 = new PersonalAddress();
        address2.setAddress("坂田百瑞达大厦B栋A1306");
        address2.setContactName("王涛");
        address2.setPhoneNumber("15987809987");
        personalAddressList.add(address2);

        PersonalAddress address3 = new PersonalAddress();
        address3.setAddress("南山科技大厦二期A座502");
        address3.setContactName("王涛");
        address3.setPhoneNumber("15987809987");
        personalAddressList.add(address3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
