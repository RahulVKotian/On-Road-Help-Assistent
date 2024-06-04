package com.example.roado;

import static com.example.roado.R.*;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class viewFuel extends AppCompatActivity {

    RecyclerView recyclerView;
    fuelAdaptor fueladaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_view_fuel);


        recyclerView=(RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<fviewmodel> options =
                new FirebaseRecyclerOptions.Builder<fviewmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("fuel"), fviewmodel.class)
                        .build();

        fueladaptor =new fuelAdaptor(options);
        recyclerView.setAdapter(fueladaptor);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fueladaptor.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        fueladaptor.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item=menu.findItem(id.search);
        SearchView searchView=(SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str){
        FirebaseRecyclerOptions<fviewmodel> options =
                new FirebaseRecyclerOptions.Builder<fviewmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("fuel").orderByChild("type").startAt(str).endAt(str+"~"), fviewmodel.class)
                        .build();
        fueladaptor=new fuelAdaptor(options);
        fueladaptor.startListening();
        recyclerView.setAdapter(fueladaptor);

    }
}