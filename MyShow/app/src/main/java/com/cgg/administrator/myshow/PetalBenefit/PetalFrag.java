package com.cgg.administrator.myshow.PetalBenefit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.PetalBenefitBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PetalFrag extends Fragment {

    @BindView(R.id.id_fra_petal_recyclerview)
    RecyclerView p_Recyclerview;

    private OkHttpClient mOkHttpClient = new OkHttpClient();

    private View v;
    private String link;

    private List<PetalBenefitBack> list = new ArrayList<>();
    private PetalFraGVAdapter adapter;
    private Context context;
    private String err;
    private StaggeredGridLayoutManager mLayoutManager;
    private int pager = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fra_petal, container, false);

        ButterKnife.bind(this, v);

        context = getActivity();
        link = getArguments().get("type").toString();
//        Toast.makeText(context, link, Toast.LENGTH_SHORT).show();

        mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        p_Recyclerview.setLayoutManager(mLayoutManager);

       //创建并设置Adapter

        adapter = new PetalFraGVAdapter(list);
        p_Recyclerview.setAdapter(adapter);

        adapter.setOnItemClickListener(new PetalFraGVAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Intent intent = new Intent(getActivity(), PetalWebActivity.class);
                // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
                intent.putExtra("url", list.get(Integer.valueOf(data).intValue()).getUrl());
                startActivity(intent);
            }
        });

        initData();

        p_Recyclerview.addOnScrollListener(new OnRecyclerViewScrollListener<PetalBenefitBack>() {
            @Override
            public void onStart() {
                adapter.setFooterView(R.layout.item_footer);
                if (adapter.hasHeader()){
                    p_Recyclerview.smoothScrollToPosition(adapter.getItemCount()+1);
                }else{
                    p_Recyclerview.smoothScrollToPosition(adapter.getItemCount());
                }
            }

            @Override
            public void onLoadMore() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("TAG","模拟网络请求数据");
                            pager = pager + 1;
                            addData(pager);
                            setLoadingMore(false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            @Override
            public void onFinish(List<PetalBenefitBack> list) {

            }

        });

        return v;
    }

    private void initData() {

        FormBody body = new FormBody.Builder()
                    .add("showapi_appid", "25905")
                    .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                    .add("type", link)
                    .add("num", "36")
                    .build();


        final Request request = new Request.Builder()
                .url("http://route.showapi.com/819-1")
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


                        JSONObject j1 = new JSONObject(str);
                        if (j1.getInt("showapi_res_code") == 0) {

                            JSONObject j2 = j1.getJSONObject("showapi_res_body");

                            for (int i = 0; i < 36; i++) {
                                PetalBenefitBack pbb = new PetalBenefitBack();
                                JSONObject j3 = j2.getJSONObject(i + "");
                                pbb.setThumb(j3.optString("thumb"));
                                pbb.setTitle(j3.optString("title"));
                                pbb.setUrl(j3.optString("url"));
                                list.add(pbb);
                            }
                            if (list != null) {
                                handler.sendEmptyMessage(10);
                            }
                        } else {
                            err = j1.getString("showapi_res_error");
                            handler.sendEmptyMessage(11);
                        }
                    } else {
                        throw new IOException("Unexpected code" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void addData(int page) {

//        List<PetalBenefitBack> alist = new ArrayList<>();
        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("type", link)
                .add("page",page+"")
                .add("num", "36")
                .build();


        final Request request = new Request.Builder()
                .url("http://route.showapi.com/819-1")
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


                        JSONObject j1 = new JSONObject(str);
                        if (j1.getInt("showapi_res_code") == 0) {

                            JSONObject j2 = j1.getJSONObject("showapi_res_body");

                            for (int i = 0; i < 36; i++) {
                                PetalBenefitBack pbb = new PetalBenefitBack();
                                JSONObject j3 = j2.getJSONObject(i + "");
                                pbb.setThumb(j3.optString("thumb"));
                                pbb.setTitle(j3.optString("title"));
                                pbb.setUrl(j3.optString("url"));
                                 list.add(pbb);
                            }
                            if (list != null) {
                                handler.sendEmptyMessage(12);
                            }
                        } else {
                            err = j1.getString("showapi_res_error");
                            handler.sendEmptyMessage(11);
                        }
                    } else {
                        throw new IOException("Unexpected code" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
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
                    Toast.makeText(context, err, Toast.LENGTH_SHORT).show();
                    break;
                case 12:
                    adapter.Updata(list);
                    adapter.setFooterView(0);
                    break;
                default:
                    break;
            }
        }
    };

}
