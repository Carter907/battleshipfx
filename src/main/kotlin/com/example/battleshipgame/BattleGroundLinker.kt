package com.example.battleshipgame

import carte.toolfx.core.Controller
import carte.toolfx.core.runFxmlElement
import com.example.battleshipgame.controllers.BattleShipController
import com.example.battleshipgame.controllers.BattleTileController
import com.example.battleshipgame.controllers.EnemyShipController
import com.example.battleshipgame.model.BattleGround
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Path
import javafx.scene.shape.Rectangle

class BattleGroundLinker(
    private val context: Controller, private val battleGround: BattleGround,
    private val battleGroundPane: GridPane
) {

    fun link() {
        for (i in 0..9) {
            for (j in 0..9) {
                battleGroundPane.add(
                    runFxmlElement<BattleTileController>(context),
                    j, i
                )

            }
        }

        fillShips(battleGround.teamCount)
    }

    private fun fillShips(teamCount: Int) {

        var col = 0;
        var row = 0;

        outer@
        for (i in 0 until teamCount) {

            col = (0..9).random()
            row = (0..4).random();
            do {
                val shipsAtIndex = battleGroundPane.children.stream().filter {
                    GridPane.getColumnIndex(it) == col
                            && GridPane.getRowIndex(it) == row && it is Path
                }.toList()
                if (shipsAtIndex.size > 0) {
                    col = (0..9).random()
                    row = (0..4).random();
                }

            } while (shipsAtIndex.size > 0);


            battleGroundPane.add(
                runFxmlElement<BattleShipController>(context),
                col, row
            )


        }
        outer@
        for (i in 0 until teamCount) {

            col = (0..9).random()
            row = (5..9).random();
            do {
                val shipsAtIndex = battleGroundPane.children.stream().filter {
                    GridPane.getColumnIndex(it) == col
                            && GridPane.getRowIndex(it) == row && it is Path
                }.toList()
                if (shipsAtIndex.size > 0) {
                    col = (0..9).random()
                    row = (5..9).random();
                }

            } while (shipsAtIndex.size > 0);


            battleGroundPane.add(
                runFxmlElement<EnemyShipController>(context),
                col, row
            )
        }
    }
}