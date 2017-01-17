package com.cgg.administrator.myshow.Joke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.JokePicBack;
import com.cgg.administrator.myshow.utils.JokeTextBack;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class JokeFraListAdapter<T> extends BaseAdapter {

    private Context context;
    private List<JokeTextBack.ShowapiResBodyBean.ContentlistBean> listt;
    private List<JokePicBack.ShowapiResBodyBean.ContentlistBean> listp;
    private String url;

    public JokeFraListAdapter(Context context,List<T> list,String url){
        this.url = url;
        this.context = context;
        if(getList(url)){
            this.listt = (List<JokeTextBack.ShowapiResBodyBean.ContentlistBean>) list;
        }else {
            this.listp = (List<JokePicBack.ShowapiResBodyBean.ContentlistBean>) list;
        }

    }

    public void Updata(List<T> list) {
        if(getList(url)){
            this.listt = (List<JokeTextBack.ShowapiResBodyBean.ContentlistBean>) list;
        }else {
            this.listp = (List<JokePicBack.ShowapiResBodyBean.ContentlistBean>) list;
        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(getList(url)){
         return  listt .size();
        }else {
         return  listp.size();
        }
    }

    private Boolean getList(String str){
        if(str.endsWith("1")){
            return  true;
        }
            return  false;
    }

    @Override
    public Object getItem(int position) {
        if(getList(url)){
            return  listt.get(position);
        }else {
            return  listp.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder viewHolder;

        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            viewHolder = new ItemViewHolder();
            convertView = inflater.inflate(R.layout.joke_lv_item, null);
            viewHolder.iv_Item = (ImageView)convertView.findViewById(R.id.iv_joke_lv_item);
            viewHolder.tv_Item = (TextView)convertView.findViewById(R.id.tv_joke_lv_item);
            viewHolder.tv_body = (TextView)convertView.findViewById(R.id.tv_joke_lv_item_body);
            viewHolder.gif_Item = (ImageView)convertView.findViewById(R.id.iv_gif_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder) convertView.getTag();
        }

        if (url.endsWith("1")){
            //text
            viewHolder.iv_Item.setVisibility(View.GONE);
            viewHolder.gif_Item.setVisibility(View.GONE);
            viewHolder.tv_body.setVisibility(View.VISIBLE);
            viewHolder.tv_Item.setText(listt.get(position).getTitle());
            viewHolder.tv_body.setText(listt.get(position).getText());
        }else if(url.endsWith("2")){
            //pic
            viewHolder.tv_body.setVisibility(View.GONE);
            viewHolder.gif_Item.setVisibility(View.GONE);
            viewHolder.iv_Item.setVisibility(View.VISIBLE);
            ImageLoader.getInstance().displayImage(listp.get(position).getImg(),viewHolder.iv_Item);
            viewHolder.tv_Item.setText(listp.get(position).getTitle());
        }else {
            //gif
            viewHolder.iv_Item.setVisibility(View.GONE);
            viewHolder.tv_body.setVisibility(View.GONE);
            viewHolder.gif_Item.setVisibility(View.VISIBLE);
            viewHolder.tv_Item.setText(listp.get(position).getTitle());
            Glide.with(context).load(listp.get(position).getImg()).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(viewHolder.gif_Item);
        }

        return convertView;
    }

    static class ItemViewHolder {
         ImageView iv_Item,gif_Item;
         TextView tv_Item,tv_body;
//         MyGifView gif;
    }
}
