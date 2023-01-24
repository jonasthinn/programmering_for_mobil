package com.example.tictactoe

class TTT_Board(row: Int = 3, columns: Int = 3) : Board(row, columns) {


    fun makeMove(row: Int, column: Int, playerChar: String) {
        board[row][column] = playerChar
    }

    override fun toString(): String = """
            |
            |      ${board[0]}
            |      ${board[1]}
            |      ${board[2]}
            |
        """.trimMargin()
}

fun main() {
    var b = TTT_Board(3, 3)
    print(b.board)
}