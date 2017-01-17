package com.cgg.administrator.myshow.PetalBenefit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.PetalBenefitBack;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */

public class PetalFraGVAdapter extends StaggeredGridLayoutAdapter<PetalBenefitBack> implements View.OnClickListener{

    private PetalFraGVAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public PetalFraGVAdapter(List<PetalBenefitBack> list, int headerViewRes) {
        super(list, headerViewRes);
    }

    public PetalFraGVAdapter(List<PetalBenefitBack> list) {
        super(list);
    }

    public PetalFraGVAdapter(List<PetalBenefitBack> list, int headerViewRes, int footerViewRes) {
        super(list, headerViewRes, footerViewRes);
    }

    public void Updata(List<PetalBenefitBack> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    //创建新View，被LayoutManager所调用
   @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dmbz_gv_item,parent,false);
        view.setOnClickListener(this);
        return new ItemViewHolder(view);
    }

    @Override
    protected void onBindHeaderView(View headerView) {
        Log.e("TAG","这是HeadView数据绑定的过程");
//        ImageView imageView= (ImageView) headerView.findViewById(R.id.icon);
//        Picasso.with(headerView.getContext()).load("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg").into(imageView);

    }

    @Override
    protected void onBindFooterView(View footerView) {
        Log.e("TAG","这是FootView数据绑定的过程");
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder holder, PetalBenefitBack item) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        ImageLoader.getInstance().displayImage(item.getThumb(),itemViewHolder.iv_Item);
        itemViewHolder.tv_Item.setText(item.getTitle());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position+"");
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
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


    static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_Item;
        public TextView tv_Item;
        public ItemViewHolder(View itemView) {
            super(itemView);
            iv_Item = (ImageView)itemView.findViewById(R.id.iv_dmbz_gridview_item);
            tv_Item = (TextView)itemView.findViewById(R.id.tv_dmbz_gridview_item);
        }
    }
}
