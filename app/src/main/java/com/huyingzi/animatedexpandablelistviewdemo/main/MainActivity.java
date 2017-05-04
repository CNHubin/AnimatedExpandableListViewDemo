package com.huyingzi.animatedexpandablelistviewdemo.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.huyingzi.animatedexpandablelistviewdemo.R;
import com.huyingzi.animatedexpandablelistviewdemo.view.AnimatedExpandableListView;

public class MainActivity extends Activity{

    private AnimatedExpandableListView mExpandableListView;
    private String[] mItemNameArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();  //初始化视图
        initData();  //初始化数据
        initAdapter();  //初始化适配器
        initListener();  //初始化监听器
    }


    private void initView() {
        mExpandableListView = (AnimatedExpandableListView) findViewById(R.id.activity_expandablelistview);
        //去除分割线
        mExpandableListView.setDivider(null);
    }

    private void initData() {
        //条目名字的string数组
        mItemNameArr = getResources().getStringArray(R.array.item_name);
    }

    private void initAdapter() {
        DemoAdapter adapter = new DemoAdapter(this,mItemNameArr);
        mExpandableListView.setAdapter(adapter);

        //设置所有条目全部展开
        for (int i = 0; i < mItemNameArr.length; i++) {
            mExpandableListView.expandGroup(i);
        }

    }


    private void initListener() {
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                //设置扩展动画
                if (mExpandableListView.isGroupExpanded(groupPosition)) {
                    mExpandableListView.collapseGroupWithAnimation(groupPosition);
                } else {
                    mExpandableListView.expandGroupWithAnimation(groupPosition);
                }

                return true;
            }
        });
    }

}
