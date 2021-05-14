package com.example.room_a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AdapterViewHolder> {

    private Context context;
    private List<User> list;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<User> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        User user = list.get(position);
        if(user == null)
            return;
        holder.name.setText(user.getUserName());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("name", user.getUserName().trim());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list != null)
             return list.size();
        return 0;
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
        }
    }
}
