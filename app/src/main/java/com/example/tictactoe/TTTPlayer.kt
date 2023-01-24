package com.example.tictactoe

class TTTPlayer(override val playerSymbol: String) : Player {
    override var score: Int = 0
    override fun addScore() {score++}
    init {
    }


}