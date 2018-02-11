package com.example.vijay.train;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main16Activity extends AppCompatActivity {
    Button button,button2,button3,button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        button = (Button) findViewById(R.id.button23);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String ph="7373812345";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",ph, null)));
            }
        });
        button2 = (Button) findViewById(R.id.button22);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String pho="04224050607";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",pho, null)));
            }
        });
        button3 = (Button) findViewById(R.id.button21);

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg1) {
                String phn="04222888999";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phn, null)));

            }
        });
        button4 = (Button) findViewById(R.id.button20);

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg2) {
                String phe="04224747474";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phe, null)));

            }
        });
        button5 = (Button) findViewById(R.id.button19);

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg3) {
                String php="9842320991";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",php, null)));

            }
        });


    }
}
