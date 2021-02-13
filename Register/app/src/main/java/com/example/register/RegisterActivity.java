package com.example.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        username=findViewById(R.id.register_user_name);
        password=findViewById(R.id.register_password);
        repassword=findViewById(R.id.register_password2);
    }
    public void onRegisterClick(View view)
    {
        if(repassword.getText().toString().equalsIgnoreCase(password.getText().toString()))
        {
            SaveAccount.saveUserInfo(this, username.getText().toString(), password.getText().toString());
            Toast.makeText(this,"注册成功！",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
    public void onBackClick(View view)
    {
        finish();
    }
}
