package com.example.miustoreandquiz.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miustoreandquiz.R
import com.example.miustoreandquiz.databinding.ActivityShoppingCategoryBinding

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
            startActivity(Intent(this, DrinksActivity::class.java))
        }
    }
}