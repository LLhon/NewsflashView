package com.hon.newsflashview_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.hon.newsflashview.NewsflashView;
import com.hon.newsflashview.model.NewsflashModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<String> mDatas;
    private List<NewsflashModel> mNewsflashModels;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        //仿京东快报
        NewsflashView newsflashView = (NewsflashView) findViewById(R.id.newsflash);
        newsflashView.setNewsflash(mDatas);
        newsflashView.setOnNewsflashClickListener(new NewsflashView.OnNewsflashClickListener() {
            @Override public void onNewsflashClick(int position) {
                Toast.makeText(MainActivity.this, mDatas.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        newsflashView.startFlipping();
        //仿淘宝头条
        NewsflashView newsflashView2 = (NewsflashView) findViewById(R.id.newsflash2);
        newsflashView2.setLabeledNewsflash(mNewsflashModels);
        newsflashView2.setOnNewsflashClickListener(new NewsflashView.OnNewsflashClickListener() {
            @Override public void onNewsflashClick(int position) {
                Toast.makeText(MainActivity.this, mNewsflashModels.get(position).getContent(), Toast.LENGTH_SHORT).show();
            }
        });
        newsflashView2.startFlipping();
    }

    private void initData() {
        mDatas = new ArrayList<>();
        mNewsflashModels = new ArrayList<>();
        mDatas.add("爆 京东健康全场5折起!");
        mDatas.add("荐 好货9块9, 百万红包立马有!");
        mDatas.add("大促 下单拆福袋, 亿万新年红包等你拿!");
        mNewsflashModels.add(
            new NewsflashModel("热评", "惊喜提前: 第一大厂终于迎来安卓7.0", "热评", "世界上最难拼的拼图究竟有多难? 不服来战!"));
        mNewsflashModels.add(
            new NewsflashModel("热议", "太给力了! 小米6售价曝光:已经开始量产", "热文", "魅族魅蓝旗舰要升价,高通新机Q4见"));
        mNewsflashModels.add(
            new NewsflashModel("热议", "小米年会竟有这等福利 女票在场不要点", "力荐", "华为新机曝光:不可按压Home键"));
    }
}
