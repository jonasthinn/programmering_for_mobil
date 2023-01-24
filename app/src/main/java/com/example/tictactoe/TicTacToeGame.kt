package com.example.tictactoe

class TicTacToeGame(override var ttt_board: TTT_Board, override val players: List<TTTPlayer>) : Game() {

    override fun checkForWin() = (checkRows() || checkColumns() || checkDiagonals())

    private fun checkRows(): Boolean{
        for (i in 0..2){
            if (ttt_board.board[i][0] != " "){
            return ttt_board.board[i][0] == ttt_board.board[i][1] && ttt_board.board[i][1] == ttt_board.board[i][2]
            }
        }
        return false
    }

    private fun checkColumns(): Boolean{
        for (i in 0..2){
            if (ttt_board.board[0][i] != " "){
                return ttt_board.board[0][i] == ttt_board.board[1][i] && ttt_board.board[1][i] == ttt_board.board[2][i]
            }
        }
        return false
    }

    private fun checkDiagonals(): Boolean {
        if (ttt_board.board[0][0] != " "){
            if (ttt_board.board[0][0] == ttt_board.board[1][1] && ttt_board.board[0][0] == ttt_board.board[2][2])
                return true
        }
        if (ttt_board.board[0][2] != " "){
            if (ttt_board.board[0][2] == ttt_board.board[1][1] && ttt_board.board[0][2] == ttt_board.board[2][0])
                return true
        }
        return false
    }

}

fun main(){
    var game = TicTacToeGame(TTT_Board(3,3), listOf(TTTPlayer( "X"), TTTPlayer("O")))
    game.ttt_board.makeMove(0,0,"X")
    game.ttt_board.makeMove(1,1,"X")
    game.ttt_board.makeMove(2,2,"X")
    print(game.ttt_board)
    print(game.checkForWin())
}