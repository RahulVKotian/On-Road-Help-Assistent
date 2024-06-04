package com.example.roado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class Mech extends AppCompatActivity {
Button addmech,contact;
ImageView btn_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech);
        addmech=findViewById(R.id.addinfo);
        contact=findViewById(R.id.contactmech);
        btn_map=findViewById(R.id.goget);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }

            private void openMap() {
                Uri uri = Uri.parse("geo:0,0?q=mechanical Station");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        addmech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(addmech.getContext());
                builder.setTitle("Are you Sure ---!");
                builder.setMessage("You are a MECHANIC----!.");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Mech.this, mechlog.class);
                        startActivity(intent);

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(addmech.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mech.this, contackMech.class);
                startActivity(intent);
            }
        });
    }
}