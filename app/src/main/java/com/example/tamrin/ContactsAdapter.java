package com.example.tamrin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private String[] contacts=new String[2];
    public ContactsAdapter(){
        contacts[0]="hossein kondorie";
        contacts[1]="ali rezaii";
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
    holder.bindContact(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
private TextView firstCharacterTv;
private TextView fullnameTv;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView); 
            firstCharacterTv=itemView.findViewById(R.id.tv_contact_firstCharacter);
            fullnameTv=itemView.findViewById(R.id.tv_contact_fullname);
        }

        public void bindContact(String fullname){
            fullnameTv.setText(fullname);

            firstCharacterTv.setText(fullname.substring(0,1));
        }
    }
}
