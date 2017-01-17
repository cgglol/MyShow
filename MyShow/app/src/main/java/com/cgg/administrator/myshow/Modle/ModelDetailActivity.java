package com.cgg.administrator.myshow.Modle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.DmbzDetailBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/17.
 */

public class ModelDetailActivity extends Activity {


    @BindView(R.id.imageView_modeldetail_back_back)
    ImageView imageVBackBack;
    @BindView(R.id.id_recyclerview)
    RecyclerView idRecyclerview;

    private String id;
    private List<String> list = new ArrayList<>();
    private OkHttpClient mOkHttpClient = new OkHttpClient();
    private MDetailRVAdapter mdadapter;
    private StaggeredGridLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mdetail);
        ButterKnife.bind(this);

        id = getIntent().getStringExtra("link");

        //创建默认的线性LayoutManager
//        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        idRecyclerview.setLayoutManager(mLayoutManager);

        //创建并设置Adapter
        mdadapter = new MDetailRVAdapter(this, list);
        idRecyclerview.setAdapter(mdadapter);

        mdadapter.setOnItemClickListener(new MDetailRVAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {

                Intent intent = new Intent(ModelDetailActivity.this, ImagePagerActivity.class);
                // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
                intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, Integer.valueOf(data).intValue());
                intent.putExtra("list", (Serializable)list);
                startActivity(intent);
               // Toast.makeText(ModelDetailActivity.this,data,Toast.LENGTH_SHORT).show();
            }
        });

       initData();

        imageVBackBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initData() {

        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("id", id)
                .build();

        final Request request = new Request.Builder()
                .url("http://route.showapi.com/959-2")
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
                        DmbzDetailBack back = gson.fromJson(str, DmbzDetailBack.class);
                        if(back.getShowapi_res_code()==0){
                            DmbzDetailBack.ShowapiResBodyBean bean = back.getShowapi_res_body();
                            list = bean.getImgList();
                            handler.sendEmptyMessage(10);
                        }else{
                            Toast.makeText(ModelDetailActivity.this,back.getShowapi_res_error(),Toast.LENGTH_SHORT).show();
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
                    mdadapter.Updata(list);
                    break;
                default:
                    break;
            }
        }
    };

}
