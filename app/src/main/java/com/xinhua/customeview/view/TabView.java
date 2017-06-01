package com.xinhua.customeview.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xinhua.customeview.R;

/**
 * @author : 李康利
 *         创建日期 :  2017/6/1.
 *         类的作用 :
 */

public class TabView extends LinearLayout{

    private ImageView mIv_tab_icon;
    private TextView mTv_tab_text;

    public TabView(Context context) {
        super(context);
        init(context);
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, this, true);
        mIv_tab_icon = (ImageView) view.findViewById(R.id.iv_tab_icon);
        mTv_tab_text = (TextView) view.findViewById(R.id.tv_tab_text);

    }

    public void initData(TabItem item){
        mIv_tab_icon.setImageResource(item.getTabIcon());
        mIv_tab_icon.setEnabled(false);
        mTv_tab_text.setText(item.getTabText());
    }

    public void setFocusable(boolean focusable){

        mIv_tab_icon.setEnabled(focusable);
        mTv_tab_text.setTextColor(focusable ? Color.rgb(65, 184, 235) : Color.GRAY);
    }

}
