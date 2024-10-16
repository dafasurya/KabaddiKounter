package com.example.kabaddikounter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kabaddikounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Get team names from Intent
        val teamAName = intent.getStringExtra("TEAM_A_NAME")
        val teamBName = intent.getStringExtra("TEAM_B_NAME")

        // Set team names in UI
        binding.teamAName.text = teamAName
        binding.teamBName.text = teamBName

        // Update score displays
        viewModel.teamAScore.observe(this) { score ->
            binding.teamAScore.text = score.toString()
        }
        viewModel.teamBScore.observe(this) { score ->
            binding.teamBScore.text = score.toString()
        }

        // Set button listeners for scoring
        binding.teamA2Points.setOnClickListener {
            viewModel.addPoints(1, 2) // Team A scores 3 points
        }
        binding.teamA1Points.setOnClickListener {
            viewModel.addPoints(1, 1) // Team A scores 2 points
        }
        binding.teamAPelanggaran.setOnClickListener {
            viewModel.addPoints(1, -1) // Team A scores 1 point
        }
        binding.teamB2Points.setOnClickListener {
            viewModel.addPoints(2, 2) // Team B scores 3 points
        }
        binding.teamB1Points.setOnClickListener {
            viewModel.addPoints(2, 1) // Team B scores 2 points
        }
        binding.teamBPelanggaran.setOnClickListener {
            viewModel.addPoints(2, -1) // Team B scores 1 point
        }

        // Reset button
        binding.resetButton.setOnClickListener {
            viewModel.resetScores()
        }
    }
}
