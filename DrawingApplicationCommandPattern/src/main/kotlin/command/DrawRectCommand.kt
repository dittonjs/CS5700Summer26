package command

import drawing.Drawing
import shape.Rectangle

class DrawRectCommand(drawing: Drawing): DrawingCommand(drawing) {
    private lateinit var rect: Rectangle

    override fun mouseDown(mouseX: Double, mouseY: Double) {
        rect = Rectangle(mouseX, mouseY, 0.0, 0.0)
        drawing.addShape(rect)
    }

    override fun mouseMove(mouseX: Double, mouseY: Double) {
        rect.width = mouseX - rect.x
        rect.height = mouseY - rect.y
    }

    override fun undo() {
        drawing.removeShape(rect)
    }

    override fun redo() {
        drawing.addShape(rect)
    }

    override fun clone(): DrawingCommand {
        return DrawRectCommand(drawing)
    }

}