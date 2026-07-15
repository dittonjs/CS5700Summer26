package command

class Invoker(initialCommand: DrawingCommand) {
    private val undoStack = mutableListOf<DrawingCommand>()
    private val redoStack = mutableListOf<DrawingCommand>()
    private var currentCommand: DrawingCommand = initialCommand

    fun setCurrentCommand(command: DrawingCommand) {
        if (currentCommand !is NoopCommand) {
            undoStack.addFirst(currentCommand)
        }
        redoStack.clear()
        currentCommand = command
    }


    fun executeCommandMousePress(x: Double, y: Double) {
        currentCommand.mouseDown(x, y)
    }

    fun executeCommandMouseMove(x: Double, y: Double) {
        currentCommand.mouseMove(x, y)
    }

    fun undo() {
        undoStack.removeFirstOrNull()?.apply {
            redoStack.addFirst (this)
            undo()
        }
    }

    fun redo() {
        redoStack.removeFirstOrNull()?.apply {
            undoStack.addFirst(this)
            redo()
        }
    }

    fun cloneCurrentCommand() {
        setCurrentCommand(currentCommand.clone())
    }


}