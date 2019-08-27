package com.example.viveragrofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viveragrofinal.Fragment.FruitDetailsFragment
import com.example.viveragrofinal.Fragment.OrderFragment
import com.example.viveragrofinal.adapter.FruitAdapter
import com.example.viveragrofinal.auxiliares.RecyclerViewOnClickListenerHack
import com.example.viveragrofinal.domain.Fruit
import com.example.viveragrofinal.domain.Produto
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), RecyclerViewOnClickListenerHack {
    private var recyclerView: RecyclerView? = null
    private var list: List<Fruit>? = null
    private var tips: Fruit? = null
    private var produto: Produto? = null
    private var adapter: FruitAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        list = pedidos()

        if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("produto") != null) {
            produto = intent.extras!!.getParcelable<Produto>("produto")

            var frag: FruitDetailsFragment? = supportFragmentManager.findFragmentByTag("mainFrag") as? FruitDetailsFragment
            if (frag == null) {
                frag = FruitDetailsFragment()
                Log.i("TAG", "fragment")
                val ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.rl_fragment_container, frag, "mainFrag")
                ft.commit()
            }
        }

        recyclerView = findViewById(R.id.plant_list)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        adapter = FruitAdapter(this, list)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.HORIZONTAL

        recyclerView!!.layoutManager = llm
        recyclerView!!.setLayoutManager(llm)

        adapter!!.setRecyclerViewOnClickListenerHack(this)
        recyclerView!!.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return true
    }

    fun getProdutos(): Produto{
        return this!!.produto!!
    }


    fun pedidos(): List<Fruit> {
        val listAux = ArrayList<Fruit>()
        val tips = Fruit()
        tips.setImg(R.drawable.cornnn)
        tips.look = 0
        tips.imgColor = R.drawable.cornnn
        listAux.add(tips)
        val tips2 = Fruit()
        tips2.look = 0
        tips2.setImg(R.drawable.bananacolor)
        tips2.imgColor = R.drawable.bananacolor
        listAux.add(tips2)
        val tips3 = Fruit()
        tips3.setImg(R.drawable.carrotcolor)
        tips3.look = 0
        tips3.imgColor = R.drawable.carrotcolor
        listAux.add(tips3)
        val tips4 = Fruit()
        tips4.imgColor = R.drawable.cauliflowercolor
        tips4.look = 0
        tips4.setImg(R.drawable.cauliflowercolor)
        listAux.add(tips4)
        val tips5 = Fruit()
        tips5.imgColor = R.drawable.avocadocolor
        tips5.look = 0
        tips5.setImg(R.drawable.avocadocolor)
        listAux.add(tips5)
        val tips6 = Fruit()
        tips6.imgColor = R.drawable.lettucecolor
        tips6.look = 0
        tips6.setImg(R.drawable.lettucecolor)
        listAux.add(tips6)
        return listAux
    }

    override fun onClickListener(view: View, position: Int) {
        if(list!!.get(position)!!.look > 0){
            list!!.get(position)!!.look = 0
        }else{
            list!!.get(position)!!.look = 1
        }
        var frag: OrderFragment? = supportFragmentManager.findFragmentByTag("mainFrag") as? OrderFragment
        if (frag == null) {
            frag = OrderFragment()
            Log.i("TAG", "fragment")
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag")
            ft.commit()
        }
    }
}
