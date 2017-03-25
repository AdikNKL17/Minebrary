package com.addev.mysqlmelodic.minebrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Daftar extends AppCompatActivity {

    EditText namaDepan, namaBelakang, email, password;
    Button buttonDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        namaDepan = (EditText)findViewById(R.id.nama_depan);
        namaBelakang = (EditText)findViewById(R.id.nama_belakang);
        email = (EditText)findViewById(R.id.email);
        buttonDaftar = (Button)findViewById(R.id.button_daftar);

        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Daftar.this, "Daftar Berhasil", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Daftar.this, Splash.class);
                startActivity(intent);
            }
        });
    }
}
