package com.example.viveragrofinal.adapter;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.viveragrofinal.R;

public class OrderViewHolder extends RecyclerView.ViewHolder{
    public TextView tvNome;
    public TextView produtor;
    public TextView avaliacao;
    public ImageView img;
    public OrderViewHolder(View itemView) {
        super(itemView);
        tvNome = (TextView)itemView.findViewById(R.id.nome);
        avaliacao = (TextView)itemView.findViewById(R.id.avaliacao);
        produtor = (TextView)itemView.findViewById(R.id.produtor);
        img = (ImageView) itemView.findViewById(R.id.imageView2);
    }
}