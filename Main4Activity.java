package com.example.vijay.train;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Main4Activity extends AppCompatActivity {
    Integer[] images={R.drawable.coim,R.drawable.madurai,R.drawable.salem,R.drawable.ic_launcher};
    int i=0;
    Button pre,next;
    ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button but4, but5,but6;
        but4 = (Button) findViewById(R.id.button12);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent to = new Intent(Main4Activity.this,Main10Activity.class);

                startActivity(to);
            }
        });
        but5 = (Button) findViewById(R.id.button13);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent to = new Intent(Main4Activity.this, Main11Activity.class);

                startActivity(to);
            }
        });
        but6 = (Button) findViewById(R.id.button14);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent to = new Intent(Main4Activity.this, Main15Activity.class);

                startActivity(to);
            }
        });
        imageSwitcher=(ImageSwitcher)findViewById(R.id.image);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        Animation in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in);
        Animation out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.out);

        imageSwitcher.setAnimation(in);
        imageSwitcher.setAnimation(out);

        pre=(Button)findViewById(R.id.button15);
        next=(Button)findViewById(R.id.button16);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i >0 ){
                    i--;
                    imageSwitcher.setImageResource(images[i]);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i < images.length-1 ){
                    i++;
                    imageSwitcher.setImageResource(images[i]);
                }
            }
        });
    }
}
