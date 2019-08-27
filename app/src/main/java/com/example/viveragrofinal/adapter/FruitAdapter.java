package com.example.viveragrofinal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.viveragrofinal.R;
import com.example.viveragrofinal.auxiliares.RecyclerViewOnClickListenerHack;
import com.example.viveragrofinal.domain.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder>{
    private List<Fruit> list;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListenerHack recyclerViewOnClickListenerHack;

    public FruitAdapter(Context c, List<Fruit> l){
        list = l;
        layoutInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LOG","oscreateviewholder");
        View view = layoutInflater.inflate(R.layout.item_classe,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        recyclerViewOnClickListenerHack = r;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i("com.app.redes.turismorr","onbindviewholder");

       // holder.image.setImageResource(list.get(position).getImg());
        if(list.get(position).getLook() > 0){
            holder.image.setImageResource(list.get(position).getImgColor());
        }else{
            holder.image.setImageResource(list.get(position).getImg());
        }
        // holder.image.setImageResource(list.get(position).getLook());
    }

    @Override
    public int getItemCount() {
        try{
            return list.size();
        }
        catch (Exception e){

        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image ;
        public RelativeLayout layout ;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(recyclerViewOnClickListenerHack != null){
                recyclerViewOnClickListenerHack.onClickListener(view, getPosition());
            }
        }
    }
}
