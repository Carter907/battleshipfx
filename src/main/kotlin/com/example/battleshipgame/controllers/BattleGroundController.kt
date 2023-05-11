package com.example.battleshipgame.controllers

import carte.toolfx.core.Controller
import carte.toolfx.core.Element
import com.example.battleshipgame.BattleGroundLinker
import com.example.battleshipgame.model.BattleGround
import javafx.fxml.FXML
import javafx.scene.layout.GridPane

@Element("/battle-ground.fxml")
class BattleGroundController : Controller() {

    @FXML
    lateinit var battleGroundPane: GridPane

    override fun onCreate() {
        val battleGround = BattleGround(5);
        val battleGroundLinker = BattleGroundLinker(this, battleGround, battleGroundPane);

        battleGroundLinker.link();
    }
}