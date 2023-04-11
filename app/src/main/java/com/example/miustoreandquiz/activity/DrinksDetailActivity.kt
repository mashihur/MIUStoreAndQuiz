package com.example.miustoreandquiz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miustoreandquiz.databinding.ActivityDrinksDetailBinding
import com.example.miustoreandquiz.helper.Constants
import com.example.miustoreandquiz.helper.Product

class DrinksDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDrinksDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrinksDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.hasExtra(Constants.INTENT_KEY) && intent.hasExtra(Constants.INTENT_KEY2)) {
            val product = intent.getSerializableExtra(Constants.INTENT_KEY) as Product
            binding.name.text = product.title + "\n" + "Price: " + product.price + "\n" + product.id
            binding.desc.text = product.desc
            binding.imageView.setImageResource(intent.getIntExtra(Constants.INTENT_KEY2, 0))
        }
    }
}