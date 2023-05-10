package com.example.battleshipgame

import carte.toolfx.core.Screen
import carte.toolfx.core.runFxmlScreen
import com.example.battleshipgame.controllers.HomeController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage


class Application : Application() {
    override fun start(stage: Stage) {
        runFxmlScreen<HomeController>(stage, "program")
    }
}
