package com.example.roado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class mechlog extends AppCompatActivity {
    Button login;
    EditText eml, pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mechlog);
        login = findViewById(R.id.log);
        eml = findViewById(R.id.emailadd);
        pas = findViewById(R.id.pass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "rahulkotian2021@gmail.com";
                String password = "rrr@1234";

                String enteredEmail = eml.getText().toString().trim();
                String enteredPass = pas.getText().toString().trim();

                if (enteredEmail.equals(name) && enteredPass.equals(password)) {
                    Toast.makeText(mechlog.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mechlog.this, addmech.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(mechlog.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}