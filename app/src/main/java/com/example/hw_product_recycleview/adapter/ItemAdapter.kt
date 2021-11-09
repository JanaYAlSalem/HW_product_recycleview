package com.example.hw_product_recycleview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.MainActivity
import com.example.hw_product_recycleview.ProductListFragmentDirections
import com.example.hw_product_recycleview.model.product // need to import af class
import com.example.hw_product_recycleview.R

class ItemAdapter (private val dataset: List<product>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // sup class of ItemAdapter
    class ItemViewHolder(  view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.phone_Image) // place of image Phone on list item
        val textViewName: TextView = view.findViewById(R.id.nameOfProduct) // place of name on list item
        val textViewPrice: TextView = view.findViewById(R.id.priceOfProduct) // // place of price on list item
        val favoriteIcon: ImageView = view.findViewById(R.id.favoriteIcon) // place of favorite Icon on list item
        val buttoninfoProduct: Button = view.findViewById(R.id.buyButton) // place of button on list item
    } // end ItemViewHolder :in line on ItemAdapter class


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        // item is a af(the type of list) datatype
        // the holder is will be show on the screen

        val item = dataset[position]
        //Toast.makeText(context, "${dataset.size}", Toast.LENGTH_SHORT).show()


        // (ImgResourceId,NameResourceId,PriceResourceId,isVipResourceId,quantityNumberResourceId)

        // imageView -> initializes on ItemViewHolder class, ImgResourceId is a constructor on af class
        holder.imageView.setImageResource(item.ImgResourceId)

        // textViewName -> initializes on ItemViewHolder class, NameResourceId is a constructor on af class
        holder.textViewName.text = item.NameResourceId

        // textViewPrice -> initializes on ItemViewHolder class, PriceResourceId is a constructor on af class
        holder.textViewPrice.text = item.PriceResourceId

        // favoriteIcon -> initializes on ItemViewHolder class, if statement is given false / ture
        // when if statement = false the favorite Icon is hidden, or ture for show the favorite Icon
        holder.favoriteIcon.isVisible = if (item.isVipResourceId ) { true } else {false}



        /**
        * open next page
        val context = holder.view.context
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("letter", holder.button.text.toString())
        context.startActivity(intent)
         * Switch to
        val action = ProductListFragmentDirections.actionProductListFragmentToInfoOfProductFragment2(
        phoneImage = item.ImgResourceId,
        nameOfProduct = item.NameResourceId)
        holder.itemView.findNavController().navigate(action)
         */

        holder.buttoninfoProduct.setOnClickListener {
            if (item.quantityNumberResourceId > 0) {
            val action = ProductListFragmentDirections.actionProductListFragmentToInfoOfProductFragment2(
                phoneImage = item.ImgResourceId,
                nameOfProduct = item.NameResourceId)

                holder.itemView.findNavController().navigate(action)
            } else {
                 Toast.makeText(holder.itemView.context, "Sorry, the product is not available right now", Toast.LENGTH_LONG).show() }

        }

    }

    override fun getItemCount(): Int {
           return dataset.size
    } // Start ItemAdapter abstract class with 3 funs ->hava a ItemViewHolder class


}