package com.cgg.administrator.myshow.application;

import android.app.Application;
import android.content.Context;

import com.cgg.administrator.myshow.utils.ImageOptHelper;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MyShowApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initImageloader(this);

    }

    public void initImageloader(Context context){

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 1)
                .denyCacheImageMultipleSizesInMemory()
                .threadPoolSize(5)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(ImageOptHelper.getImgOptions())
                .build();

        ImageLoader.getInstance().init(configuration);
    }
}
