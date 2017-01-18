package com.hon.newsflashview;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.hon.newsflashview.model.NewsflashModel;
import java.util.List;

/**
 * @author LLhon
 * @Project NewsflashView-master
 * @Package com.hon.newsflashview
 * @Date 2017/1/17 16:55
 * @description 自定义View仿京东快报,淘宝头条
 */

public class NewsflashView extends ViewFlipper implements View.OnClickListener {

    private List<String> mDatas;
    private List<NewsflashModel> mNewsflashModels;
    private OnNewsflashClickListener mListener;

    public NewsflashView(Context context) {
        this(context, null);
    }

    public NewsflashView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        setFlipInterval(3000); //切换View的间隔时间
        setPadding(dp2px(5f), dp2px(5f), dp2px(5f), dp2px(5f));
        setInAnimation(getContext(), R.anim.marquee_in);
        setOutAnimation(getContext(), R.anim.marquee_out);
    }

    public void setNewsflash(List<String> datas) {
        mDatas = datas;
        removeAllViews();
        for (int i=0; i< mDatas.size(); i++) {
            String content = mDatas.get(i);
            String label = "";
            if (content.indexOf(" ") != -1) {
                int index = content.indexOf(" ");
                label = content.substring(0, index);
                content = content.substring(index + 1);
            }
            TextView tv = new TextView(getContext());
            tv.setTextSize(14f);
            tv.setText(Html.fromHtml("<font color='#FA4441'>"
                + label
                + "</font>  "
                + "<font color='#333333'>"
                + content
                + "</font>"));
            tv.setBackgroundColor(Color.WHITE);
            tv.setEllipsize(TextUtils.TruncateAt.END);
            tv.setSingleLine();
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setTag(i);
            tv.setOnClickListener(this);
            addView(tv, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    public void setLabeledNewsflash(List<NewsflashModel> datas) {
        mNewsflashModels = datas;
        removeAllViews();
        for (int i=0; i< mNewsflashModels.size(); i++) {
            View view = View.inflate(getContext(), R.layout.layout_newsflash, null);
            TextView tvLabel = (TextView) view.findViewById(R.id.tv_label);
            TextView tvLabel2 = (TextView) view.findViewById(R.id.tv_label2);
            TextView tvContent = (TextView) view.findViewById(R.id.tv_content);
            TextView tvContent2 = (TextView) view.findViewById(R.id.tv_content2);
            NewsflashModel model = mNewsflashModels.get(i);
            tvLabel.setText(model.getLabel());
            tvLabel2.setText(model.getLabel2());
            tvContent.setText(model.getContent());
            tvContent2.setText(model.getContent2());
            view.setTag(i);
            view.setOnClickListener(this);
            addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    @Override public void onClick(View v) {
        int position = (int) v.getTag();
        if (mListener != null) {
            mListener.onNewsflashClick(position);
        }
    }

    public void setOnNewsflashClickListener(OnNewsflashClickListener listener) {
        mListener = listener;
    }

    public interface OnNewsflashClickListener {
        void onNewsflashClick(int position);
    }

    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
