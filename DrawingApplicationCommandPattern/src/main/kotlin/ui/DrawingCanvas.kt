package ui

import javafx.scene.canvas.Canvas
import shape.Shape

class DrawingCanvas(
    width: Double = 1000.0,
    height: Double = 1000.0
): Canvas(width, height) {
    fun clear() {
        graphicsContext2D.clearRect(0.0, 0.0, width, height)
    }

    fun drawShape(shape: Shape) {
        shape.draw(graphicsContext2D)
    }
}