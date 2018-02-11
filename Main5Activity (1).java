package com.example.vijay.train;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button but4, but5;
        but4 = (Button) findViewById(R.id.button17);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent to = new Intent(Main5Activity.this, Main12Activity.class);

                startActivity(to);
            }
        });


    }
}
