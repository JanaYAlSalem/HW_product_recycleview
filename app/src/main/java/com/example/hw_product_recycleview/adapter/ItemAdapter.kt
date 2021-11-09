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
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.InfoOfProductFragment
import com.example.hw_product_recycleview.model.product // need to import af class
import com.example.hw_product_recycleview.R

class ItemAdapter (private val context:Context,
                   private val dataset: List<product>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()
{
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = itemView.findViewById(R.id.phone_Image) // place of image Phone on list item
        val textViewName: TextView = itemView.findViewById(R.id.nameOfProduct) // place of name on list item
        val textViewPrice: TextView = itemView.findViewById(R.id.priceOfProduct) // // place of price on list item
        val favoriteIcon: ImageView = itemView.findViewById(R.id.favoriteIcon) // place of favorite Icon on list item
        val buttoninfoProduct: Button = itemView.findViewById(R.id.buyButton) // place of button on list item
    } // end ItemViewHolder :in line on ItemAdapter class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        // create a new view:ItemViewHolder and return it on ****
        // view called a adapterLayout which is get from parent to list_item layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        // item is a af(the type of list) datatype
        // the holder is will be show on the screen
        val item = dataset[position]
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
        */
        holder.buttoninfoProduct.setOnClickListener {
            if (item.quantityNumberResourceId > 0) {
                // initializes intent for going to (InfoOfProduct)
                val intent = Intent(context, InfoOfProductFragment::class.java )
                // send value for Activity InfoOfProduct
                intent.putExtra("phone_Image", item.ImgResourceId )
                intent.putExtra("nameOfProduct", item.NameResourceId )
                it?.context?.startActivity(intent)
            } else { Toast.makeText(context, "Sorry, the product is not available right now", Toast.LENGTH_LONG).show() }

        }



    }

    override fun getItemCount(): Int {
           return dataset.size
    } // Start ItemAdapter abstract class with 3 funs ->hava a ItemViewHolder class


}