package viewmodel

import command.DrawRectCommand
import command.DrawingCommand
import command.Invoker
import command.MoveCommand
import command.NoopCommand
import drawing.Drawing
import drawing.RealDrawing
import ui.Controls
import ui.DrawingCanvas

class DrawingController(
    private val canvas: DrawingCanvas,
    private val controls: Controls,
    private val drawing: Drawing = RealDrawing()
) {
    private val invoker: Invoker = Invoker(NoopCommand(drawing))
//    private var isMouseDown = false
    init {
        controls.onCircleClick { /* TODO: set the command in the invoker */ }
        controls.onRectangleClick {
            invoker.setCurrentCommand(DrawRectCommand(drawing))
        }
        controls.onDeleteClick {  }
        controls.onMoveClick {  invoker.setCurrentCommand(MoveCommand(drawing)) }

        controls.onUndoClick {
            invoker.undo()
            refreshCanvas()
        }

        controls.onRedoClick {
            invoker.redo()
            refreshCanvas()
        }

        canvas.onMousePressed = {
            invoker.executeCommandMousePress(it.x, it.y)
            refreshCanvas()
        }

        canvas.onMouseDragged = {
            invoker.executeCommandMouseMove(it.x, it.y)
            refreshCanvas()
        }

        canvas.onMouseReleased = {
            invoker.cloneCurrentCommand()
        }
    }

    private fun refreshCanvas() {
        canvas.clear()
        drawing.forEachShape {
            canvas.drawShape(it)
        }
    }

}