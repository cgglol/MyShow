package com.cgg.administrator.myshow.Today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.TodayBack;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */

public class TodayListAdapter extends BaseAdapter {

    private List<TodayBack.ShowapiResBodyBean.ListBean> list;
    private Context context;

    public TodayListAdapter(List<TodayBack.ShowapiResBodyBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void Updata(List<TodayBack.ShowapiResBodyBean.ListBean> list) {
        this.list = list;
        this.notifyDataSetChanged();
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.today_item, null);
            viewHolder.Iv = (ImageView) convertView.findViewById(R.id.today_item_iv);
            viewHolder.Tv1 = (TextView) convertView.findViewById(R.id.today_item_tv1);
            viewHolder.Tv2 = (TextView) convertView.findViewById(R.id.today_item_tv2);
            viewHolder.Tv3 = (TextView) convertView.findViewById(R.id.today_item_tv3);
            viewHolder.Tv4 = (TextView) convertView.findViewById(R.id.today_item_tv4);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(null == list.get(position).getImg()){
            viewHolder.Iv.setBackgroundResource(R.mipmap.cat);
        }else{
            ImageLoader.getInstance().displayImage(list.get(position).getImg(),viewHolder.Iv);
        }

        viewHolder.Tv1.setText(list.get(position).getTitle());

        viewHolder.Tv2.setText(list.get(position).getYear() + "-" );

        viewHolder.Tv3.setText(list.get(position).getMonth() + "-" );

        viewHolder.Tv4.setText(list.get(position).getDay() + "");

        return convertView;
    }

    class ViewHolder {
        ImageView Iv;
        TextView Tv1,Tv2,Tv3,Tv4;
    }
}
