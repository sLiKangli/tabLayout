# tabLayout
对多个tab对应多个页面的布局进行封装，方便开发

效果图

![image](https://github.com/sLiKangli/tabLayout/blob/master/image/effect.gif.gif)


这种布局再很多应用中非常常见，所有封装了一下，在以后的应用中可以直接使用

## 使用步骤：
### 拷贝
  - 类：TabItem,TabView,TabLayout
  - 布局文件：tab_layout.xml
  - 选择器文件：drawable/..  图片自行修改
  
### 使用
  1. 直接在布局文件中使用TabLayout
  ``` java
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.xinhua.customeview.MainActivity">


        <FrameLayout
            android:id="@+id/frame"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"/>

        <com.xinhua.customeview.view.TabLayout
            android:id="@+id/tabLayout"
            android:layout_width="match_parent"
            android:layout_height="50dp"
             />

</LinearLayout>

  
  ```
 2. 在Activity中往TabLayout添加Tab
  ```java
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
  ```
  
  
  
