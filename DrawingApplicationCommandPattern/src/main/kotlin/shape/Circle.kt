package shape

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javax.swing.Spring.height


class Circle(
    x: Double,
    y: Double,
    var radius: Double
): Shape(x, y) {
    override fun draw(context: GraphicsContext) {
        context.fill = Color.LIGHTGREEN
        context.fillOval(x, y, radius * 2.0,  radius * 2)
    }

    override fun containsPoint(x: Double, y: Double): Boolean {
        return x > this.x - radius && x < this.x + this.radius && y > this.y - radius && y < this.y + this.radius
    }
}