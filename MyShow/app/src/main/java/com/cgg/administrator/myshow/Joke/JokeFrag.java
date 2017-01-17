package com.cgg.administrator.myshow.Joke;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.JokePicBack;
import com.cgg.administrator.myshow.utils.JokeTextBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JokeFrag<T> extends Fragment {


    @BindView(R.id.id_fra_joke_listview)
    ListView Listview;

    private OkHttpClient mOkHttpClient = new OkHttpClient();

    private View v;
    private String url;

    private List<T> list = new ArrayList<>();
    private List<JokeTextBack.ShowapiResBodyBean.ContentlistBean> listt;
    private List<JokePicBack.ShowapiResBodyBean.ContentlistBean> listp;
    private List<JokePicBack.ShowapiResBodyBean.ContentlistBean> listg;
    private JokeFraListAdapter adapter;
    private Context context;
    private String err;
    private int pager = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fra_joke, container, false);

        ButterKnife.bind(this, v);

        context = getActivity();
        url = getArguments().get("url").toString();

        if (url.endsWith("1")) {
            //文本

        } else {
            //图片

        }
        initData();


        return v;
    }

    private void initData() {

        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("page", "1")
                .add("maxResult", "30")
                .build();


        final Request request = new Request.Builder()
                .url("http://route.showapi.com/341-" + url)
                .post(body)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Response response = null;

                try {
                    response = mOkHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //获取数据后的操作
                        String str = response.body().string();
                        Log.i("response", str);

                        if (url.endsWith("1")) {
                            TextBackFormat(str);
                        } else {
                            PicBackFormat(str);
                        }
                    } else {
                        throw new IOException("Unexpected code" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void TextBackFormat(String str) {
        Gson gson = new Gson();
        JokeTextBack back = gson.fromJson(str, JokeTextBack.class);
        if (back.getShowapi_res_code() == 0) {
            JokeTextBack.ShowapiResBodyBean listbean = back.getShowapi_res_body();
            list = (List<T>) listbean.getContentlist();
            handler.sendEmptyMessage(10);
        } else {
            err = back.getShowapi_res_error();
            handler.sendEmptyMessage(11);
        }
    }

    private void PicBackFormat(String str) {
        Gson gson = new Gson();
        JokePicBack back = gson.fromJson(str, JokePicBack.class);
        if (back.getShowapi_res_code() == 0) {
            JokePicBack.ShowapiResBodyBean listbean = back.getShowapi_res_body();
            list = (List<T>) listbean.getContentlist();
            handler.sendEmptyMessage(10);
        } else {
            err = back.getShowapi_res_error();
            handler.sendEmptyMessage(11);
        }
    }


    private void addData(int page) {

        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("page", page + "")
                .add("maxResult", "30")
                .build();


        final Request request = new Request.Builder()
                .url("http://route.showapi.com/341-" + url)
                .post(body)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Response response = null;

                try {
                    response = mOkHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //获取数据后的操作
                        String str = response.body().string();
                        Log.i("response", str);


                        Gson gson = new Gson();
                        JokeTextBack back = gson.fromJson(str, JokeTextBack.class);
                        if (back.getShowapi_res_code() == 0) {
                            JokeTextBack.ShowapiResBodyBean listbean = back.getShowapi_res_body();
                            list.addAll((List<T>) listbean.getContentlist());
                            handler.sendEmptyMessage(10);
                        } else {
                            err = back.getShowapi_res_error();
                            handler.sendEmptyMessage(11);
                        }
                    } else {
                        throw new IOException("Unexpected code" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 10:
                    adapter = new JokeFraListAdapter(getActivity(), list, url);
                    Listview.setAdapter(adapter);
                    break;
                case 11:
                    Toast.makeText(context, err, Toast.LENGTH_SHORT).show();
                    break;
                case 12:
                  //  adapter.Updata(list);
//                    adapter.setFooterView(0);
                    break;
                default:
                    break;
            }
        }
    };

}
