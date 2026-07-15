package command

import drawing.Drawing
import shape.Shape

class MoveCommand(drawing: Drawing): DrawingCommand(drawing) {
    private var shape: Shape? = null
    private var originalX: Double? = null
    private var originalY: Double? = null
    override fun mouseDown(mouseX: Double, mouseY: Double) {
        shape = drawing.findShapeAt(mouseX, mouseY)
        originalX = shape?.x
        originalY = shape?.y
    }

    override fun mouseMove(x: Double, y: Double) {
        shape?.x = x
        shape?.y = y
    }

    override fun undo() {
        if (shape != null) {
            val x = shape!!.x
            val y = shape!!.y
            shape!!.x = originalX!!
            shape!!.y = originalY!!
            originalX = x
            originalY = y
        }
    }

    override fun redo() {
        undo()
    }

    override fun clone(): DrawingCommand {
        return MoveCommand(drawing)
    }
}