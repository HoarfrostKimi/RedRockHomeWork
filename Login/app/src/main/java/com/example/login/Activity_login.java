
package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Activity_login extends AppCompatActivity {


    private EditText mEtUserName;
    private EditText mEtUserPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews(); // 初始化视图
        initevent();
    }
    private void initViews() {
        mEtUserName= findViewById(R.id.et_main_username);
        mEtUserPassword= findViewById(R.id.et_main_password);
        mBtnLogin= findViewById(R.id.et_main_LoginButton);
        mBtnRegister= findViewById(R.id.et_main_RegisterButton);
    }
    private void initevent() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.d("Activity_login", "-------注册进去1------");
                Intent intent = new Intent(Activity_login.this, RegisterActivity.class);
                Log.d("Activity_login", "-------注册进去2------");
                startActivity(intent);
                Log.d("Activity_login", "-------注册进去3------");
            }
        });
    }

    private void login() {
        String username = mEtUserName.getText().toString();
        String password = mEtUserPassword.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String storedUsername = sharedPreferences.getString("username", "");
        String storedPassword = sharedPreferences.getString("password", "");
        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            loginSuccess();
        }else{
            loginFail();
        }
    }

    private void loginFail() {
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();

    }

    private void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Activity_login.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


}