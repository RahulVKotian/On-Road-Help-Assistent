package com.example.roado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class contackMech extends AppCompatActivity {
RecyclerView recyclerView;
ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contack_mech);
        recyclerView=(RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<contactModel> options =
                new FirebaseRecyclerOptions.Builder<contactModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("mechanic"), contactModel.class)
                        .build();
        contactAdapter=new ContactAdapter(options);
        recyclerView.setAdapter(contactAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        contactAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        contactAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item=menu.findItem(R.id.search);
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
    private void txtSearch(String str)
    {
        FirebaseRecyclerOptions<contactModel> options =
                new FirebaseRecyclerOptions.Builder<contactModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("mechanic").orderByChild("type").startAt(str).endAt(str+"~"), contactModel.class)
                        .build();
        contactAdapter=new ContactAdapter(options);
        contactAdapter.startListening();
        recyclerView.setAdapter(contactAdapter);
    }
}