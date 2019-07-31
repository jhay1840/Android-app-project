package com.example.dotaquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class gameOver extends AppCompatActivity {
TextView txtScore;
ImageView imgRank;
Button btnPlay,btnMenu;

int points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        btnMenu=(Button)findViewById(R.id.btn_menu) ;
        btnPlay=(Button)findViewById(R.id.btn_play) ;
        txtScore=(TextView)findViewById(R.id.txt_score);
        imgRank=(ImageView)findViewById(R.id.imgRank);
        txtScore.setText(getIntent().getExtras().getString("Score"));
        getRank();
        sendHigh();

       }
public void sendHigh(){
    SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
    int score = prefs.getInt("key", 0);

        if (points>score){
             prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("key", points);
            editor.commit();
        }

}
       public void playAgain(View view){
           Handler h= new Handler();
           final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

           // Use bounce interpolator with amplitude 0.2 and frequency 20
           MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 20);
           myAnim.setInterpolator(interpolator);

           btnPlay.startAnimation(myAnim);

           Runnable r=new Runnable() {
               @Override
               public void run() {
                   launchgame();
               }
           };
           h.postDelayed(r,1000);
       }
       public void launchgame(){
           Intent intent=new Intent(this,mainGame.class);
           startActivity(intent);

       }

    public void backMenu(View view){
        Handler h= new Handler();
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 20);
        myAnim.setInterpolator(interpolator);

        btnMenu.startAnimation(myAnim);

        Runnable r=new Runnable() {
            @Override
            public void run() {
               back();
            }
        };
        h.postDelayed(r,500);
    }
    public void back(){

        Intent intent=new Intent(gameOver.this,MainActivity.class);
        startActivity(intent);
        finish();

    }

public void getRank(){
        points=Integer.valueOf(txtScore.getText().toString());
    if(points>=100&&points<140){
        imgRank.setImageResource(R.drawable.guardian);
    }
    else if(points>=140&&points<180){
        imgRank.setImageResource(R.drawable.crusader);
    }
    else if(points>=180&&points<220){
        imgRank.setImageResource(R.drawable.archon);
    }
    else if(points>=220&&points<270){
        imgRank.setImageResource(R.drawable.legend);
    }
    else if(points>=270&&points<320){
        imgRank.setImageResource(R.drawable.ancient);
    }
    else if(points>=320&&points<480){
        imgRank.setImageResource(R.drawable.divine);
    }
    else if(points>=480){
        imgRank.setImageResource(R.drawable.immortal);
    }
    else{
        imgRank.setImageResource(R.drawable.herald);

    }

}
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        }}
