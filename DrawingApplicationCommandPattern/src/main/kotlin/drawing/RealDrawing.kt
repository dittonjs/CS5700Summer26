package drawing

import shape.Shape

class RealDrawing: Drawing() {
    private val shapes = mutableListOf<Shape>()

    override fun addShape(shape: Shape) {
        if (shape !in shapes) {
            shapes.addFirst(shape)
        }
    }

    override fun removeShape(shape: Shape) {
        shapes -= shape
    }

    override fun findShapeAt(x: Double, y: Double): Shape? {
        return shapes.find { it.containsPoint(x, y) }
    }

    override fun forEachShape(callback: (Shape) -> Unit) {
        shapes.forEach(callback)
    }
}