package com.cgg.administrator.myshow.PetalBenefit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/11/17.
 */

public class PetalVPAdapter extends FragmentPagerAdapter {

    String[] titles;
    PetalFrag f;

    public PetalVPAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles=titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Fragment getItem(int position)
    {
        f = new PetalFrag();
        Bundle bundle =new Bundle();
        switch (position) {
            case 0:
                bundle.putString("type","34");
                break;
            case 1:
                bundle.putString("type","35");
                break;
            case 2:
                bundle.putString("type","36");
                break;
            case 3:
                bundle.putString("type","37");
                break;
            case 4:
                bundle.putString("type","38");
                break;
            case 5:
                bundle.putString("type","39");
                break;
            case 6:
                bundle.putString("type","40");
                break;
          }
        f.setArguments(bundle);
        return  f;
    }
}
