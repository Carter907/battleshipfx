package com.example.battleshipgame

import carte.toolfx.core.runFxmlScreen
import com.example.battleshipgame.controllers.HomeController
import javafx.application.Application
import javafx.stage.Stage


class App : Application() {
    override fun start(stage: Stage) {
        runFxmlScreen<HomeController>(
            stage, "program",
            css = "/css/App.css",
            width = 800.0,
            height = 650.0
        )
    }
}

fun main() = Application.launch(App::class.java)