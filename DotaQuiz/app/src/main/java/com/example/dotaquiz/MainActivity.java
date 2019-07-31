package com.example.dotaquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
TextView txtscore;
MediaPlayer bgm;

Button btn_start;
    Handler h= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bgm=MediaPlayer.create(this,R.raw.bgm);
        btn_start=(Button)findViewById(R.id.btn_start);
        txtscore=(TextView)findViewById(R.id.txt_score);
        bgm.start();
        getScore();
    }

    public void getScore(){
        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int score = prefs.getInt("key", 0);
        txtscore.setText("High Score: "+String.valueOf(score));
    }
public void launchGame(){
        bgm.release();
        Intent intent=new Intent(this,mainGame.class);
        startActivity(intent);
        finish();


}



    public void didTapButton(View view) {

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        btn_start.startAnimation(myAnim);

            Runnable r=new Runnable() {
                @Override
                public void run() {
                    launchGame();
                }
            };
            h.postDelayed(r,1000);
    }

}
