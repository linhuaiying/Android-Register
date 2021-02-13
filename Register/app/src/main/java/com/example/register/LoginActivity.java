package com.example.register;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class LoginActivity extends AppCompatActivity{
    EditText user;
    EditText password;
    String account;
    String pwd;
    Map<String,String> userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        userInfo=SaveAccount.getUserInfo(this);
        account=userInfo.get("account");
        pwd=userInfo.get("password");
    }
    public void onClick(View view)
    {
        user=(EditText) findViewById(R.id.user_name);
        password=(EditText) findViewById(R.id.password);
        if(user.getText().toString().equalsIgnoreCase(account)&&password.getText().toString().equalsIgnoreCase(pwd)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
           startActivity(intent);
       }
        else
        {
            Toast.makeText(LoginActivity.this,"密码或者账号错误",Toast.LENGTH_SHORT).show();
        }
    }
    public void onTestClick(View view)
    {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
