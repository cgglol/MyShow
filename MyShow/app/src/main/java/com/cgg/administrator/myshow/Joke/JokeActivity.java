package com.cgg.administrator.myshow.Joke;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.cgg.administrator.myshow.PetalBenefit.PetalVPAdapter;
import com.cgg.administrator.myshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/20.
 */

public class JokeActivity extends FragmentActivity {

    @BindView(R.id.tv_title_petal)
    TextView tvTitlePetal;

    @BindView(R.id.imageView_pbf_back)
    ImageView imageViewPbfBack;

    @BindView(R.id.pbf_tbs)
    PagerSlidingTabStrip pbfTbs;

    @BindView(R.id.vp_pbf)
    ViewPager vpPbf;

    String[] mtitles = {"段子", "图片", "gif图"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //通知栏设为透明  android系统4.4以上才有效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_petalbenefit);
        ButterKnife.bind(this);

        tvTitlePetal.setText("笑话大全");

        vpPbf.setAdapter(new JokeVPAdapter(getSupportFragmentManager(), mtitles));
        pbfTbs.setViewPager(vpPbf);

        imageViewPbfBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
