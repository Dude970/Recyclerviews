package com.example.widgets

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ManyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.many)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        // Enable the back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val items = listOf(
            MyItem(MyItemType.TYPE_ONE,"Layoutone",R.drawable.img_albumart),
            MyItem(MyItemType.TYPE_TWO,"Layouttwo",R.drawable.img_detroit_lions_rect),
            MyItem(MyItemType.TYPE_THREE,"LayoutThree",R.drawable.img_new_england_patroit_rect),
            MyItem(MyItemType.TYPE_ONE,"Layoutone",R.drawable.img_albumart),
            MyItem(MyItemType.TYPE_TWO,"Layouttwo",R.drawable.img_detroit_lions_rect),
            MyItem(MyItemType.TYPE_THREE,"LayoutThree",R.drawable.img_new_england_patroit_rect),
            MyItem(MyItemType.TYPE_ONE,"Layoutone",R.drawable.img_albumart),
            MyItem(MyItemType.TYPE_TWO,"Layouttwo",R.drawable.img_detroit_lions_rect),
            MyItem(MyItemType.TYPE_THREE,"LayoutThree",R.drawable.img_new_england_patroit_rect),
            MyItem(MyItemType.TYPE_ONE,"Layoutone",R.drawable.img_albumart),
            MyItem(MyItemType.TYPE_TWO,"Layouttwo",R.drawable.img_detroit_lions_rect),
            MyItem(MyItemType.TYPE_THREE,"LayoutThree",R.drawable.img_new_england_patroit_rect),
            MyItem(MyItemType.TYPE_ONE,"Layoutone",R.drawable.img_albumart),
            MyItem(MyItemType.TYPE_TWO,"Layouttwo",R.drawable.img_detroit_lions_rect),
            MyItem(MyItemType.TYPE_THREE,"LayoutThree",R.drawable.img_new_england_patroit_rect),
            MyItem(MyItemType.TYPE_ONE,"Layoutone",R.drawable.img_albumart),
            MyItem(MyItemType.TYPE_TWO,"Layouttwo",R.drawable.img_detroit_lions_rect),
            MyItem(MyItemType.TYPE_THREE,"LayoutThree",R.drawable.img_new_england_patroit_rect),
            MyItem(MyItemType.TYPE_ONE,"Layoutone",R.drawable.img_albumart)
            // Add more items as needed
        )

        val adapter = Many(items) {

            // Handle button click here
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }

}
