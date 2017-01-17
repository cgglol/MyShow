package com.cgg.administrator.myshow.BeautifulPic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.BeautifulpicBack;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class beautifulpicGVAdapter extends BaseAdapter {

    private Context context;
    private List<BeautifulpicBack.ShowapiResBodyBean.NewslistBean> list;
    private ViewHolder viewHolder;

    public beautifulpicGVAdapter(Context context, List<BeautifulpicBack.ShowapiResBodyBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    public void Updata(List<BeautifulpicBack.ShowapiResBodyBean.NewslistBean> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.dmbz_gv_item, null);
            viewHolder.iv_Item = (ImageView)convertView.findViewById(R.id.iv_dmbz_gridview_item);
            viewHolder.tv_Item = (TextView)convertView.findViewById(R.id.tv_dmbz_gridview_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(list.get(position).getPicUrl(),viewHolder.iv_Item);
        viewHolder.tv_Item.setText(list.get(position).getTitle());

        return convertView;
    }

    static class ViewHolder {
        ImageView iv_Item;
        TextView tv_Item;
    }
}
