package com.github.lianghanzhen.sample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.lianghanzhen.LazyViewPager;
import com.github.lianghanzhen.LazyViewPagerAdapter;

public class TestLazyViewPagerAdapterActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ((LazyViewPager) findViewById(R.id.lazy_view_pager)).setAdapter(new CustomLazyViewPagerAdapter(this));
    }

    private static class CustomLazyViewPagerAdapter extends LazyViewPagerAdapter {

        private final Context mContext;

        private CustomLazyViewPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public View getItem(ViewGroup container, int position) {
            return buildItemView(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        private View buildItemView(int position) {
            TextView view = new TextView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
            view.setText(String.format("ItemView #%d", position));
            view.setTextColor(Color.BLACK);
            view.setTextSize(18);
            view.setGravity(Gravity.CENTER);
            view.setBackgroundColor(Color.YELLOW);
            return view;
        }

    }

}
