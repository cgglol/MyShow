package com.cgg.administrator.myshow.Pure;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.holder.Holder;
import com.cgg.administrator.myshow.PetalBenefit.PetalWebActivity;
import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.PureBack;
import com.google.gson.Gson;
import com.jingchen.pulltorefresh.PullToRefreshLayout;
import com.jingchen.pulltorefresh.pullableview.PullableGridView;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/19.
 */

public class PureActivity extends Activity {

    @BindView(R.id.imageView_beautifulp_back)
    ImageView imageViewBeautifulpBack;

    @BindView(R.id.b_bp_gv)
    PullableGridView bpGv;

    @BindView(R.id.tv_title_prue)
    TextView tvTitlePrue;

    private OkHttpClient mOkHttpClient = new OkHttpClient();
    private List<PureBack.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list;
    private PureGVAdapter adapter;
    private String err;
    private String page = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //通知栏设为透明  android系统4.4以上才有效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_beautifulpicactivity);
        ButterKnife.bind(this);

        tvTitlePrue.setText("清纯唯美");

        ((PullToRefreshLayout) findViewById(R.id.b_refresh_view))
                .setOnRefreshListener(new PureActivity.MListener());

        imageViewBeautifulpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initData();

        bpGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PureActivity.this, PetalWebActivity.class);
                // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
                intent.putExtra("url", list.get(position).getLink());
                startActivity(intent);
            }
        });

        //上拉加载


    }


    class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }

    private void initData() {

        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("page", page)
                .build();

        final Request request = new Request.Builder()
                .url("http://route.showapi.com/1177-1")
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
                        PureBack back = gson.fromJson(str, PureBack.class);
                        if (back.getShowapi_res_code() == 0) {
                            PureBack.ShowapiResBodyBean.PagebeanBean listbean = back.getShowapi_res_body().getPagebean();
                            list = listbean.getContentlist();
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
                    adapter = new PureGVAdapter(PureActivity.this, list);
                    bpGv.setAdapter(adapter);
                    break;
                case 11:
                    Toast.makeText(PureActivity.this, err, Toast.LENGTH_SHORT).show();
                    break;
                case 12:
                    adapter.Updata(list);
                    break;
                default:
                    break;
            }
        }
    };

    private void addData() {

        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("page", page)
                .build();

        final Request request = new Request.Builder()
                .url("http://route.showapi.com/1177-1")
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
                        PureBack back = gson.fromJson(str, PureBack.class);
                        if (back.getShowapi_res_code() == 0) {
                            PureBack.ShowapiResBodyBean.PagebeanBean listbean = back.getShowapi_res_body().getPagebean();
                            list.addAll(listbean.getContentlist());
                            handler.sendEmptyMessage(12);
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


    class MListener implements PullToRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
            // 下拉刷新操作
            new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    // 千万别忘了告诉控件刷新完毕了哦！
                    pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                    page = "1";
                    initData();

                }
            }.sendEmptyMessageDelayed(0, 0);
        }

        @Override
        public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
            // 加载操作
            new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    // 千万别忘了告诉控件加载完毕了哦！
                    pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                    page = (Integer.valueOf(page) + 1) + "";
                    addData();
                }
            }.sendEmptyMessageDelayed(0, 0);
        }

    }

}
