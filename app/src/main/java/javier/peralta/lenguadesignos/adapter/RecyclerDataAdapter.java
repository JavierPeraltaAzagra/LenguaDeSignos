package javier.peralta.lenguadesignos.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javier.peralta.lenguadesignos.R;
import javier.peralta.lenguadesignos.clase.Signo;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder>{
    private List<Signo> list;
    private OnItemClickListener listener;

    public RecyclerDataAdapter(List<Signo> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        holder.assignData(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void assignData(Signo signo, OnItemClickListener listener) {
            textView.setText(signo.getTitulo());
            imageView.setImageResource(signo.getImagen());
            imageView.setBackgroundResource(R.drawable.borde);
            textView.setBackgroundResource(R.drawable.borde);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(signo.getTitulo(), signo.getImagen(),getAdapterPosition());
                }
            });
        }
    }
     public interface OnItemClickListener{
        void onItemClick(String titulo, int imagen, int position);

    }
}