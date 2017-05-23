package com.keluokeda.commonadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

import com.keluokeda.adapter.CommonAdapter;
import com.keluokeda.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.lv_content);
        List<User> users = new ArrayList<>(100);
        int max = 100;
        for (int i = 0; i < max; i++) {
            User user = new User(String.valueOf(i), UUID.randomUUID().toString());
            users.add(user);
        }

        CommonAdapter<User> commonAdapter = new CommonAdapter<User>(this, R.layout.item_user, users) {
            @Override
            protected void convert(ViewHolder viewHolder, User item, int position) {
                viewHolder.setText(R.id.tv_name, item.getName())
                        .setText(R.id.tv_sign, item.getSign());
            }
        };
        listView.setAdapter(commonAdapter);
    }
}
