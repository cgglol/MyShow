package com.cgg.administrator.myshow.utils;

import com.cgg.administrator.myshow.PetalBenefit.RecyclerViewAdapter;

/**
 * Created by Administrator on 2016/11/18.
 */

public class PetalBenefitBack implements RecyclerViewAdapter.Item {

    /**
     * title : 【晒】长膘的季节
     * thumb : http://zzssa.b0.upaiyun.com/Uploads/2016-11-14/0060lm7Tgw1f9rg9lqntxj30dw0d0tac.jpg
     * url : http://www.hbmeinv.com/show-34-33834-1.html
     */

    private int TYPE = 2;
    private String title;
    private String thumb;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int getType() {
        return TYPE;
    }
}
