package com.example.hw_product_recycleview.data

import com.example.hw_product_recycleview.R
import com.example.hw_product_recycleview.model.product

class Datasource {


fun loadProduct(): List<product> {
  return listOf<product>(
    // from product data class in model package
   // (ImgResourceId,NameResourceId,PriceResourceId,isVipResourceId,quantityNumberResourceId)
    product(R.drawable.iphone,"Iphone 12 64GB","4500 SR",true,5),
    product(R.drawable.samsung_galaxy_uitra,"Samsung Galaxy S21 Ultra","4500 SR",false,5),
    product(R.drawable.xiaomi_pro,"Xiaomi 11T Pro","2000 SR",true,0),
    product(R.drawable.huawei_yp,"Huawei Y6p","500 SR",false,0),
    product(R.drawable.samsung_galaxy_z_flip,"Samsung Galaxy Z Flip3","5000 SR",true,70),
    product(R.drawable.iphone13,"Iphone 13","6000 SR",true,36),
        )
    } // end fun
}