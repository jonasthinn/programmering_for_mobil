package com.example.tictactoe

import kotlin.reflect.typeOf

open class Board(val row:Int, val columns: Int) {
    var board = MutableList(row) {MutableList(columns) {" "}}

    init {

    }
    }
