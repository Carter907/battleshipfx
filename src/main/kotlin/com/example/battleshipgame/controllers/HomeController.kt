package com.example.battleshipgame.controllers

import carte.toolfx.core.Controller
import carte.toolfx.core.Screen
import carte.toolfx.core.runFxmlScreen
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.SVGPath

@Screen("/home.fxml")
class HomeController : Controller(){
    @FXML
    lateinit var continueButton: Button;

    @FXML
    lateinit var battleShip: Path;

    override fun onCreate() {

        battleShip.elements.addAll(MoveTo(50.0, 50.0), LineTo(80.0, 90.0))

    }


}