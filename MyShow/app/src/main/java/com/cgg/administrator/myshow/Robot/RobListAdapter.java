package com.cgg.administrator.myshow.Robot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.RobotBack;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */

public class RobListAdapter extends BaseAdapter {

    private Context  context;
    private List<RobotBack.ShowapiResBodyBean> list;
    final int TYPE_1 = 0; //用户send
    final int TYPE_2 = 1;

    public RobListAdapter(Context  context ,List<RobotBack.ShowapiResBodyBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void Updata(List<RobotBack.ShowapiResBodyBean> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder1 holder1 = null;
        viewHolder2 holder2 = null;

        int type = getItemViewType(position);

        if (convertView == null ){

            switch (type){
                case TYPE_1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.robot_item_1,null);
                    holder1 = new viewHolder1();
                    holder1.textView1 = (TextView) convertView.findViewById(R.id.tv_rb1);
                    convertView.setTag(holder1);
                    break;
                case TYPE_2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.robot_item_2,null);
                    holder2 = new viewHolder2();
                    holder2.textView2 = (TextView) convertView.findViewById(R.id.tv_rb2);
                    convertView.setTag(holder2);
                    break;
            }
        }else{
            switch (type){
                case TYPE_1:
                    holder1 = (viewHolder1)convertView.getTag();
                    break;
                case TYPE_2:
                    holder2 = (viewHolder2)convertView.getTag();
                    break;
            }
        }

        //设置资源
        switch (type){
            case TYPE_1:
                holder1.textView1.setText(list.get(position).getText());
                break;
            case TYPE_2:
                holder2.textView2.setText(list.get(position).getText());
                break;
        }

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0){  //用户send
            return TYPE_1;
        }else{  //接口返回数据
            return TYPE_2;
        }
    }

    class viewHolder1{
        TextView textView1;
        }

    class viewHolder2{
        TextView textView2;
        }
}
