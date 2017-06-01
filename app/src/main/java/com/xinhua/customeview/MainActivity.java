package com.xinhua.customeview;

import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xinhua.customeview.view.BaseFragment;
import com.xinhua.customeview.view.ContactFragent;
import com.xinhua.customeview.view.MainFragent;
import com.xinhua.customeview.view.SettingFragent;
import com.xinhua.customeview.view.TabItem;
import com.xinhua.customeview.view.TabLayout;
import com.xinhua.customeview.view.TabView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<TabItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        items = new ArrayList<TabItem>();
        items.add(new TabItem("消息", R.drawable.message_states_selector, MainFragent.class));
        items.add(new TabItem("联系人", R.drawable.contact_states_selector, ContactFragent.class));
        items.add(new TabItem("设置", R.drawable.dynamic_states_selector, SettingFragent.class));

        tabLayout.initData(items, new TabLayout.OnClickTabListener() {
            @Override
            public void onClickTab(TabItem item) {
                try {
                    BaseFragment baseFragment = item.getTagFragmentClz().newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, baseFragment)
                    .commit();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
