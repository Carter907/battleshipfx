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

    var board: Array<Array<BattleTile?>> = Array(8) { Array(8) { BattleTile(isHit = false, isShip = false) } };

    fun placeShip() {
        val orientation = (0..1).random()
        var x: Int;
        var y: Int;
        if (orientation == BattleShip.SHIP_HORIZONTAL) {
            x = (0..(board.size - 4)).random()
            y = (board.indices).random()
            for (i in x until (x+4)) {
                board[y][i] = BattleTile(isHit = false, isShip = true);

            }

        } else {

            x = (board.indices).random()
            y = (0..(board.size-4)).random()
            for (i in y until (y+4)) {
                board[i][x] = BattleTile(isHit = false, isShip = true);

            }
        }

    }

    fun reset() {


    }
}