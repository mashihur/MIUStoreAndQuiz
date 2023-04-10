package com.example.miustoreandquiz.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.miustoreandquiz.R
import com.example.miustoreandquiz.databinding.ActivityQuizAppBinding
import java.text.SimpleDateFormat
import java.util.*

class QuizAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
            submit()
        }
        binding.btnReset.setOnClickListener {
            reset()
        }
    }

    private fun submit() {
        var result = 0
        if (binding.rbQuestion1Answer1.isChecked) {
            result += POINTS_PER_CORRECT_ANSWER
        }
        if (binding.cbQuestion2Answer1.isChecked && binding.cbQuestion2Answer2.isChecked && binding.cbQuestion2Answer3.isChecked.not()) {
            result += POINTS_PER_CORRECT_ANSWER
        }
        val currentDateAndTime = SimpleDateFormat(DATE_TIME_PATTERN, Locale.getDefault())
            .format(Calendar.getInstance().time)
        AlertDialog.Builder(this)
            .setMessage(getString(R.string.quiz_msg_submitted, currentDateAndTime, "$result%"))
            .setPositiveButton(getString(R.string.OK)) { _, _ -> }
            .show()
    }

    private fun reset() {
        with(binding) {
            rgQuestion1Answers.clearCheck()
            listOf(cbQuestion2Answer1, cbQuestion2Answer2, cbQuestion2Answer3).forEach {
                it.isChecked = false
            }
        }
    }

    companion object {
        private const val POINTS_PER_CORRECT_ANSWER = 50
        private const val DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss"
    }
}