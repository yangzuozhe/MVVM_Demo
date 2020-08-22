package com.example.mvvm_demo.Repository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvm_demo.R;

import java.util.HashMap;
import java.util.Map;

public class RetrofitActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    UserViewModel userViewModel=new UserViewModel();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        textView1=findViewById(R.id.text_view1);
        textView2=findViewById(R.id.text_view2);
        button=findViewById(R.id.button_change);
        initData();
    }
    public void initData(){
        Map<String,String> map=new HashMap<>();
        map.put("sort","新歌榜");
        map.put("format","json");
        userViewModel.getUser(map).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                updata(user);
            }
        });


    }

    public void updata(User user){
        textView2.setText(user.getData().getArtistsname());
        textView1.setText(user.getData().getName());
    }



}