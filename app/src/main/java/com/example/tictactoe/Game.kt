package com.example.tictactoe

abstract class Game {
    abstract val ttt_board: TTT_Board
    abstract val players: List<TTTPlayer>
    abstract fun checkForWin(): Boolean
}