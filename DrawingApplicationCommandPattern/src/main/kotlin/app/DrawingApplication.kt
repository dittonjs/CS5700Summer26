package app

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.text.Text
import javafx.stage.Stage
import ui.DrawingScreen

class DrawingApplication: Application() {
    override fun start(stage: Stage) {

        val root = DrawingScreen()

        stage.title = "Drawing Application"
        stage.scene = Scene(root)
        stage.show()
    }
}