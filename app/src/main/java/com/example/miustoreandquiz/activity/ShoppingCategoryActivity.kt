package com.example.miustoreandquiz.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miustoreandquiz.R
import com.example.miustoreandquiz.databinding.ActivityShoppingCategoryBinding
import com.example.miustoreandquiz.helper.Product

class ShoppingCategoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityShoppingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBooks.setOnClickListener {
            // Move to books screen
            var bookListIntent = Intent(this, BookListActivity::class.java)
            startActivity(bookListIntent)
        }

        binding.ivOrganic.setOnClickListener {
            // Move to drinks screen
            var products = ArrayList<Product>()
            val arrImages = resources.getStringArray(R.array.op_images);
            val arrTitles = resources.getStringArray(R.array.orgnic_products);
            val arrDetail = resources.getStringArray(R.array.op_details);
            val arrPrice = resources.getStringArray(R.array.op_prices);
            val arrIds = resources.getStringArray(R.array.op_ids)
            for (i in arrImages.indices) {
                products.add(Product(arrTitles[i], arrIds[i], arrPrice[i], arrImages[i], arrDetail[i]))
            }
            val intent = Intent(this, DrinksActivity::class.java)
            intent.putExtra("products", products as java.io.Serializable)
            startActivity(intent)
        }
    }
}