package com.example.battleshipgame.controllers

import carte.toolfx.core.Controller
import carte.toolfx.core.Screen
import carte.toolfx.core.runFxmlElement
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.SVGPath

@Screen("/home.fxml")
class HomeController : Controller(){

    @FXML
    lateinit var root: StackPane

    override fun onCreate() {
        scene.widthProperty().addListener { i ->
            println(root.width)
        }
        root.prefWidthProperty().bind(scene.widthProperty())
        root.prefHeightProperty().bind(scene.heightProperty())


        root.children.add(runFxmlElement<BattleGroundController>(this))

    }


}