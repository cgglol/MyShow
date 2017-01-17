package com.cgg.administrator.myshow.utils;

import android.graphics.Bitmap;

import com.cgg.administrator.myshow.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class ImageOptHelper {

  public static DisplayImageOptions getImgOptions() {
    DisplayImageOptions imgOptions = new DisplayImageOptions.Builder()
            .cacheOnDisk(true)
            .cacheInMemory(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .showImageOnLoading(R.mipmap.timeline_image_loading)
            .showImageForEmptyUri(R.mipmap.timeline_image_loading)
            .showImageOnFail(R.mipmap.timeline_image_failure)
            .build();
    return imgOptions;
  }

  public static DisplayImageOptions getAvatarOptions() {
    DisplayImageOptions avatarOptions = new DisplayImageOptions.Builder()
            .cacheOnDisk(true)
            .cacheInMemory(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .showImageOnLoading(R.mipmap.ic_launcher)
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher)
            .displayer(new RoundedBitmapDisplayer(999)).build();
    return avatarOptions;
  }

  public static DisplayImageOptions getCornerOptions(int cornerRadiusPixels) {
    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheOnDisk(true)
            .cacheInMemory(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .showImageOnLoading(R.mipmap.timeline_image_loading)
            .showImageForEmptyUri(R.mipmap.timeline_image_loading)
            .showImageOnFail(R.mipmap.timeline_image_loading)
            .displayer(new RoundedBitmapDisplayer(cornerRadiusPixels)).build();
    return options;
  }
}
