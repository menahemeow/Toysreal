package com.example.toys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Toy;
import com.example.model.Toys;

import java.text.BreakIterator;

public class ToysAdapter extends RecyclerView.Adapter<ToysAdapter.ToysHolder> {

    private Context context;
    private Toys toys;
    private int single_toy_layout;
    private BreakIterator txtName;
    private BreakIterator txtPrice;
    private View itemView;

    public  ToysAdapter (Context context, Toys toys, int single_toy_layout){
        this.context = context;
        this.toys = toys;
        this.single_toy_layout = single_toy_layout;

        this.listener = listener;
        this.longListener = longListener;
    }
    @NonNull
    @Override
    public ToysAdapter.ToysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToysHolder(LayoutInflater.from(context).inflate(single_toy_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToysAdapter.ToysHolder holder, int position) {

        Toy toy = toys.get(position);

        if(toy != null){
            holder.nameText.setText(toy.getName());
            holder.priceText.setText((String.valueOf(toy.getPrice())));

        }
    }

    public void bind(Toy toy, OnItemClickListener listener,
                     OnItemLongClickListener longListener){

        txtName.setText(toy.getName());
        txtPrice.setText(toy.getPrice()+"");
        // ivPicture.setImageBitmap(toy.getPicture());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(toy);
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener()

        {
            @Override
            public boolean onLongClick(View v) {
                longListener.onItemLongClicked(toy);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (toys == null) ? 0 : toys.size();
    }

    public  static class ToysHolder extends RecyclerView.ViewHolder {

        public TextView nameText;
        public TextView priceText;

        public ToysHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.nameText);
            priceText = itemView.findViewById(R.id.priceText);
        }
    }

    private OnItemClickListener listener;
    private OnItemLongClickListener longListener;

    public interface OnItemClickListener {
        public void onItemClicked(Toy toy);

        void onItemClicked();
    }
    public interface OnItemLongClickListener {
        public boolean onItemLongClicked(Toy toy);

        boolean onItemLongClicked();
    }
}
