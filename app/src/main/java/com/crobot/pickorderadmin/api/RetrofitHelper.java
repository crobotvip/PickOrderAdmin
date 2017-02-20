package com.crobot.pickorderadmin.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class RetrofitHelper {
    private static Retrofit retrofit = null;

    private RetrofitHelper() {
        Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                        .baseUrl(Constants.URL)
                        .addConverterFactory(GsonConverterFactory.create());

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Content-Type", " application/json;charset=UTF-8")
                        .addHeader("X-APICloud-AppId", Constants.APPID)
                        .addHeader("X-APICloud-AppKey", Constants.getAppkey())
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClientBuilder.build();
        retrofit = retrofitBuilder.client(client).build();
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            new RetrofitHelper();
        }
        return retrofit;
    }
}
