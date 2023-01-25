package com.example.tictactoe

class TTT_Board(row: Int = 3, columns: Int = 3) : Board(row, columns) {

    // Metoden tar en field: Int, i stedet for feks "row" og "column". Dette for å lettere
    // implementere i appen
    fun makeMove(field: Char, playerChar: String) {
        when (field){
            '1' -> board[0][0] = playerChar
            '2' -> board[0][1] = playerChar
            '3' -> board[0][2] = playerChar
            '4' -> board[1][0] = playerChar
            '5' -> board[1][1] = playerChar
            '6' -> board[1][2] = playerChar
            '7' -> board[2][0] = playerChar
            '8' -> board[2][1] = playerChar
            '9' -> board[2][2] = playerChar

        }
    }

    operator fun get(i: Int, j: Int) = board[i][j]
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