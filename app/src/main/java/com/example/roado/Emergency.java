package com.example.roado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Emergency extends AppCompatActivity {
ImageView img1,img2,img3,img4;
TextView nearHP,nearPL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);
        img4=(ImageView) findViewById(R.id.img4);
        nearHP=(TextView) findViewById(R.id.nearHP);
        nearPL=(TextView) findViewById(R.id.nearPL);

        img1.setOnClickListener(new View.OnClickListener() {
            Context context=img1.getContext();

            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(img1.getContext());
                builder.setTitle("HOSPITAL EMERGENCY SERVICES ---!");
                builder.setMessage("CONTACT HOSPITAL BY CALL OR SMS----!.");

                builder.setPositiveButton("call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String phone="108";

                        //implementing phone call using Intent
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        context.startActivity(intent);

                    }
                });

                builder.setNegativeButton("sms", new DialogInterface.OnClickListener() {
                    String phoneNumber="108";
                    String message="Its an Emergency plz send Ambulence";
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:" + phoneNumber));
                        intent.putExtra("sms_body", message);
                        context.startActivity(intent);
                    }
                });
                builder.show();
            }
        });

        nearHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
            private void openMap() {
                Uri uri = Uri.parse("geo:0,0?q=Nearest Hospital");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        nearPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
            private void openMap() {
                Uri uri = Uri.parse("geo:0,0?q=Nearest Police Station");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            Context context1=img2.getContext();

            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(img2.getContext());
                builder.setTitle("POLICE SERVICE ---!");
                builder.setMessage("CONTACT POLICE BY CALL OR SMS----!.");

                builder.setPositiveButton("call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String phone="100";

                        //implementing phone call using Intent
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        context1.startActivity(intent);

                    }
                });

                builder.setNegativeButton("sms", new DialogInterface.OnClickListener() {
                    String phoneNumber="100";
                    String message="EMERGENCY PLEASE HELP";
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:" + phoneNumber));
                        intent.putExtra("sms_body", message);
                        context1.startActivity(intent);
                    }
                });
                builder.show();
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            Context context1=img3.getContext();

            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(img3.getContext());
                builder.setTitle("FIRE ENGINE SERVICE ---!");
                builder.setMessage("CONTACT FIRE ENGINE BY CALL OR SMS----!.");

                builder.setPositiveButton("call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String phone="101";

                        //implementing phone call using Intent
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        context1.startActivity(intent);

                    }
                });

                builder.setNegativeButton("sms", new DialogInterface.OnClickListener() {
                    String phoneNumber="101";
                    String message="EMERGENCY PLEASE HELP";
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:" + phoneNumber));
                        intent.putExtra("sms_body", message);
                        context1.startActivity(intent);
                    }
                });
                builder.show();
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            Context context1=img4.getContext();

            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(img3.getContext());
                builder.setTitle("WOMEN HELPLINE SERVICE ---!");
                builder.setMessage("CONTACT WOMEN_HELPLINE BY CALL OR SMS----!.");

                builder.setPositiveButton("call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String phone="1019";

                        //implementing phone call using Intent
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        context1.startActivity(intent);

                    }
                });

                builder.setNegativeButton("sms", new DialogInterface.OnClickListener() {
                    String phoneNumber="1019";
                    String message="EMERGENCY PLEASE HELP";
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:" + phoneNumber));
                        intent.putExtra("sms_body", message);
                        context1.startActivity(intent);
                    }
                });
                builder.show();
            }
        });

    }
}