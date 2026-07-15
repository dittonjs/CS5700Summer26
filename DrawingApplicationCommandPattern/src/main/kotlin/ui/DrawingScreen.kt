package ui

import javafx.scene.layout.BorderPane
import viewmodel.DrawingController

class DrawingScreen: BorderPane() {
    private val controls = Controls()
    private val canvas = DrawingCanvas()
    private val controller = DrawingController(controls=controls, canvas=canvas)
    init {
        top = controls
        center = canvas

    }
}