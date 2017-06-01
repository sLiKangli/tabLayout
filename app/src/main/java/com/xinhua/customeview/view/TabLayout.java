package com.xinhua.customeview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * @author : 李康利
 *         创建日期 :  2017/6/1.
 *         类的作用 :
 */

public class TabLayout extends LinearLayout implements View.OnClickListener{

    private Context context;
    private LayoutParams params;
    private ArrayList<TabItem> items;
    private ArrayList<TabView> tabs;
    private OnClickTabListener listener;


    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
        params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
    }

    public void initData(ArrayList<TabItem> items, OnClickTabListener listener){

        this.items = items;
        this.listener = listener;
        if(items == null || items.size() == 0){
            throw new IllegalArgumentException("Argument ArrayList<Item> is null or not data");
        }

        TabItem item = null;
        tabs = new ArrayList<TabView>();
        for(int i=0; i<items.size(); i++){
            item = items.get(i);
            TabView tabView = new TabView(this.context);
            tabView.setTag(item);
            tabView.initData(item);
            tabView.setOnClickListener(this);
            this.addView(tabView, params);
            tabs.add(tabView);
        }
        setCurrentTab(0);
    }

    private TabView preTab;
    @Override
    public void onClick(View v) {
        //为tab的选择器做的工作
        TabView tab = (TabView) v;
        tab.setFocusable(true);
        if(preTab!=null){
            preTab.setFocusable(false);
        }
        preTab = tab;

        if(listener != null){
            listener.onClickTab((TabItem) v.getTag());
        }
    }

    public void setCurrentTab(int position){
        if(items!=null && items.size() > position && listener != null){
            //为tab的选择器做的工作
            TabView tab = (TabView) tabs.get(position);
            tab.setFocusable(true);
            if(preTab!=null){
                preTab.setFocusable(false);
            }
            preTab = tab;

            listener.onClickTab(items.get(position));
        }else{
            throw new IllegalArgumentException("input position following or not has implements OnClickTabListener");
        }
    }

    public interface OnClickTabListener{
        void onClickTab(TabItem item);
    }


}
