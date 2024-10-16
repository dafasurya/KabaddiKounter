package com.example.kabaddikounter

import android.os.Bundle
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


        val teamAName = intent.getStringExtra("TEAM_A_NAME")
        val teamBName = intent.getStringExtra("TEAM_B_NAME")

        binding.teamAName.text = teamAName
        binding.teamBName.text = teamBName

        viewModel.teamAScore.observe(this) { score ->
            binding.teamAScore.text = score.toString()
            checkWinCondition()
        }
        viewModel.teamBScore.observe(this) { score ->
            binding.teamBScore.text = score.toString()
            checkWinCondition()
        }

        binding.teamA1Points.setOnClickListener {
            viewModel.addPoints(1, 1)
        }
        binding.teamA2Points.setOnClickListener {
            viewModel.addPoints(1, 2)
        }
        binding.teamB1Points.setOnClickListener {
            viewModel.addPoints(2, 1)
        }
        binding.teamB2Points.setOnClickListener {
            viewModel.addPoints(2, 2)
        }

        binding.resetButton.setOnClickListener {
            viewModel.resetScores()
            enableButtons(true)
            binding.winnerTextViewA.text = ""
            binding.winnerTextViewB.text = ""
        }
    }


    private fun checkWinCondition() {
        val scoreA = viewModel.teamAScore.value ?: 0
        val scoreB = viewModel.teamBScore.value ?: 0

        if (scoreA >= 25 || scoreB >= 25) {
            val scoreDifference = Math.abs(scoreA - scoreB)
            if (scoreDifference >= 2) {
                enableButtons(false)

                if (scoreA > scoreB) {
                    binding.winnerTextViewA.text = "$scoreA Wins!"
                    binding.winnerTextViewB.text = ""
                } else {
                    binding.winnerTextViewB.text = "$scoreB Wins!"
                    binding.winnerTextViewA.text = ""
                }
            }
        }
    }

    private fun enableButtons(enable: Boolean) {
        binding.teamA1Points.isEnabled = enable
        binding.teamA2Points.isEnabled = enable
        binding.teamB1Points.isEnabled = enable
        binding.teamB2Points.isEnabled = enable
    }
}