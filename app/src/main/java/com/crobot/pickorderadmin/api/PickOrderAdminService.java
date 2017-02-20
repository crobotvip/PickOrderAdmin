package com.crobot.pickorderadmin.api;

import com.crobot.pickorderadmin.model.Blog;
import com.crobot.pickorderadmin.model.Goods;
import com.crobot.pickorderadmin.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public interface PickOrderAdminService {

    /*用户*/
    @POST("user/")
    Call<User> createUser(@Body User user);

    @POST("user/login")
    Call<User> userLogin(@Body User user);

    @GET("goods")
    Call<List<Goods>> listGoods();

    /*博客*/
    @POST("blog/")
    Call<Blog> createBlog(@Body Blog blog);

    @GET("blog")
    Call<List<Blog>> listBlogs();
}
