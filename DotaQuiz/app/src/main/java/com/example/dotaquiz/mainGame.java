package com.example.dotaquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class mainGame extends AppCompatActivity {
    ImageView imgQuest;
TextView txtTimer,txtLabel,txtScore;
CountDownTimer cTimer;
Button btn;
ImageButton btn1,btn2,btn3,btn4,btn5,btn6;
String itemQuestion[]=new String[]{"hood_of_defiance","lesser_crit","dragon_lance","null_talisman","headdress","veil_of_discord","vanguard",
        "sange","wraith_band","buckler","aether_lens","blade_mail","yasha","bracer","force_staff"};
long countdownperiod=58000;
String hood_of_defiance[]=new String[]{"ring_of_health","ring_of_regen","cloak","headdress","ring_of_protection","veil_of_discord"};
String lesser_crit[]=new String[]{"broadsword","blades_of_attack","recipe","quarterstaff","chainmail","javelin"};
String dragon_lance[]=new String[]{"ogre_axe","boots_of_elves","blade_of_alacrity","wraith_band","recipe","boots_of_elves"};
String null_talisman[]=new String[]{"circlet","recipe","mantle","slippers","gauntlets","branches"};
String headdress[]=new String[]{"branches","ring_of_regen","ring_of_health","ring_of_protection","recipe","robe"};
String veil_of_discord[]=new String[]{"helm_of_iron_will","ring_of_regen","recipe","cloak","crown","null_talisman"};
String vanguard[]=new String[]{"stout_shield","slippers","ring_of_regen","ring_of_health","point_booster","vitality_booster"};
String sange[]=new String[]{"blade_of_alacrity","ogre_axe","robe","boots_of_elves","recipe","belt_of_strength"};
String wraith_band[]=new String[]{"circlet","recipe","mantle","slippers","gauntlets","branches"};
String bracer[]=new String[]{"circlet","recipe","mantle","slippers","gauntlets","branches"};
String buckler[]=new String[]{"stout_shield","recipe","chainmail","belt_of_strength","gauntlets","branches"};
String aether_lens[]=new String[]{"point_booster","energy_booster","void_stone","staff_of_wizardry","recipe","sobi_mask"};
String blade_mail[]=new String[]{"buckler","chainmail","recipe","broadsword","robe","blades_of_attack"};
String yasha[]=new String[]{"blade_of_alacrity","ogre_axe","robe","boots_of_elves","recipe","belt_of_strength"};
String force_staff[]=new String[]{"staff_of_wizardry","robe","ring_of_regen","recipe","null_talisman","mantle"};
String answer[]=new String[3];
String ans1="",ans2="",ans3="";
int x,c=0,t=0,score=0;
MediaPlayer bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        bgm= MediaPlayer.create(this,R.raw.bgmm);
        txtTimer=(TextView)findViewById(R.id.txt_timer) ;
        btn=(Button)findViewById(R.id.button) ;
        btn1=(ImageButton)findViewById(R.id.btn1) ;
        btn2=(ImageButton)findViewById(R.id.btn2) ;
        btn3=(ImageButton)findViewById(R.id.btn3) ;
        btn4=(ImageButton)findViewById(R.id.btn4) ;
        btn5=(ImageButton)findViewById(R.id.btn5) ;
        btn6=(ImageButton)findViewById(R.id.btn6) ;
        txtLabel=(TextView)findViewById(R.id.txtlabel) ;
        imgQuest=(ImageView)findViewById(R.id.img_quest);
        txtScore=(TextView)findViewById(R.id.txt_score) ;
bgm.start();

        randomItem();
        setItem();
        randChoice();


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               score=480;
               txtScore.setText(String.valueOf(score));
                gameoverna();

                setItem();
             randChoice();

           }
       });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t==0){
                    t=1;
                    startTime();}
                String resource = (String) btn1.getTag();
                if (c == 2) {
                    ans3=resource;
                    c = 0;
                    checkAnswer();
                } else {
                    btn1.setVisibility(View.INVISIBLE);
                    if (ans1=="") {
                        ans1 = resource;
                    }else if (ans2==""){
                        ans2=resource;
                    }
                   c++;
                    }
                }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t==0){
                    t=1;
                    startTime();}
                String resource = (String) btn2.getTag();
                if (c == 2) {
                    ans3=resource;
                    c = 0;
                    checkAnswer();
                } else {
                    btn2.setVisibility(View.INVISIBLE);
                    if (ans1=="") {
                        ans1 = resource;
                    }else if (ans2==""){
                        ans2=resource;
                    }
                    c++;
                }
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t==0){
                    t=1;
                    startTime();}
                String resource = (String) btn3.getTag();
                if (c == 2) {
                    ans3=resource;
                    c = 0;
                    checkAnswer();
                } else {
                    btn3.setVisibility(View.INVISIBLE);
                    if (ans1=="") {
                        ans1 = resource;
                    }else if (ans2==""){
                        ans2=resource;
                    }
                    c++;
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t==0){
                    t=1;
                    startTime();}
                String resource = (String) btn4.getTag();
                if (c == 2) {
                    ans3=resource;
                    c = 0;



                    checkAnswer();

                } else {
                    btn4.setVisibility(View.INVISIBLE);
                    if (ans1=="") {
                        ans1 = resource;
                    }else if (ans2==""){
                        ans2=resource;
                    }

                    c++;
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t==0){
                    t=1;
                    startTime();}
                String resource = (String) btn5.getTag();
                if (c == 2) {
                    ans3=resource;
                    c = 0;



                    checkAnswer();

                } else {
                    btn5.setVisibility(View.INVISIBLE);
                    if (ans1=="") {
                        ans1 = resource;
                    }else if (ans2==""){
                        ans2=resource;
                    }

                    c++;
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t==0){
                    t=1;
                    startTime();}
                String resource = (String) btn6.getTag();
                if (c == 2) {
                    ans3=resource;
                    c = 0;

                    checkAnswer();
                } else {
                    btn6.setVisibility(View.INVISIBLE);
                    if (ans1=="") {
                        ans1 = resource;
                    }else if (ans2==""){
                        ans2=resource;
                    }

                    c++;
                }
            }
        });
    }
    public  void correct(){
        score+=10;
        txtScore.setText(String.valueOf(score));
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_plus,
                (ViewGroup) findViewById(R.id.plusToast));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 20);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }
    public  void wrong(){
        minusTime();
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_minus,
                (ViewGroup) findViewById(R.id.minusToast));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 20);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }
    public void checkAnswer(){
        answer[0]=ans1;answer[1]=ans2;answer[2]=ans3;
        Arrays.sort(answer);

       switch (txtLabel.getText().toString()){
           case "hood_of_defiance":

               if (Arrays.toString(answer).equals("[cloak, ring_of_health, ring_of_regen]")){
                   startTime();
                   setItem();
                   randChoice();
                  correct();

               }
               else{
                wrong();
               }
               break;
           case "lesser_crit":

               if (Arrays.toString(answer).equals("[blades_of_attack, broadsword, recipe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "dragon_lance":

               if (Arrays.toString(answer).equals("[boots_of_elves, boots_of_elves, ogre_axe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "null_talisman":

               if (Arrays.toString(answer).equals("[circlet, mantle, recipe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "headdress":

               if (Arrays.toString(answer).equals("[branches, recipe, ring_of_regen]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();
               }
               else{
                   wrong();
               }
               break;
           case "veil_of_discord":

               if (Arrays.toString(answer).equals("[crown, helm_of_iron_will, recipe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();
               }
               else{
                   wrong();
               }
               break;
           case "vanguard":

               if (Arrays.toString(answer).equals("[ring_of_health, stout_shield, vitality_booster]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "sange":

               if (Arrays.toString(answer).equals("[belt_of_strength, ogre_axe, recipe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "wraith_band":

               if (Arrays.toString(answer).equals("[circlet, recipe, slippers]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "bracer":

               if (Arrays.toString(answer).equals("[circlet, gauntlets, recipe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "buckler":

               if (Arrays.toString(answer).equals("[branches, chainmail, recipe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();

               }
               break;
           case "aether_lens":

               if (Arrays.toString(answer).equals("[energy_booster, recipe, void_stone]")){
                   startTime();
                   setItem();randChoice();
                   correct();


               }
               else{
                   wrong();

               }
               break;
           case "blade_mail":

               if (Arrays.toString(answer).equals("[broadsword, chainmail, robe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();
               }
               else{
                   wrong();
               }
               break;
           case "yasha":

               if (Arrays.toString(answer).equals("[blade_of_alacrity, boots_of_elves, recipe]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();

               }
               else{
                   wrong();
               }
               break;
           case "force_staff":

               if (Arrays.toString(answer).equals("[recipe, ring_of_regen, staff_of_wizardry]")){
                   startTime();
                   setItem();
                   randChoice();
                   correct();
               }
               else{
                   wrong();
               }
               break;
               default:
                   txtTimer.setText("");


       }
        answer=new String[3];
        enableButton();
        ans1="";ans2="";ans3="";





    }
    public void randChoice(){
        ImageButton buttons1 []= new ImageButton[]{btn1,btn2,btn3,btn4,btn5,btn6};
        List<String> a;
        switch (txtLabel.getText().toString()){
            case "hood_of_defiance":
                a = Arrays.asList(hood_of_defiance);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,hood_of_defiance[i]));
                    buttons1[i].setTag(hood_of_defiance[i]);
                }break;
            case "lesser_crit":
                a = Arrays.asList(lesser_crit);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,lesser_crit[i]));
                    buttons1[i].setTag(lesser_crit[i]);
                }break;

            case "dragon_lance":
               a = Arrays.asList(dragon_lance);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,dragon_lance[i]));
                    buttons1[i].setTag(dragon_lance[i]);
                }break;
            case "null_talisman":
                a = Arrays.asList(null_talisman);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,null_talisman[i]));
                    buttons1[i].setTag(null_talisman[i]);
                }break;
            case "headdress":
                a = Arrays.asList(headdress);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,headdress[i]));
                    buttons1[i].setTag(headdress[i]);
                }break;
            case "veil_of_discord":
                a = Arrays.asList(veil_of_discord);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,veil_of_discord[i]));
                    buttons1[i].setTag(veil_of_discord[i]);
                }break;
            case "vanguard":
                a = Arrays.asList(vanguard);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,vanguard[i]));
                    buttons1[i].setTag(vanguard[i]);
                }break;
            case "sange":
                a = Arrays.asList(sange);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,sange[i]));
                    buttons1[i].setTag(sange[i]);
                }break;
            case "wraith_band":
                a = Arrays.asList(wraith_band);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,wraith_band[i]));
                    buttons1[i].setTag(wraith_band[i]);
                }break;
            case "bracer":
                a = Arrays.asList(bracer);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,bracer[i]));
                    buttons1[i].setTag(bracer[i]);
                }break;
            case "buckler":
                a = Arrays.asList(buckler);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,buckler[i]));
                    buttons1[i].setTag(buckler[i]);
                }break;
            case "aether_lens":
                a = Arrays.asList(aether_lens);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,aether_lens[i]));
                    buttons1[i].setTag(aether_lens[i]);
                }break;
            case "blade_mail":
                a = Arrays.asList(blade_mail);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,blade_mail[i]));
                    buttons1[i].setTag(blade_mail[i]);
                }break;
            case "yasha":
                a = Arrays.asList(yasha);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,yasha[i]));
                    buttons1[i].setTag(yasha[i]);
                }break;
            case "force_staff":
                a = Arrays.asList(force_staff);
                Collections.shuffle(a);
                for (int i = 0; i <6; i++){
                    buttons1[i].setImageResource(getImageId(this,force_staff[i]));
                    buttons1[i].setTag(force_staff[i]);

                }break;
        }


    }

    public  void startTime(){
        cancelTimer();
        cTimer=new CountDownTimer(countdownperiod+2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText((millisUntilFinished / 60000)+":"+(millisUntilFinished % 60000 / 1000));
                countdownperiod=millisUntilFinished;
            }

            @Override
            public void onFinish() {
                txtTimer.setText("Game Over");
                bgm.release();
                gameoverna();

            }
        };cTimer.start();
    }
    public  void minusTime(){
        cancelTimer();
        cTimer=new CountDownTimer(countdownperiod-2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText((millisUntilFinished / 60000)+":"+(millisUntilFinished % 60000 / 1000));
                countdownperiod=millisUntilFinished;
            }

            @Override
            public void onFinish() {

                txtTimer.setText("Game Over");
                gameoverna();
                bgm.release();
            }


        };cTimer.start();

    }
    void cancelTimer() {
        if (cTimer != null)
            cTimer.cancel();
    }
public void gameoverna(){
        String points=txtScore.getText().toString();
    Intent intent=new Intent(this,gameOver.class);
    intent.putExtra("Score",points);
    startActivity(intent);
    finish();

}



    public void setItem() {
        if(x==itemQuestion.length){
          randomItem();
          x=0;
        }
        txtLabel.setText(itemQuestion[x]);
        x++;
        String text;
        text = txtLabel.getText().toString();
        imgQuest.setImageResource(getImageId(this, text));

    }
        public void randomItem(){
            List<String> l = Arrays.asList(itemQuestion);
            Collections.shuffle(l);

    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    public void enableButton(){
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);

    }
    public void screenTapped(View view){
    if (t==0){
        t=1;
        startTime();
    }


    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        cancelTimer();
        startActivity(intent);
        bgm.release();
        finish();
    }
}
