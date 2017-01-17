package com.cgg.administrator.myshow.Modle;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgg.administrator.myshow.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class MDetailRVAdapter extends RecyclerView.Adapter<MDetailRVAdapter.MYViewHolder> implements View.OnClickListener{

    private Context context;
    private List<String> list;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    private int pos;

    public MDetailRVAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void Updata(List<String> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    //创建新View，被LayoutManager所调用
    @Override
    public MDetailRVAdapter.MYViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dmbz_gv_item,parent,false);
        MDetailRVAdapter.MYViewHolder viewHolder = new MDetailRVAdapter.MYViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(MYViewHolder holder, int position) {
        pos = position;
        DisplayImageOptions imgO = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .showImageOnLoading(R.mipmap.timeline_image_loading)
                .showImageForEmptyUri(R.mipmap.timeline_image_loading)
                .showImageOnFail(R.mipmap.timeline_image_failure)
                .build();
        ImageLoader.getInstance().displayImage(list.get(position),holder.iv_Item,imgO);
        holder.itemView.setTag(position+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MYViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_Item;
        public TextView tv_Item;

        public MYViewHolder(View itemView) {
            super(itemView);
            iv_Item = (ImageView)itemView.findViewById(R.id.iv_dmbz_gridview_item);
            tv_Item = (TextView)itemView.findViewById(R.id.tv_dmbz_gridview_item);
            tv_Item.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

}
