package command

import drawing.Drawing

class NoopCommand(drawing: Drawing): DrawingCommand(drawing) {
    override fun mouseDown(mouseX: Double, mouseY: Double) {

    }

    override fun mouseMove(deltaX: Double, deltaY: Double) {

    }

    override fun undo() {

    }

    override fun redo() {

    }

    override fun clone(): DrawingCommand {
        return NoopCommand(drawing)
    }
}