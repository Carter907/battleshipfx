package com.example.battleshipgame.controllers

import carte.toolfx.core.Controller
import carte.toolfx.core.Screen
import carte.toolfx.core.runFxmlElement
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.SVGPath
import java.util.*

@Screen("/home.fxml")
class HomeController : Controller(){

    @FXML
    lateinit var root: StackPane

    @FXML
    lateinit var playButton: Button;

    override fun onCreate() {
        scene.widthProperty().addListener { i ->
            println(root.width)
        }
        root.prefWidthProperty().bind(scene.widthProperty())
        root.prefHeightProperty().bind(scene.heightProperty())


        root.children.add(runFxmlElement<BattleGroundController>(this).battleGroundPane)


        playButton.setOnAction {

            val dialog = Dialog<String>();
            dialog.dialogPane.buttonTypes.add(ButtonType("OKAY", ButtonBar.ButtonData.OK_DONE))

            dialog.dialogPane.scene.stylesheets.add(scene.stylesheets[0]);

            dialog.headerText = "about battleship"
            dialog.contentText = """
            
                 (also known as Battleships or Sea Battle[1]) is a strategy type guessing game for two players. It is played on ruled grids (paper or board) on which each player's fleet of warships are marked. The locations of the fleets are concealed from the other player. Players alternate turns calling "shots" at the other player's ships, and the objective of the game is to destroy the opposing player's fleet.

                Battleship is known worldwide as a pencil and paper game which dates from World War I. It was published by various companies as a pad-and-pencil game in the 1930s and was released as a plastic board game by Milton Bradley in 1967. The game has spawned electronic versions, video games, smart device apps and a film.
            """.trimIndent()

             val result = dialog.showAndWait();


        }

    }


}