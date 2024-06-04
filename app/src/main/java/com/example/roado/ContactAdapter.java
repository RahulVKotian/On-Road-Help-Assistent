package com.example.roado;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.security.AccessController;

public class ContactAdapter extends FirebaseRecyclerAdapter<contactModel,ContactAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ContactAdapter(@NonNull FirebaseRecyclerOptions<contactModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull contactModel model) {

        Context context=holder.itemView.getContext();


        holder.name.setText(model.getName());
        holder.phn.setText(model.getPhn());
        holder.type.setText(model.getType());
        holder.charge.setText(model.getCharge());
        holder.dis.setText(model.getDiscription());

        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone=model.getPhn();

                //implementing phone call using Intent
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                context.startActivity(intent);

            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView name,charge,phn,dis,type;

        Button btnCall;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nametxt);
            phn = (TextView) itemView.findViewById(R.id.phntxt);
            charge = (TextView) itemView.findViewById(R.id.chargetxt);
            dis = (TextView) itemView.findViewById(R.id.distxt);
            type = (TextView) itemView.findViewById(R.id.typetxt);

            btnCall=(Button) itemView.findViewById(R.id.call);
        }
    }
}
