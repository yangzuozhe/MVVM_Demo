package com.example.mvvm_demo.helloMVVM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;



import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvm_demo.R;

public class UserActivity extends AppCompatActivity {
    private TextView tvid;
    private TextView tvName;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }
    public void initView(){
        tvid = (TextView) findViewById(R.id.tv_id);
        tvName = (TextView) findViewById(R.id.tv_name);
    }

    public void initDate(){

        //userViewModel= ViewModelProviders.of(this).get(UserViewModel.class);过时了
        //View 只和一个 ViewModel 绑定,所以我们需要一个 Activity 级别的单例 ViewModel.通过这个语句实现
        //不过时
        userViewModel= new ViewModelProvider(this).get(UserViewModel.class);

        //在 Activity / Fragment 中 观察 LiveData。也就是当 LiveData 数据发生变化时，自动回调方法来更新 UI。
        //这个自动回调方法就是new Observer<User>() {  ；
        //通过 userViewModel 取得 LiveData 并添加监听（绑定操作）。
        userViewModel.getUser().observe(this, new Observer<User>() {
            //这个回调方法里面，我们就可以更新与该数据相关的 UI。
            @Override
            public void onChanged(User user) {
                updateView(user);
            }
        });

        userViewModel.setUserName("小明");
    }
    public void updateView(User user){
        tvid.setText(user.getName()+" ");
    }


}