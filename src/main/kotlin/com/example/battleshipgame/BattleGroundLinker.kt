package com.example.battleshipgame

import carte.toolfx.core.Controller
import carte.toolfx.core.runFxmlElement
import com.example.battleshipgame.controllers.BattleShipController
import com.example.battleshipgame.controllers.BattleTileController
import com.example.battleshipgame.controllers.EnemyShipController
import com.example.battleshipgame.model.BattleGround
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
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
        battleGround.placeShip()
        battleGround.board.forEach { println(it.contentToString()) }

        for (r in battleGround.board.indices) {
            for (c in battleGround.board[r].indices) {
                battleGroundPane.add(runFxmlElement<BattleTileController>(context) {
                    battleTile.setOnMouseClicked {
                        if (battleGround.board[r][c] == 1) {
                            revealShip();
                            val hitDialog = Dialog<String>();
                            hitDialog.dialogPane.buttonTypes.add(ButtonType.OK)
                            hitDialog.contentText = "you hit the ship with ${battleGround.hits} hits left!"
                            hitDialog.showAndWait();
                        }

                    }



                }.battleTile, c, r);

            }

        }
    }

    private fun revealShip() {
        for (r in battleGround.board.indices) {
            for (c in battleGround.board[r].indices) {
                if (battleGround.board[r][c] == 1) {
                    val rectangle = (battleGroundPane.children.find { GridPane.getColumnIndex(it) == c && GridPane.getRowIndex(it) == r } as Rectangle)
                    rectangle.fill = Color.INDIANRED;
                }
            }
        }

    }


}