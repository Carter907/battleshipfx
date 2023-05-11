package com.example.battleshipgame.controllers

import carte.toolfx.core.Controller
import carte.toolfx.core.Element
import javafx.fxml.FXML
import javafx.scene.paint.Color
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.QuadCurveTo

@Element("/battle-ship.fxml")
class BattleShipController: Controller() {

    @FXML
    lateinit var battleShip: Path;

    override fun onCreate() {


    }
}