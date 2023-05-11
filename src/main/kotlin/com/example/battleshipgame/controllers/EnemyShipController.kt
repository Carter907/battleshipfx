package com.example.battleshipgame.controllers

import carte.toolfx.core.Controller
import carte.toolfx.core.Element
import javafx.fxml.FXML
import javafx.scene.shape.Path

@Element("/enemy-ship.fxml")
class EnemyShipController : Controller(){
    @FXML
    private lateinit var enemyShip: Path

    override fun onCreate() {


    }

}