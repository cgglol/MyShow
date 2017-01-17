package com.cgg.administrator.myshow.Robot;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.cgg.administrator.myshow.R;
import com.cgg.administrator.myshow.utils.RobotBack;
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


/**
 * Created by Administrator on 2016/10/19.
 */

public class RobotActivity extends Activity {

    @BindView(R.id.yd_btn_send)
    Button ydBtnSend;
    @BindView(R.id.rb_input)
    EditText rbInput;
    @BindView(R.id.lv_rob)
    ListView lvRob;
    @BindView(R.id.imageView_rob_back)
    ImageView imageViewRobBack;

    private RobListAdapter robListAdapter;
    public List<RobotBack.ShowapiResBodyBean> list = new ArrayList<RobotBack.ShowapiResBodyBean>();
    private OkHttpClient mOkHttpClient = new OkHttpClient();

    String err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //通知栏设为透明  android系统4.4以上才有效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_robot);
        ButterKnife.bind(this);

        initListener();

    }

    private void initListener() {

        imageViewRobBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RobotActivity.this.finish();
            }
        });

        ydBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提交对话，发送请求
                String content = rbInput.getText().toString();
                if (content.isEmpty()) {
                    Toast.makeText(RobotActivity.this, "消息不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    RobotBack.ShowapiResBodyBean resBodyBean = new RobotBack.ShowapiResBodyBean();
                    resBodyBean.setText(content);
                    list.add(resBodyBean);
                    if (null == robListAdapter) {
                        robListAdapter = new RobListAdapter(RobotActivity.this, list);
                        lvRob.setAdapter(robListAdapter);
                    }
                    PostRobitQuestion(content);
                }
                rbInput.setText("");
            }
        });
    }

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 10:
                    robListAdapter.Updata(list);
                    lvRob.setSelection(robListAdapter.getCount() - 1);
                    break;
                default:
                    break;
            }
        }
    };

    private void PostRobitQuestion(String word) {

        FormBody body = new FormBody.Builder()
                .add("showapi_appid", "25905")
                .add("showapi_sign", "efe73deceffe45679177350ba2c997e4")
                .add("info", word)
                .add("userid", "cgg")
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
                    response =mOkHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //获取数据后的操作
                        String str = response.body().string();
                        Log.i("response", str);
                        Gson gson = new Gson();
                        RobotBack robotBacks = gson.fromJson(str, RobotBack.class);
                        if(robotBacks.getShowapi_res_code()==0){
                            RobotBack.ShowapiResBodyBean resBodyBean = robotBacks.getShowapi_res_body();
                            list.add(resBodyBean);
                            handler.sendEmptyMessage(10);
                        }else {
                            err = robotBacks.getShowapi_res_error();
                            Toast.makeText(RobotActivity.this,err,Toast.LENGTH_SHORT).show();
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
