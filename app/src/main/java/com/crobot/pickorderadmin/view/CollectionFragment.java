package com.crobot.pickorderadmin.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.crobot.pickorderadmin.R;
import com.crobot.pickorderadmin.api.Constants;
import com.crobot.pickorderadmin.api.PickOrderAdminService;
import com.crobot.pickorderadmin.api.RetrofitHelper;
import com.crobot.pickorderadmin.model.Blog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class CollectionFragment extends Fragment {
    private View mView;
    private Button btn_start_upload_data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.aty_blog, container, false);

        }

        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }
        btn_start_upload_data = (Button) mView.findViewById(R.id.btn_start_upload_data);
        btn_start_upload_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Document doc = null;
                        try {
                            doc = (Document) Jsoup.connect("http://blog.csdn.net/crobot007").post();
                            Elements items = doc.select("span.link_title>a[href]");
                            Elements items_detail = doc.select("div.article_description");
                            Elements items_read_count = doc.select("span.link_view");
                            List<Blog> blogs = new ArrayList<>(Constants.INIT_LIST_LENGTH);
                            Blog blog;
                            for (int i = 0; i < items.size(); i++) {
                                blog = new Blog();
                                blog.setTitle(items.get(i).text());
                                blog.setContent(items_detail.get(i).text());
                                blog.setCount(items_read_count.get(i).text());
                                blog.setLink(items.get(i).attr("abs:href"));
                                blogs.add(blog);
                            }

                            for (Blog temp_blog : blogs) {
                                Call<Blog> call = RetrofitHelper.getInstance().create(PickOrderAdminService.class).createBlog(temp_blog);
                                call.enqueue(new Callback<Blog>() {
                                    @Override
                                    public void onResponse(Call<Blog> call, Response<Blog> response) {
                                        Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<Blog> call, Throwable t) {
                                        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });
        return mView;
    }
}
