package com.example.mvvm_demo.Repository;

import com.example.mvvm_demo.Repository.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * API接口
 */
public interface UserApi {
    @GET("api/rand.music")
    Call<User> queryUserByUsername(@QueryMap Map<String,String> map);

}
