package com.cgg.administrator.myshow.Joke;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cgg.administrator.myshow.utils.JokeTextBack;

/**
 * Created by Administrator on 2016/11/17.
 */

public class JokeVPAdapter extends FragmentPagerAdapter {

    String[] titles;
    JokeFrag f;

    public JokeVPAdapter(FragmentManager fm, String[] titles) {
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
        f = new JokeFrag<JokeTextBack>();
        Bundle bundle =new Bundle();
        switch (position) {
            case 0:
                bundle.putString("url","1");
                break;
            case 1:
                bundle.putString("url","2");
                break;
            case 2:
                bundle.putString("url","3");
                break;
          }
        f.setArguments(bundle);
        return  f;
    }
}
