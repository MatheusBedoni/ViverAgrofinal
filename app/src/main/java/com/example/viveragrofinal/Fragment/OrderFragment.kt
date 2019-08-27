package com.example.viveragrofinal.Fragment

import android.content.Intent
import com.example.viveragrofinal.adapter.OrderAdapter
import com.example.viveragrofinal.adapter.OrderViewHolder
import com.example.viveragrofinal.auxiliares.LibraryClass
import com.example.viveragrofinal.domain.Produto
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viveragrofinal.MainActivity
import com.example.viveragrofinal.R

import com.example.viveragrofinal.domain.Fruit
import com.firebase.client.Firebase
import com.firebase.client.DataSnapshot
import com.firebase.client.ValueEventListener




class OrderFragment : Fragment() {


    private var recyclerView: RecyclerView? = null
    private var list: List<Fruit>? = null
    private var fruit: Fruit? = null
    private var adapter: OrderAdapter? = null
    private var firebase: Firebase? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_order, container, false)
        //O app cria as listas usando o Recycler View
        fruit = Fruit()
        firebase = LibraryClass.getFirebase().child("produto")
        recyclerView = view.findViewById(R.id.rv_list)
        recyclerView!!.setHasFixedSize(true)


        return view
    }

    override fun onResume() {
        super.onResume()
        recyclerView!!.setVisibility(View.VISIBLE)
        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.VERTICAL

        recyclerView!!.setLayoutManager(llm)
        init()
        recyclerView!!.setAdapter(adapter)

    }

    public fun init() {
        adapter = object : OrderAdapter(
            Produto::class.java,
            R.layout.item_order,
            OrderViewHolder::class.java,
            firebase) {
            protected override fun populateViewHolder(produtoresViewHolder: OrderViewHolder, produtor: Produto, i: Int) {
                super.populateViewHolder(produtoresViewHolder, produtor, i)
                produtoresViewHolder.tvNome.setText(produtor.nome)
                produtoresViewHolder.avaliacao.setText(produtor.avaliacao)
                produtoresViewHolder.produtor.setText(produtor.produtor)
                Log.i("LOG", "produto lista")
                Glide
                    .with(activity as MainActivity)
                    .load(produtor.img)
                    .centerCrop()
                    .placeholder(R.drawable.banana)
                    .into(produtoresViewHolder.img)

                produtoresViewHolder.itemView.setOnClickListener(View.OnClickListener {
                    activity!!.finish()
                    val intent = Intent(activity, MainActivity::class.java)
                    intent.putExtra("produto", produtor)
                    activity!!.startActivity(intent)
                })
            }
        }

    }


}