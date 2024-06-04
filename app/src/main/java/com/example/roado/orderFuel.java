package com.example.roado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class orderFuel extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;
    EditText type,qty,phn,add,amount;
    //int maxid=0;
    double petrol=101.11;
    double diesel=87.11;
    double gas=78.59;
    Button btn;
    Button calcy;
    Fueldata fueldata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_fuel);

        type=findViewById(R.id.fueltype);
        qty=findViewById(R.id.fuelqty);
        phn=findViewById(R.id.phn);
        add=findViewById(R.id.address);
        btn = findViewById(R.id.odr);
        amount=findViewById(R.id.amount);
       calcy=findViewById(R.id.cal);
    calcy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String data=qty.getText().toString();
            String ft=type.getText().toString();
                if (ft.contains("petrol")) {
                    double frate = Double.parseDouble(data);
                    double res = frate * petrol;
                    amount.setText(String.valueOf(res));
                }


            if (ft.contains("diesel")) {
                double frate = Double.parseDouble(data);
                double res = frate * diesel;
                amount.setText(String.valueOf(res));
            }

            if (ft.contains("gas")) {
                double frate = Double.parseDouble(data);
                double res = frate * gas;
                amount.setText(String.valueOf(res));
            }
            else
            {
                Toast.makeText(orderFuel.this, "Enter the valid Fuel type", Toast.LENGTH_SHORT).show();
            }
        }
    });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });

//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
   }
    private void insertData(){
        Map<String,Object> map=new HashMap<>();
        map.put("type",type.getText().toString());
        map.put("qty",qty.getText().toString());
        map.put("phn",phn.getText().toString());
        map.put("add",add.getText().toString());
        map.put("amount",amount.getText().toString());
       FirebaseDatabase.getInstance().getReference().child("fuel").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(orderFuel.this, "Data Inserted Successfully ", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(orderFuel.this,ordersuccessfull.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(orderFuel.this, "Error Wile Insertion", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void clearAll()
    {
        type.setText("");
        qty.setText("");
        phn.setText("");
        add.setText("");
        amount.setText("");
    }
}





        //fueldata=new Fueldata();


//        ref=database.getInstance().getReference().child("Fuel");
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists())
//                {
//                    maxid=(int) snapshot.getChildrenCount();
//                }
//                else {
//                    //
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fueldata.setFtype(type.getText().toString());
//                fueldata.setFqty(qty.getText().toString());
//                fueldata.setFphn(phn.getText().toString());
//                fueldata.setFadd(add.getText().toString());
//
//                ref.child(String.valueOf(maxid+1)).setValue(fueldata);
//                startActivity(new Intent(orderFuel.this, ordersuccessfull.class));
//
//            }
//        });

//        calcy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String data=qty.getText().toString();
//                String ft=type.getText().toString();
//                if(ft=="petrol")
//                {
//                    double frate=Double.parseDouble(data);
//                    double res=frate*rate;
//                    amount.setText(String.valueOf(res));
//                }
//            }
//        });

    //}}