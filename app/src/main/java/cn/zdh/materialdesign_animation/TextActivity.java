package cn.zdh.materialdesign_animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;

/**
 * Created by Administrator on 2018/7/2.
 */

public class TextActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);

//        Slide slide = new Slide();//滑动效果
//        slide.setDuration(300);
//        getWindow().setExitTransition(slide);//出去的动画
//        getWindow().setEnterTransition(slide);//进来的动画


        Explode explode = new Explode();//展开效果
		explode.setDuration(500);
		getWindow().setExitTransition(explode);//出去的动画
		getWindow().setEnterTransition(explode);//进来的动画

//        Fade fade = new Fade();//渐变效果
//        fade.setDuration(500);
//        getWindow().setExitTransition(fade);//出去的动画
//        getWindow().setEnterTransition(fade);//进来的动画

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
