package cn.zdh.materialdesign_animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/7/2.
 */

public class TextActivity2 extends AppCompatActivity {

    TextView tv_name;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_s_activity);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText(getIntent().getStringExtra("name"));

        imageView = (ImageView) findViewById(R.id.imageView);

        //缩放动画 (动画控件；        什么动画：动画名称 比如缩放动画为scaleX 和 scaleY；         缩放:从多少到多少）//1f为本身
        ObjectAnimator scaleXAnimatorX = ObjectAnimator.ofFloat(imageView, "scaleX", 0f, 1f);
        ObjectAnimator scaleXAnimatorY = ObjectAnimator.ofFloat(imageView, "scaleY", 0f,  1f);
        scaleXAnimatorX.setDuration(500);//动画必须设置时间；
        scaleXAnimatorY.setDuration(500);//动画必须设置时间；

        //多个动画连续起来
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleXAnimatorX, scaleXAnimatorY);

        animatorSet.start();

    }

    public void back(View view) {
        if (getIntent().getBooleanExtra("bt", false)) {
            finish();
            overridePendingTransition(0, R.anim.anim_right);
        } else {
            supportFinishAfterTransition();//实现关闭动画
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getIntent().getBooleanExtra("bt", false)) {
            finish();
            overridePendingTransition(0, R.anim.anim_right);
        }


    }
}
