package com.example.roado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class addmech extends AppCompatActivity {
EditText name,type,phn,location,charge,discription;
Button add,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmech);
        name=findViewById(R.id.nametxt);
        type=findViewById(R.id.typetxt);
        phn=findViewById(R.id.phntxt);
        location=findViewById(R.id.loctxt);
        charge=findViewById(R.id.chargetxt);
        discription=findViewById(R.id.distxt);
        add=findViewById(R.id.btnAdd);
        back=findViewById(R.id.btnBack);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void insertData(){
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("type",type.getText().toString());
        map.put("phn",phn.getText().toString());
        map.put("location",location.getText().toString());
        map.put("charge",charge.getText().toString());
        map.put("discription",discription.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("mechanic").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(addmech.this, "Data Inserted Successfully ", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(addmech.this, "Error Wile Insertion", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void clearAll()
    {
        name.setText("");
        type.setText("");
        phn.setText("");
        location.setText("");
        charge.setText("");
        discription.setText("");
    }
}