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
    fun reset() {
        battleGround.reset()
        battleGround.placeShip();
    }

    fun link() {

            battleGround.placeShip()
            battleGround.board.forEach { println(it.contentToString()) }

            for (r in battleGround.board.indices) {
                for (c in battleGround.board[r].indices) {
                    battleGroundPane.add(runFxmlElement<BattleTileController>(context) {
                        battleTile.setOnMouseClicked {
                            if (battleGround.board[r][c] == 1) {
                                battleTile.fill = Color.INDIANRED;
                                battleGround.hits--;
                                val hitDialog = Dialog<String>();
                                hitDialog.dialogPane.buttonTypes.add(ButtonType.OK)
                                hitDialog.contentText = "you hit the ship with ${battleGround.hits} hits left!"
                                hitDialog.showAndWait();
                            } else {
                                val noHitDialog = Dialog<String>();
                                battleGround.hits--;
                                noHitDialog.contentText = "did not hit a ship. you have ${battleGround.hits} hits left"
                                noHitDialog.dialogPane.buttonTypes.add(ButtonType.OK)
                                noHitDialog.showAndWait()


                            }

                        }


                    }.battleTile, c, r);

                }

            }

    }


}