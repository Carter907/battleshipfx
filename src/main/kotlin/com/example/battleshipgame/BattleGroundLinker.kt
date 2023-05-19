package com.example.battleshipgame

import carte.toolfx.core.Controller
import carte.toolfx.core.runFxmlElement
import com.example.battleshipgame.controllers.BattleTileController
import com.example.battleshipgame.model.BattleGround
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import java.util.function.Consumer

class BattleGroundLinker(
    private val context: Controller, private val battleGround: BattleGround,
    private val battleGroundPane: GridPane
) {
    fun reset() {
        battleGround.reset()
        battleGround.placeShip();
    }

    private fun applyToRectangles(eachRectangle: (r: Int, c: Int) -> Unit) {


        for (r in battleGround.board.indices) {
            for (c in battleGround.board[r].indices) {
                eachRectangle.invoke(r, c);
            }
        }
    }

    fun link() {

        battleGround.placeShip()
        battleGround.board.forEach { println(it.contentToString()) }



        applyToRectangles { r, c ->


            battleGroundPane.add(runFxmlElement<BattleTileController>(context) {
                battleTileRectangle.setOnMouseClicked {
                    val battleTile = battleGround.board[r][c] ?: error("REEEEEEEEEEEEEEEEEEEE")
                    if (battleTile.isShip) {
                        battleTileRectangle.fill = Color.INDIANRED;


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


            }.battleTileRectangle, c, r);

        }

    }


}