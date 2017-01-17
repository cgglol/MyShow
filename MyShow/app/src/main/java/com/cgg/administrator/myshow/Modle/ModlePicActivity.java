package com.cgg.administrator.myshow.Modle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;
import com.cgg.administrator.myshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/3.
 */

public class ModlePicActivity extends FragmentActivity {

    @BindView(R.id.imageView_model_back)
    ImageView imageViewModelBack;

    @BindView(R.id.vp_model)
    ViewPager vpModel;

    @BindView(R.id.mpa_tbs)
    PagerSlidingTabStrip mpaTbs;

    String[] mtitles = { "动漫壁纸", "人物壁纸" ,"壁纸","比基尼美女","制服美女",
                         "写真艺术", "性格美女", "美女车展", "美女头像", "QQ头像",
                         "微信头像","av女演员","美女性感图片","美女模特","丝袜美女",
                         "裙装美女","美女照片","情趣美女","美食图片","纹身图片",
                         "动物图片","影视剧照" , "自拍艺术"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //通知栏设为透明  android系统4.4以上才有效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_modelpic);
        ButterKnife.bind(this);

        vpModel =  (ViewPager) findViewById(R.id.vp_model);
        mpaTbs = (PagerSlidingTabStrip) findViewById(R.id.mpa_tbs);

        vpModel.setAdapter(new ModleVPAdapter(getSupportFragmentManager(),mtitles));
        mpaTbs.setViewPager(vpModel);

        imageViewModelBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
