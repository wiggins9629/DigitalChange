package com.wiggins.digitalchange;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.wiggins.digitalchange.base.BaseActivity;
import com.wiggins.digitalchange.utils.UIUtils;
import com.wiggins.digitalchange.widget.NumberRollingView;
import com.wiggins.digitalchange.widget.TitleView;

/**
 * @Description 自定义数字滚动动画的TextView
 * @Author 一花一世界
 */
public class MainActivity extends BaseActivity {

    private TitleView titleView;
    private SwipeRefreshLayout srlRefresh;
    private NumberRollingView tvMoney;
    private NumberRollingView tvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        setListener();
    }

    private void initView() {
        titleView = (TitleView) findViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.title));
        titleView.setLeftImageVisibility(View.GONE);
        srlRefresh = (SwipeRefreshLayout) findViewById(R.id.srl_refresh);
        srlRefresh.setColorSchemeColors(Color.parseColor("#ff33b5e5"));
        tvMoney = (NumberRollingView) findViewById(R.id.tv_money);
        tvNum = (NumberRollingView) findViewById(R.id.tv_num);
    }

    private void initData() {
        tvMoney.setContent("9686.86");
        tvNum.setContent("9686");
    }

    private void setListener() {
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tvMoney.setUseCommaFormat(false);
                tvNum.setUseCommaFormat(false);
                tvNum.setFrameNum(50);
                tvMoney.setContent("9666.86");
                tvNum.setContent("9666");
                srlRefresh.setRefreshing(false);
            }
        });
    }
}
