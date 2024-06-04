package com.example.roado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class fuelhome extends AppCompatActivity {
    ImageView navigation_btn;
Button book,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuelhome);
       book=findViewById(R.id.buyfuel);
       view=findViewById(R.id.viewfuel);
        navigation_btn=findViewById(R.id.launch);
        navigation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }

            private void openMap() {
                Uri uri = Uri.parse("geo:0,0?q=fuel station");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
       book.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(fuelhome.this, orderFuel.class);
               startActivity(intent);
           }
       });
       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(fuelhome.this, viewFuel.class);
               startActivity(intent);
           }
       });
    }
}