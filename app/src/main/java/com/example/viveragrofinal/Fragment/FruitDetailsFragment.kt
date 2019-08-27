package com.example.viveragrofinal.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viveragrofinal.MainActivity
import com.example.viveragrofinal.R
import com.example.viveragrofinal.adapter.OrderAdapter
import com.example.viveragrofinal.auxiliares.LibraryClass
import com.example.viveragrofinal.domain.Fruit
import com.example.viveragrofinal.domain.Produto
import com.firebase.client.Firebase
import kotlinx.android.synthetic.main.fruitdetails.*
import kotlinx.android.synthetic.main.fruitdetails.view.*

class FruitDetailsFragment : Fragment() {
    private var produto: Produto? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fruitdetails, container, false)
        //O app cria as listas usando o Recycler View
        produto = Produto()
        produto = (activity as MainActivity).getProdutos()
        view.nome.setText(produto!!.nome)
        Glide
            .with(activity as MainActivity)
            .load(produto!!.img)
            .centerCrop()
            .placeholder(R.drawable.banana)
            .into(view.image)
        return view
    }

    override fun onResume() {
        super.onResume()


    }

}