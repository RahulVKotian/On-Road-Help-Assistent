package com.example.roado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roado.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        FirebaseAuth auth;
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(LoginActivity.this, home.class);
            startActivity(intent);
        }


        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);;

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.emailaddress.getText().toString().trim();
                String pass=binding.password.getText().toString().trim();
                progressDialog.show();
                firebaseAuth.signInWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                progressDialog.cancel();
                                Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this,home.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        binding.resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.emailaddress.getText().toString();
                progressDialog.setTitle("Sending Mail");
                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.cancel();
                                Toast.makeText(LoginActivity.this, "Emial Sent", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        binding.goToSignUpActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }
}