package com.example.roado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity {
    Button log;
    ImageView imageButton,imageButton1,imageButton5,imageButton6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        log=findViewById(R.id.Logout);
        imageButton=findViewById(R.id.imageView3);
        imageButton1=findViewById(R.id.imageView4);
        imageButton5=findViewById(R.id.imageView5);
        imageButton6=findViewById(R.id.imageView6);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth mAuth;

                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                startActivity(new Intent(home.this, LoginActivity.class));
                finish();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  orderFuel    viewFuel
                Intent intent = new Intent(home.this, fuelhome.class);
                startActivity(intent);  }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Mech.class);
                startActivity(intent);
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Emergency.class);
                startActivity(intent);
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this, RateUsDialog.class);
                startActivity(intent);
            }
        });
    }
}