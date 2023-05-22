package com.example.battleshipgame

import carte.toolfx.core.Controller
import carte.toolfx.core.runFxmlElement
import com.example.battleshipgame.controllers.BattleTileController
import com.example.battleshipgame.model.BattleGround
import com.example.battleshipgame.model.BattleTile
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.paint.ImagePattern
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.Rectangle
import java.util.function.Consumer

class BattleGroundLinker(
    private val context: Controller, private val battleGround: BattleGround,
    private val battleGroundPane: GridPane
) {
    fun reset() {
        battleGroundPane.children.clear();
        battleGround.reset()
        battleGround.placeShip();
    }

    private fun applyAndAddRectangles() {


    }

    private fun applyToBattleTiles(eachRectangle: (r: Int, c: Int) -> Unit) {


        for (r in battleGround.board.indices) {
            for (c in battleGround.board[r].indices) {
                eachRectangle.invoke(r, c);
            }
        }
    }

    fun showShip() {
        battleGroundPane.children.clear();



    }

    fun link() {

        battleGround.placeShip()
        battleGround.board.forEach { println(it.contentToString()) }



        applyToBattleTiles { r, c ->


            battleGroundPane.add(runFxmlElement<BattleTileController>(context) {
                battleTileRectangle.setOnMouseClicked {
                    val battleTile = battleGround.board[r][c] ?: error("REEEEEEEEEEEEEEEEEEEE")
                    if (battleTile.isShip && !battleTile.isHit && battleGround.hits > 0) {
                        battleTileRectangle.fill = Color.INDIANRED;
                        battleGround.hits--;
                        battleGround.board[r][c] = BattleTile(isHit = true, isShip = true)
                        val hitDialog = Dialog<String>();
                        hitDialog.dialogPane.buttonTypes.add(ButtonType.OK)
                        hitDialog.contentText = "you hit the ship with ${battleGround.hits} hits left!"
                        hitDialog.showAndWait();
                    } else if (!battleTile.isHit && battleGround.hits > 0) {
                        val noHitDialog = Dialog<String>();
                        battleGround.hits--;

                        battleGroundPane.add(
                            Path(
                                MoveTo(0.0, 0.0),
                                LineTo(50.0, 50.0),
                                MoveTo(50.0, 0.0),
                                LineTo(0.0, 50.0)
                            ).apply {
                                translateX += 12;
                            }, c, r
                        );
                        battleGround.board[r][c] = BattleTile(isHit = true, isShip = false)
                        noHitDialog.contentText = "did not hit a ship. you have ${battleGround.hits} hits left"
                        noHitDialog.dialogPane.buttonTypes.add(ButtonType.OK)
                        noHitDialog.showAndWait()

                    } else if (battleGround.hits == 0) {
                        val noHitsLeftDialog = Dialog<String>();
                        noHitsLeftDialog.contentText = "you have no hits left!"
                        applyToRec { r, c ->
                            val battleTile = battleGround.board[r][c] ?: error("REEEEEEEEEEEEEEEEEEEE")


                            if (battleTile.isShip) {


                            }

                        }

                    }

                }


            }.battleTileRectangle, c, r);

        }

    }


}