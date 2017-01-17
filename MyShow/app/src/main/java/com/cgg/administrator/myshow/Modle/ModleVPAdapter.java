package com.cgg.administrator.myshow.Modle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ModleVPAdapter extends FragmentPagerAdapter {

    String[] titles;
    DmbzFrag f;

    public ModleVPAdapter(FragmentManager fm, String[] titles) {
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
        f = new DmbzFrag();
        Bundle bundle =new Bundle();
        switch (position) {
            case 0:
                bundle.putString("type","dmbz");
                break;
            case 1:
                bundle.putString("type","rwbz");
                break;
            case 2:
                bundle.putString("type","bz");
                break;
            case 3:
                bundle.putString("type","bijini");
                break;
            case 4:
                bundle.putString("type","zhifu");
                break;
            case 5:
                bundle.putString("type","nvyou");
                break;
            case 6:
                bundle.putString("type","xingge");
                break;
            case 7:
                bundle.putString("type","rufang");
                break;
            case 8:
                bundle.putString("type","meitun");
                break;
            case 9:
                bundle.putString("type","qqtx");
                break;
            case 10:
                bundle.putString("type","wxtx");
                break;
            case 11:
                bundle.putString("type","av");
                break;
            case 12:
                bundle.putString("type","xinggan");
                break;
            case 13:
                bundle.putString("type","mote");
                break;
            case 14:
                bundle.putString("type","siwa");
                break;
            case 15:
                bundle.putString("type","qunzhuang");
                break;
            case 16:
                bundle.putString("type","meinv");
                break;
            case 17:
                bundle.putString("type","qingqu");
                break;
            case 18:
                bundle.putString("type","meishi");
                break;
            case 19:
                bundle.putString("type","wenshen");
                break;
            case 20:
                bundle.putString("type","dongwu");
                break;
            case 21:
                bundle.putString("type","yingshi");
                break;
            case 22:
                bundle.putString("type","tpzp");
                break;
        }
        f.setArguments(bundle);
        return  f;
    }
}
