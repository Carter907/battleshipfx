package com.example.battleshipgame.model

import carte.toolfx.core.runFxmlElement
import com.example.battleshipgame.controllers.BattleShipController
import com.example.battleshipgame.controllers.EnemyShipController
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.Path
import javafx.scene.shape.Rectangle

class BattleGround {

    var hits = 15;

    val board: Array<Array<Int>> = Array(8) { Array(8) { 0 } };

    fun placeShip() {
        val orientation = (0..1).random()
        var x: Int;
        var y: Int;
        if (orientation == BattleShip.SHIP_HORIZONTAL) {
            x = (0..(board.size - 4)).random()
            y = (board.indices).random()
            for (i in x until (x+4)) {
                board[y][i] = 1;

            }

        } else {

            x = (board.indices).random()
            y = (0..(board.size-4)).random()
            for (i in y until (y+4)) {
                board[i][x] = 1;

            }
        }



    }
}