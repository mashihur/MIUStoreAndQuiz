package com.example.miustoreandquiz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miustoreandquiz.databinding.ActivityDrinksDetailBinding

class DrinksDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDrinksDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrinksDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.hasExtra("image") && intent.hasExtra("name") && intent.hasExtra("detail")) {
            var ig = intent.getIntExtra("image", 0)
            var t1 = intent.getStringExtra("name")
            var t2 = intent.getStringExtra("detail")
            binding.name.text = t1.toString()
            binding.desc.text = t2.toString()
            binding.imageView.setImageResource(ig)
        }
    }
}