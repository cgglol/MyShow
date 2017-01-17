package com.cgg.administrator.myshow.PetalBenefit;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.cgg.administrator.myshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/3.
 */

public class PetalBenefitActivity extends FragmentActivity {


    String[] mtitles = {" 大胸妹", "小清新", "文艺范",
            "性感妹", "大长腿", "黑丝袜", "小翘臀"};

    @BindView(R.id.imageView_pbf_back)
    ImageView imageViewPbfBack;

    @BindView(R.id.pbf_tbs)
    PagerSlidingTabStrip pbfTbs;

    @BindView(R.id.vp_pbf)
    ViewPager vpPbf;

    @BindView(R.id.tv_title_petal)
    TextView tvTitlePetal;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //通知栏设为透明  android系统4.4以上才有效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_petalbenefit);
        ButterKnife.bind(this);

        tvTitlePetal.setText("花瓣福利");

        vpPbf.setAdapter(new PetalVPAdapter(getSupportFragmentManager(), mtitles));
        pbfTbs.setViewPager(vpPbf);

        imageViewPbfBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
