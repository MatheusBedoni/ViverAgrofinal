package com.example.viveragrofinal.adapter;

import com.example.viveragrofinal.domain.Fruit;
import com.example.viveragrofinal.domain.Produto;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;

public class OrderAdapter extends FirebaseRecyclerAdapter<Produto,OrderViewHolder> {


    public OrderAdapter(Class<Produto> modelClass, int modelLayout, Class<OrderViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(OrderViewHolder orderViewHolder, Produto produto, int i) {

    }
}