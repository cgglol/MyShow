package com.cgg.administrator.myshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.cgg.administrator.myshow.BeautifulPic.BeautifulpicActivity;
import com.cgg.administrator.myshow.Joke.JokeActivity;
import com.cgg.administrator.myshow.Modle.ModlePicActivity;
import com.cgg.administrator.myshow.PetalBenefit.PetalBenefitActivity;
import com.cgg.administrator.myshow.Pure.PureActivity;
import com.cgg.administrator.myshow.Robot.RobotActivity;
import com.cgg.administrator.myshow.Today.TodayActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_7)
    Button btn7;
    @BindView(R.id.btn_8)
    Button btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //通知栏设为透明  android系统4.4以上才有效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_2, R.id.btn_4, R.id.btn_3, R.id.btn_5, R.id.btn_6, R.id.btn_1, R.id.btn_7, R.id.btn_8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this, RobotActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this, TodayActivity.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(MainActivity.this, ModlePicActivity.class));
                break;
            case R.id.btn_4:
                startActivity(new Intent(MainActivity.this, PetalBenefitActivity.class));
                break;
            case R.id.btn_5:
                startActivity(new Intent(MainActivity.this, BeautifulpicActivity.class));
                break;
            case R.id.btn_6:
                startActivity(new Intent(MainActivity.this, PureActivity.class));
                break;
            case R.id.btn_7:
                startActivity(new Intent(MainActivity.this, JokeActivity.class));
                break;
            case R.id.btn_8:
                Toast.makeText(MainActivity.this, "漫画", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(MainActivity.this, "666", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
