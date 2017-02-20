package com.crobot.pickorderadmin.adapter;

import android.widget.AbsListView;

import com.crobot.pickorderadmin.R;
import com.crobot.pickorderadmin.model.Goods;
import com.crobot.pickorderadmin.utils.KjBitmapHelper;

import org.kymjs.kjframe.widget.AdapterHolder;
import org.kymjs.kjframe.widget.KJAdapter;

import java.util.Collection;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class OrderAdapter extends KJAdapter<Goods> {

    public OrderAdapter(AbsListView view, Collection mDatas) {
        super(view, mDatas, R.layout.goods_item);
    }

    @Override
    public void convert(AdapterHolder helper, Goods item, boolean isScrolling) {
        helper.setText(R.id.tv1,item.getCreatedAt());
        helper.setText(R.id.tv2,item.getUpdatedAt());
        helper.setText(R.id.tv3,item.getGoodsname());
        helper.setText(R.id.tv4,item.getId());
        KjBitmapHelper.getInstance().display(helper.getView(R.id.iv_1),item.getGoodspic());
        super.convert(helper, item, isScrolling);
    }
}
