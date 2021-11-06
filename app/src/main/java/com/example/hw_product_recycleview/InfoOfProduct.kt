package com.example.hw_product_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.adapter.ItemAdapter
import com.example.hw_product_recycleview.data.Datasource
import com.example.hw_product_recycleview.databinding.ActivityMainBinding
import com.example.hw_product_recycleview.databinding.ActivityInfoOfProductBinding

class InfoOfProduct : AppCompatActivity() {
    // for get view from Activity InfoOfProduct by id
    lateinit var LinkXML: ActivityInfoOfProductBinding // to initializes LinkXML in future time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_of_product)


        LinkXML = ActivityInfoOfProductBinding.inflate(layoutInflater)  // initializes the binding object
        setContentView(LinkXML.root) // get root of XML

        // is get from ItemAdapter class, on onBindViewHolder function by using button
        val intentImage = intent.extras?.getInt("phone_Image")
        val intentName = intent.extras?.getString("nameOfProduct")

        LinkXML.nameOfProduct.text = intentName
        LinkXML.phoneImage.setImageResource(intentImage!!)


    }
}