package com.crobot.pickorderadmin.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crobot.pickorderadmin.R;
import com.crobot.pickorderadmin.api.Constants;
import com.crobot.pickorderadmin.model.Goods;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class GoodsAdapter extends BaseAdapter {

    private List<Goods> mGoodses=new ArrayList<>(Constants.INIT_LIST_LENGTH);
    private Context mContext;
    public GoodsAdapter(Context context, List<Goods> goodses) {
        mGoodses=goodses;
        mContext=context;
    }

    @Override
    public int getCount() {
        return mGoodses.size();
    }

    @Override
    public Object getItem(int i) {
        return mGoodses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        view=layoutInflater.inflate(R.layout.goods_item,null);
        TextView textView1= (TextView) view.findViewById(R.id.tv1);
        TextView textView2= (TextView) view.findViewById(R.id.tv2);
        TextView textView3= (TextView) view.findViewById(R.id.tv3);
        TextView textView4= (TextView) view.findViewById(R.id.tv4);
        final ImageView imageView1= (ImageView) view.findViewById(R.id.iv_1);
        textView1.setText(mGoodses.get(i).getId());
        textView2.setText(mGoodses.get(i).getGoodsname());
        textView3.setText(mGoodses.get(i).getCreatedAt());
        textView4.setText(mGoodses.get(i).getUpdatedAt());
        new Thread(new Runnable() {
            @Override
            public void run() {
                imageView1.setImageBitmap(getBitmapFromURL(mGoodses.get(i).getGoodspic()));
            }
        }).start();

        return view;
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
