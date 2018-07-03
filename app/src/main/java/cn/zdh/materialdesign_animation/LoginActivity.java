package cn.zdh.materialdesign_animation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/7/3.
 */

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button button;
    ProgressBar login_progress;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.email_sign_in_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login_progress = (ProgressBar) findViewById(R.id.login_progress);


        imageView = (ImageView) findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();

            }
        });
    }


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what==1){
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this, Pair.create((View) imageView, "iv"), Pair.create((View) email, "name"));
                Intent intent = new Intent(LoginActivity.this, TextActivity2.class);
                intent.putExtra("name", email.getText().toString());
                startActivity(intent, optionsCompat.toBundle());



            }

        }
    };


    @Override
    protected void onStop() {
        super.onStop();

        button.setVisibility(View.VISIBLE);
        login_progress.setVisibility(View.GONE);
    }

    private void setData() {
        if (TextUtils.isEmpty(email.getText().toString())) {
            Toast.makeText(LoginActivity.this, "账户不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password.getText().toString())) {
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }


        button.setVisibility(View.GONE);
        login_progress.setVisibility(View.VISIBLE);


        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    Thread.sleep(500);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();








    }




}
