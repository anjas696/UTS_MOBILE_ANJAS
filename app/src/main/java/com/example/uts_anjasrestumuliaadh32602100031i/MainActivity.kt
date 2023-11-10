package com.example.uts_anjasrestumuliaadh32602100031i

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata: RecyclerView
    private val list = ArrayList<Destination>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)
        list.addAll(getListWisata())
        showRecyclerList()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getListWisata(): ArrayList<Destination> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataKeterangan = resources.getStringArray(R.array.data_keterangan)  // Tambahkan ini

        val listDestination = ArrayList<Destination>()
        for (i in dataName.indices) {
            val destination = Destination(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),dataKeterangan[i]) // Tambahkan keterangan)
            listDestination.add(destination)
        }
        return listDestination
    }

    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val listDestinationAdapter = ListDestinationAdapter(list)
        rvWisata.adapter = listDestinationAdapter

        listDestinationAdapter.setOnItemClickCallback(object : ListDestinationAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Destination) {
                val detailIntent = Intent(this@MainActivity, ActivityDetail::class.java)
                detailIntent.putExtra("photo", data.photo)
                detailIntent.putExtra("title", data.name)
                detailIntent.putExtra("description", data.description)
                detailIntent.putExtra("keterangan", data.keterangan) // Tambahkan baris ini
                //detailIntent.putExtra("keterangan", data.keterangan)
                startActivity(detailIntent)
            }
        })
    }

}