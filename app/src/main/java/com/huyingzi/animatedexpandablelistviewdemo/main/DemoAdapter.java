package com.huyingzi.animatedexpandablelistviewdemo.main;

/*
 *  @项目名：  AnimatedExpandableListViewDemo 
 *  @包名：    com.huyingzi.animatedexpandablelistviewdemo
 *  @文件名:   DemoAdapter
 *  @创建者:   胡英姿
 *  @创建时间:  2017/5/4 0004 10:18
 *  @描述：    TODO
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huyingzi.animatedexpandablelistviewdemo.R;
import com.huyingzi.animatedexpandablelistviewdemo.view.AnimatedExpandableListView;

class DemoAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private Context mContext;
    private String[] mItemNameArr;

    public DemoAdapter(Context context, String[] itemNameArr) {
        mContext = context;
        this.mItemNameArr = itemNameArr;
    }

    @Override
    public int getGroupCount() {
        return mItemNameArr == null ? 0 : mItemNameArr.length;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return 1;
    }


    @Override
    public String getGroup(int groupPosition) {
        return mItemNameArr == null ? null : mItemNameArr[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }




    private final int TYPE_1 = 0;
    private final int TYPE_2 = 1;
    private final int TYPE_3 = 2;
    private final int TYPE_4 = 3;
    private final int TYPE_5 = 4;

    @Override
    public int getRealChildTypeCount() {
        return mItemNameArr.length;
    }
    @Override
    public int getRealChildType(int groupPosition, int childPosition) {

            if (groupPosition == 0) {
                return TYPE_1;
            } else if (groupPosition == 1) {
                return TYPE_2;
            } else if (groupPosition == 2) {
                return TYPE_3;
            } else if (groupPosition == 3) {
                return TYPE_4;
            } else if (groupPosition == 4) {
                return TYPE_5;
            }

        return -1;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        if (convertView == null) {
            holder = new GroupViewHolder();
            convertView = View.inflate(mContext, R.layout.item_group, null);
            holder.name = (TextView) convertView.findViewById(R.id.item_group_name);

            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        holder.name.setText(getGroup(groupPosition));

        return convertView;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View
            convertView, ViewGroup parent) {

        int type = getRealChildType(groupPosition, childPosition);
        ViewHolder holder = null;
        if (convertView == null) {
            switch (type) {
                case TYPE_1:
                    holder = new ChildViewHolderItemOne();
                    convertView = View.inflate(mContext, R.layout.item_child_one, null);
                    break;
                case TYPE_2:
                    holder = new ChildViewHolderItemThree();
                    convertView = View.inflate(mContext, R.layout.item_child_two, null);
                    break;
                case TYPE_3:
                    holder = new ChildViewHolderItemThree();
                    convertView = View.inflate(mContext, R.layout.item_child_three, null);
                    break;
                case TYPE_4:
                    holder = new ChildViewHolderItemFour();
                    convertView = View.inflate(mContext, R.layout.item_child_four, null);
                    break;
                case TYPE_5:
                    holder = new ChildViewHolderItemFive();
                    convertView = View.inflate(mContext, R.layout.item_child_five, null);
                    break;

            }
            convertView.setTag(holder);

        } else {

            switch (type) {
                case TYPE_1:
                    holder = (ChildViewHolderItemOne) convertView.getTag();
                    break;
                case TYPE_2:
                    holder = (ChildViewHolderItemThree) convertView.getTag();
                    break;
                case TYPE_3:
                    holder = (ChildViewHolderItemThree) convertView.getTag();
                    break;
                case TYPE_4:
                    holder = (ChildViewHolderItemFour) convertView.getTag();
                    break;
                case TYPE_5:
                    holder = (ChildViewHolderItemFive) convertView.getTag();
                    break;

            }

        }

        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class GroupViewHolder {
        TextView name;
    }

    class ViewHolder {

    }

    class ChildViewHolderItemOne extends ViewHolder {
        //根据自己的实际情况添加控件
    }

    class ChildViewHolderItemTwo extends ViewHolder {
        //根据自己的实际情况添加控件
    }

    class ChildViewHolderItemThree extends ViewHolder {
        //根据自己的实际情况添加控件
    }

    class ChildViewHolderItemFour extends ViewHolder {
        //根据自己的实际情况添加控件
    }

    class ChildViewHolderItemFive extends ViewHolder {
        //根据自己的实际情况添加控件
    }


}
