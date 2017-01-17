package com.cgg.administrator.myshow.Today;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.TodayBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/10/19.
 */

public class TodayActivity extends Activity {

    @BindView(R.id.imageView_today_back)
    ImageView imageViewTodayBack;
    @BindView(R.id.lv_today)
    ListView lvToday;

    private OkHttpClient mOkHttpClient = new OkHttpClient();
    private TodayListAdapter todayListAdapter;
    public List<TodayBack.ShowapiResBodyBean.ListBean> list = new ArrayList<TodayBack.ShowapiResBodyBean.ListBean>();

    String err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //通知栏设为透明  android系统4.4以上才有效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_today);
        ButterKnife.bind(this);

        todayListAdapter = new TodayListAdapter(list , TodayActivity.this);
        lvToday.setAdapter(todayListAdapter);

        initData();

    }

    @OnClick({R.id.imageView_today_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_today_back:
                finish();
                break;
        }
    }

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 10:
                    todayListAdapter.Updata(list);
                    break;
                case 11:
                    Toast.makeText(TodayActivity.this,err,Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    private void initData() {

            FormBody body = new FormBody.Builder()
                    .add("showapi_appid", "25905")
                    .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                    .build();

            final Request request = new Request.Builder()
                    .url("http://route.showapi.com/119-42")
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
                            TodayBack today = gson.fromJson(str, TodayBack.class);
                            if(today.getShowapi_res_code() == 0 ){
                                TodayBack.ShowapiResBodyBean resBodyBean = today.getShowapi_res_body();
                                list  =  resBodyBean.getList();
                                handler.sendEmptyMessage(10);
                            }else {
                                err = today.getShowapi_res_error();
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
}
