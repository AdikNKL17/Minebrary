package com.addev.mysqlmelodic.minebrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    TextView logo, tag;
    Button button_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (TextView)findViewById(R.id.logo);
        tag = (TextView)findViewById(R.id.tag);
        button_go = (Button) findViewById(R.id.button_go);

        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
