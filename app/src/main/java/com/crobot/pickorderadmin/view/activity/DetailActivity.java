package com.crobot.pickorderadmin.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.crobot.pickorderadmin.R;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class DetailActivity extends AppCompatActivity{

    private WebView wv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_detail);
        wv = (WebView) findViewById(R.id.wv);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        wv.loadUrl(url);
    }
}
