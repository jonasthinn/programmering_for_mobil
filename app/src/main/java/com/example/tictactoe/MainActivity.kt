package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var playerOnesTurn: Boolean = true
    lateinit var playerOne: TTTPlayer
    lateinit var playerTwo: TTTPlayer
    lateinit var board: TTT_Board
    lateinit var game: TicTacToeGame
    lateinit var binding: ActivityMainBinding
    var weHaveAWinner: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        playerOne = TTTPlayer("X")
        playerTwo = TTTPlayer("O")
        board = TTT_Board(3, 3)
        game = TicTacToeGame(board, listOf(playerOne, playerTwo))

        binding.playerOne.text = "Player One: '${playerOne.playerSymbol}'\nScore: ${playerOne.score}"
        binding.playerTwo.text = "Player Two: '${playerOne.playerSymbol}'\nScore: ${playerTwo.score}"

        enableButtons(true)
        binding.playAgain.setOnClickListener() { restartGame() }


    }

    fun onClick(view: View) {
        val button = view as Button
        val text = if (playerOnesTurn) playerOne.playerSymbol else playerTwo.playerSymbol
        if (button.text == " ") {
            button.text = text
            playerOnesTurn = !playerOnesTurn
            var buttonId: Char = resources.getResourceEntryName(button.id).last()
            game.ttt_board.makeMove(buttonId, text)
        }
        if (game.checkForWin()) {
            var winner: TTTPlayer = if (playerOnesTurn) playerTwo else playerOne
            winner.score += 1
            binding.playerOne.text = "Player One: '${playerOne.playerSymbol}'\nScore: ${playerOne.score}"
            binding.playerTwo.text = "Player Two: '${playerTwo.playerSymbol}'\nScore: ${playerTwo.score}"
            Toast.makeText(this, "jippipii", Toast.LENGTH_LONG).show()
            enableButtons(false)
        }
    }

    fun enableButtons(enableOrDisable: Boolean) {
        val layout: ViewGroup = binding.gl
        for (i in 0 until layout.childCount) {
            if (layout.getChildAt(i) is Button) {
                if (enableOrDisable) {
                    layout.getChildAt(i).setOnClickListener() { onClick(it) }
                } else layout.getChildAt(i).isClickable = false
            }
        }
    }

    fun restartGame() {
        val layout: ViewGroup = binding.gl
        playerOnesTurn = true
        board = TTT_Board(3, 3)
        game = TicTacToeGame(board, listOf(playerOne, playerTwo))
        enableButtons(true)
        for (i in 0 until layout.childCount) {
            if (layout.getChildAt(i) is Button) {
                (layout.getChildAt(i) as Button).setText(" ")
            }
        }
    }
}


