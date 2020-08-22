package com.example.mvvm_demo.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 数据源
 */
public class UserRepository {
    //实例化本类
    private static final UserRepository instance=new UserRepository();
    private  UserRepository(){
    }

    /**
     *这个方法使得别的类可以获取本类实例
     * @return
     */
    public static  UserRepository getInstance(){
        return instance;
    }

    /**
     * 获得API方法的对象
     */
    private UserApi userApi=RetrofitFactory.getInstance().create(UserApi.class);

    /**
     * 获得LiveData数据，这里用Repository进行联网数据
     * @return
     */
    public LiveData<User> getUser(Map map){
        final MutableLiveData<User> user=new MutableLiveData<>();

        userApi.queryUserByUsername(map)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        user.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
        return user;
    }


}
