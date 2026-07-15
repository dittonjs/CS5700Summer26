package shape

import javafx.scene.canvas.GraphicsContext

abstract class Shape(
    var x: Double = 0.0,
    var y: Double = 0.0,
) {
    abstract fun draw(context: GraphicsContext)
    abstract fun containsPoint(x: Double, y: Double): Boolean
}