package com.example.mvvm_demo.helloMVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 谷歌大礼包中就有 ViewModel,
 *
 */

public class UserViewModel extends ViewModel  {
    /**
     * 创建一个可变的 LiveData，也就是 MutableLiveData。它能自动响应生命周期方法，可被观察（数据改变时通知观察者），所以可以实现 Model 和 View 的绑定。
     * 为了显示 id 和 name，我们需要一个 LiveData。即MutableLiveData
     *
     */
    private MutableLiveData<User> user;

    /**
     * 对外公开一个 getUser 方法 和 setUsername 方法。
     *
     */
    public LiveData<User> getUser(){
        if(user==null){
            user=new MutableLiveData<>();
        }
            return user;
    }


    public void setUserName(String usercode){
        user.setValue(new User(1,usercode));
    }


}
