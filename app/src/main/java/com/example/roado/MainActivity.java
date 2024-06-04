package com.example.roado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.roado.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RateUsDialog rateUsDialog = new RateUsDialog(MainActivity.this);
        rateUsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        rateUsDialog.setCancelable(false);
        rateUsDialog.show();

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        progressDialog=new ProgressDialog(this);


        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=binding.fullname.getText().toString();
                String number=binding.phn.getText().toString();
                String mail=binding.emailaddress.getText().toString();
                String pass=binding.password.getText().toString();


                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(mail,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                                progressDialog.cancel();

                                firebaseFirestore.collection("User")
                                        .document(FirebaseAuth.getInstance().getUid())
                                        .set(new UserModel(name,number,mail));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();
                            }
                        });
            }
        });


        binding.goToSignInActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });


    }
}