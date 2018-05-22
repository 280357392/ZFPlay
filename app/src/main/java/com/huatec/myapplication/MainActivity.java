package com.huatec.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        final PasswordView pwdView = findViewById(R.id.pwd_view);

        // 添加回调接口
        pwdView.setOnFinishInput(new OnPasswordInputFinish() {
            @Override
            public void inputFinish() {
                // 输入完成后我们简单显示一下输入的密码
                // 也就是说——>实现你的交易逻辑什么的在这里写
                Toast.makeText(MainActivity.this, pwdView.getStrPassword(),
                        Toast.LENGTH_SHORT).show();
            }
            //取消支付
            @Override
            public void outfo() {
                //关闭支付页面
                finish();
            }
            //忘记密码回调事件
            @Override
            public void forgetPwd() {
                Toast.makeText(MainActivity.this, "忘记密码", Toast.LENGTH_SHORT).show();
            }
        });
    }
}