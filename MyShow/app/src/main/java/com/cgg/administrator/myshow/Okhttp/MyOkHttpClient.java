package com.cgg.administrator.myshow.Okhttp;

import android.app.Activity;
import android.util.Log;

import com.cgg.administrator.myshow.utils.RobotBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MyOkHttpClient extends Activity{

   public   OkHttpClient mOkHttpClient = new OkHttpClient();

    public  void GetQuestion(String url){

        final Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;

                try {
                    response = mOkHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        //获取数据后的操作
                        response.body();
                    }else {
                        throw new IOException("Unexpected code" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public  List<RobotBack.ShowapiResBodyBean> PostRobitQuestion(String word, final List<RobotBack.ShowapiResBodyBean> list){

        FormBody body = new FormBody.Builder()
                .add("showapi_appid","25905")
                .add("showapi_sign","efe73deceffe45679177350ba2c997e4")
                .add("info" ,word)
                .add("userid","cgg")
                .build();

        final Request request = new Request.Builder()
                .url("http://route.showapi.com/60-27")
                .post(body)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Response response = null;

                try {
                    response = mOkHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        //获取数据后的操作
                        String str = response.body().string();
                        Log.i("response",str);
                        Gson gson = new Gson();
                        RobotBack  robotBacks = gson.fromJson(str,RobotBack.class);
                        RobotBack.ShowapiResBodyBean resBodyBean = robotBacks.getShowapi_res_body();
                        list.add(resBodyBean);
                    }else {
                        throw new IOException("Unexpected code" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return list;
    }

}
