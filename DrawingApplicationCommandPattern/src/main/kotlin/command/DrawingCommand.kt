package command

import drawing.Drawing

abstract class DrawingCommand(protected val drawing: Drawing) {
    abstract fun mouseDown(mouseX: Double, mouseY: Double)
    abstract fun mouseMove(x: Double, y: Double)
    abstract fun undo()
    abstract fun redo()
    abstract fun clone(): DrawingCommand
}