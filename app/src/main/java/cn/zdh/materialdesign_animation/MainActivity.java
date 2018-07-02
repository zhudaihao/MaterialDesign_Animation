package cn.zdh.materialdesign_animation;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button bt6, bt5, bt7, bt8;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);


        imageView = (ImageView) findViewById(R.id.imageView);

        bt5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                setView();
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                setView2();
            }
        });
    }



    private void setView() {
        //揭露效果(动画对象，第二和第三个参数：分别是开始缩放点的 x 和 y 坐标；第四和第五：分别是开始的半径和结束的半径)

        Animator circularReveal = ViewAnimationUtils.createCircularReveal(bt5, bt5.getWidth() / 2, bt5.getHeight() / 2, 0, bt5.getHeight());
        circularReveal.setDuration(500);
        circularReveal.setInterpolator(new AccelerateInterpolator());//加速
        circularReveal.start();

    }


    private void setView2() {
        //揭露效果(动画对象，第二和第三个参数：分别是开始缩放点的 x 和 y 坐标；第四和第五：分别是开始的半径和结束的半径)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(bt6, 0, 0, 0, (float) Math.hypot(bt6.getWidth(), bt6.getHeight()));
        circularReveal.setDuration(500);
        circularReveal.setInterpolator(new AccelerateInterpolator());//加速
        circularReveal.start();

//        double hypot = Math.hypot(bt5.getWidth(), bt5.getHeight());//勾股定理
    }


    /**
     * 点击监听
     */

    //activity切换动画
    public void bt(View view) {
        startActivity(new Intent(this, TextActivity.class).putExtra("bt", true));
        overridePendingTransition(R.anim.anim_left, 0);

    }

    //多个view 一起实现转场动画
    public void bt8(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create((View) imageView, "iv"), Pair.create((View) bt8, "bt"));
        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    //单个view 实现转场动画
    public void iv(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "iv");
        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent, optionsCompat.toBundle());

    }


    //activity切换动画 加view实现转场动画

    public void bt9(View view) {
//        Slide slide = new Slide();//滑动效果
//        slide.setDuration(300);
//        getWindow().setExitTransition(slide);//出去的动画
//        getWindow().setEnterTransition(slide);//进来的动画


        Explode explode = new Explode();//展开效果
		explode.setDuration(500);
		getWindow().setExitTransition(explode);//出去的动画
		getWindow().setEnterTransition(explode);//进来的动画

//		Fade fade = new Fade();//渐变效果
//		fade.setDuration(500);
//		getWindow().setExitTransition(fade);//出去的动画
//		getWindow().setEnterTransition(fade);//进来的动画

        //所有View有转场动画
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this);
        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent, activityOptionsCompat.toBundle());
    }
}
