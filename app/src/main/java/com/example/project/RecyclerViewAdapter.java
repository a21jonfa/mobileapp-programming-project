package com.example.project;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.RecyclerViewItem;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<OpenNightItem> items;
    private final LayoutInflater layoutInflater;
    //private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<OpenNightItem> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        //this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getID());
        holder.ocassion.setText(items.get(position).getOccasion());
        holder.theme.setText(items.get(position).getTheme());
        holder.times.setText(items.get(position).getTimes());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView ocassion;
        TextView theme;
        TextView times;

        ViewHolder(View itemView) {
            super(itemView);
//              itemView.setOnClickListener(this);
                title = itemView.findViewById(R.id.id);
                ocassion = itemView.findViewById(R.id.occasion);
                theme = itemView.findViewById(R.id.theme);
                times = itemView.findViewById(R.id.times);
        }

//        @Override
//        public void onClick(View view) {
//            onClickListener.onClick(items.get(getAdapterPosition()));
//        }
    }

//    public interface OnClickListener {
//        void onClick(RecyclerViewItem item);
//    }
}