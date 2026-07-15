package drawing

import shape.Shape

abstract class Drawing {
    abstract fun addShape(shape: Shape)
    abstract fun removeShape(shape: Shape)
    abstract fun findShapeAt(x: Double, y: Double): Shape?
    abstract fun forEachShape(callback: (Shape) -> Unit)

}
