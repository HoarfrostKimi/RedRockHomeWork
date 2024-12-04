
package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;

public class RegisterActivity extends AppCompatActivity {
    private  Button mRtRegisterExit;
    private EditText  mRtRegisterName;
    private EditText mRtRegisterPassword;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        initevent();

    }

    private void initViews() {
        mRtRegisterName= findViewById(R.id.et_register_username);
        mRtRegisterPassword= findViewById(R.id.et_register_password);
        mBtnRegister= findViewById(R.id.et_register_Register);
        mRtRegisterExit= findViewById(R.id.et_register_exit);
    }

    private void initevent() {
        clickRegister();
        Register();
    }

    private void clickRegister() {
        mRtRegisterExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,Activity_login.class);
                startActivity(intent);
            }
        });
    }
    private void Register() {
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mRtRegisterName.getText().toString();
                String password = mRtRegisterPassword.getText().toString();
                Log.d("RegisterActivity", "Username: " + username);
                Log.d("RegisterActivity", "Password: " + password);
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    // 这里可以添加实际的注册逻辑，例如保存到数据库
                    SharedPreferences.Editor editor = getSharedPreferences("user_info", Context.MODE_PRIVATE).edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, Activity_login.class);
                    startActivity(intent); // 添加这一行启动新的 Activity
                }
            }
        });
    }
}




