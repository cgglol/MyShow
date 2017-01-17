package com.cgg.administrator.myshow.Modle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.DmbzFraBack;
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

public class DmbzFrag extends Fragment {

    @BindView(R.id.gv_fra_dmbz)
    GridView gvFraDmbz;

    private OkHttpClient mOkHttpClient = new OkHttpClient();

    private View v;
    private String link;

    private List<DmbzFraBack.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list = new ArrayList<>();
    private DmbzFraGVAdapter adapter;
    private Context context;
    private String err;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fra_dmbz, container, false);

        ButterKnife.bind(this, v);

        context = getActivity();
        link = getArguments().get("type").toString();

        adapter = new DmbzFraGVAdapter(getActivity(),list);
        gvFraDmbz.setAdapter(adapter);

        initData();

        initListener();
        return v;
    }

    private void initListener() {

        gvFraDmbz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),ModelDetailActivity.class);
                i.putExtra("link",list.get(position).getLink());
                startActivity(i);
            }
        });

    }

    private void initData() {

        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("type",link)
                .build();

        final Request request = new Request.Builder()
                .url("http://route.showapi.com/959-1")
                .post(body)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Response response = null;

                try {
                    response =mOkHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //获取数据后的操作
                        String str = response.body().string();
                        Log.i("response", str);
                        Gson gson = new Gson();
                        DmbzFraBack back = gson.fromJson(str, DmbzFraBack.class);
                        if(back.getShowapi_res_code()==0){
                            DmbzFraBack.ShowapiResBodyBean.PagebeanBean listbean = back.getShowapi_res_body().getPagebean();
                            list = listbean.getContentlist();
                            handler.sendEmptyMessage(10);
                        }else {
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
                    adapter.Updata(list);
                    break;
                case 11:
                    Toast.makeText(context,err,Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

}
