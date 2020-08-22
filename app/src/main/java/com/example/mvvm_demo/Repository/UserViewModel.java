package com.example.mvvm_demo.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.Map;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository=UserRepository.getInstance();
    private LiveData<User> user;

    /**
     * 这个方法使得viewHolder和view进行结合，让view可以获得viewHolder的对象
     *
     * @return
     */
    public LiveData<User> getUser(Map map){
        if(user==null){
            user=userRepository.getUser(map);
        }
        return user;
    }

}
