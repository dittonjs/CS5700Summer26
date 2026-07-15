package shape

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class Rectangle(
    x: Double,
    y: Double,
    var width: Double,
    var height: Double
): Shape(x, y) {
    override fun draw(context: GraphicsContext) {
        context.apply {
            println("width: $width, height: $height")
            fill = Color.RED
            fillRect(x, y, width, height)
        }
    }

    override fun containsPoint(x: Double, y: Double): Boolean {
        return x > this.x && x < this.x + width && y > this.y && y < this.y + height
    }

}