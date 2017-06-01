package com.xinhua.customeview.view;

/**
 * @author : 李康利
 *         创建日期 :  2017/6/1.
 *         类的作用 :
 */

public class TabItem {

    private String tabText;
    private int tabIcon;
    private Class<? extends BaseFragment> tagFragmentClz;

    public TabItem(String tabText,int tabIcon,  Class<? extends BaseFragment> tagFragmentClz){
        this.tabIcon = tabIcon;
        this.tabText = tabText;
        this.tagFragmentClz = tagFragmentClz;
    }

    public String getTabText() {
        return tabText;
    }

    public void setTabText(String tabText) {
        this.tabText = tabText;
    }

    public int getTabIcon() {
        return tabIcon;
    }

    public void setTabIcon(int tabIcon) {
        this.tabIcon = tabIcon;
    }

    public Class<? extends BaseFragment> getTagFragmentClz() {
        return tagFragmentClz;
    }

    public void setTagFragmentClz(Class<? extends BaseFragment> tagFragmentClz) {
        this.tagFragmentClz = tagFragmentClz;
    }
}
