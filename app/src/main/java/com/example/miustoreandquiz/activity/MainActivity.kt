package com.example.miustoreandquiz.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miustoreandquiz.R
import com.example.miustoreandquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnQuiz.setOnClickListener {
            startActivity(Intent(this, QuizAppActivity::class.java))
        }

        binding.btnShopCategory.setOnClickListener {
            startActivity(Intent(this, ShoppingCategoryActivity::class.java))
        }
    }
}