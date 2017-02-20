package com.crobot.pickorderadmin.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.crobot.pickorderadmin.adapter.BlogAdapter;
import com.crobot.pickorderadmin.R;
import com.crobot.pickorderadmin.api.PickOrderAdminService;
import com.crobot.pickorderadmin.api.RetrofitHelper;
import com.crobot.pickorderadmin.model.Blog;

import java.util.List;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class HomeFragment extends Fragment {
    private View mView;
    private ListView lv_content;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.frag_home, container, false);

        }

        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }


        lv_content = (ListView) mView.findViewById(R.id.lv_content);

        Call<List<Blog>> call= RetrofitHelper.getInstance().create(PickOrderAdminService.class).listBlogs();
        call.enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                lv_content.setAdapter(new BlogAdapter(lv_content,response.body(),getContext()));
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {

            }
        });



        return mView;
    }
}
