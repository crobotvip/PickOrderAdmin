package com.crobot.pickorderadmin.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;

import com.crobot.pickorderadmin.R;
import com.crobot.pickorderadmin.model.Blog;
import com.crobot.pickorderadmin.view.activity.DetailActivity;

import org.kymjs.kjframe.widget.AdapterHolder;
import org.kymjs.kjframe.widget.KJAdapter;

import java.util.Collection;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class BlogAdapter extends KJAdapter<Blog> {
    private Context mContext;
    public BlogAdapter(AbsListView view, Collection<Blog> mDatas,Context context) {
        super(view, mDatas, R.layout.blog_item);
        mContext=context;
    }

    @Override
    public void convert(AdapterHolder helper, final Blog item, boolean isScrolling) {
        helper.getView(R.id.ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,DetailActivity.class);
                intent.putExtra("url",item.getLink());
                mContext.startActivity(intent);
            }
        });
        helper.setText(R.id.tv1,item.getTitle());
        helper.setText(R.id.tv2,item.getContent());
        helper.setText(R.id.tv3,item.getCount());

        super.convert(helper, item, isScrolling);
    }
}
