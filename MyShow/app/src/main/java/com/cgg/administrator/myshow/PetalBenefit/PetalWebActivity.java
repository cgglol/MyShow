package com.cgg.administrator.myshow.PetalBenefit;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.cgg.administrator.myshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class PetalWebActivity extends Activity {

    @BindView(R.id.imageView_webp_back_back)
    ImageView imageViewWebpBackBack;
    @BindView(R.id.web_petal)
    WebView webview;

    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.web_petal);

        ButterKnife.bind(this);

        url = getIntent().getStringExtra("url");

        imageViewWebpBackBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    webview.getSettings().setJavaScriptEnabled(true);

    webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    // 加载需要显示的网页
    webview.loadUrl(url);

    webview.setWebViewClient(new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    });

    webview.setOnKeyListener(new View.OnKeyListener() {
      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
          if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {  //表示按返回键 时的操作
              webview.goBack();   //后退
              //webview.goForward();//前进
              return true;    //已处理
          }
      }
        return false;
      }
    });

    }
}
