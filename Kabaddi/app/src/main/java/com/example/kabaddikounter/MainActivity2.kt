package com.example.kabaddikounter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kabaddikounter.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        binding.StartButton.setOnClickListener {
            val teamAName = binding.teamANameInput.text.toString()
            val teamBName = binding.teamBNameInput.text.toString()

            if (teamAName.isNotEmpty() && teamBName.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("TEAM_A_NAME", teamAName)
                    putExtra("TEAM_B_NAME", teamBName)
                }
                startActivity(intent)
            } else {
                binding.teamANameInput.error = "Please enter Team A name"
                binding.teamBNameInput.error = "Please enter Team B name"
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
