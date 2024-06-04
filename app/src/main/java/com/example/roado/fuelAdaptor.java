package com.example.roado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class fuelAdaptor  extends FirebaseRecyclerAdapter<fviewmodel,fuelAdaptor.myViewHolder>{
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public fuelAdaptor(@NonNull FirebaseRecyclerOptions<fviewmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder,int position, @NonNull fviewmodel model) {
        holder.type.setText(model.gettype());
        holder.qty.setText(model.getqty());
        holder.phn.setText(model.getphn());
        holder.add.setText(model.getadd());
        holder.amount.setText(model.getamount());

//
//        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.add.getContext())
//                        .setContentHolder(new ViewHolder(R.layout.update_popup))
//                        .setExpanded(true,900)
//                        .create();
//dialogPlus.show();
//            }
//        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.type.getContext());
                builder.setTitle("Are you Sure ---!");
                builder.setMessage("Deleted data can't be Undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("fuel")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.type.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.name_item,parent,false);
        return new myViewHolder(view);

    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView type,qty,phn,add,amount;

        Button btnEdit,btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            type=(TextView) itemView.findViewById(R.id.typetxt);
            qty=(TextView) itemView.findViewById(R.id.qtytxt);
            phn=(TextView) itemView.findViewById(R.id.phntxt);
            add=(TextView) itemView.findViewById(R.id.addtxt);
            amount=(TextView) itemView.findViewById(R.id.amounttxt);

            btnEdit=(Button) itemView.findViewById(R.id.btnUpdate);
            btnDelete=(Button) itemView.findViewById(R.id.deletedata);

        }
    }
}
