package com.example.battleshipgame.controllers

import carte.toolfx.core.Controller
import carte.toolfx.core.Element
import javafx.fxml.FXML
import javafx.scene.shape.Rectangle

@Element("/battle-tile.fxml")
class BattleTileController : Controller() {

    @FXML
    lateinit var battleTile: Rectangle;

    override fun onCreate() {


    }
}