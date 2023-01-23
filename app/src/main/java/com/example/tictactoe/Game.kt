package com.example.tictactoe

abstract class Game {
    abstract val ttt_board: TTT_Board
    abstract val players: List<TTT_Player>
    abstract fun checkForWin(): Boolean
}