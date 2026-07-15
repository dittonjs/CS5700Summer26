package ui

import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox

class Controls: HBox(8.0) {
    private val rectButton: Button
    private val circleButton: Button
    private val moveButton: Button
    private val deleteButton: Button
    private val undoButton: Button
    private val redoButton: Button
    init {
        padding = Insets(8.0)
        rectButton = Button("Rectangle")
        circleButton = Button("Circle")
        moveButton = Button("Move")
        deleteButton = Button("Delete")
        undoButton = Button("Undo")
        redoButton = Button("Redo")

        children.apply {
            add(rectButton)
            add(circleButton)
            add(moveButton)
            add(deleteButton)
            add(undoButton)
            add(redoButton)
        }
    }

    fun onRectangleClick(eventHandler: EventHandler<MouseEvent>) {
        rectButton.onMouseClicked = eventHandler
    }

    fun onCircleClick(eventHandler: EventHandler<MouseEvent>) {
        circleButton.onMouseClicked = eventHandler
    }

    fun onMoveClick(eventHandler: EventHandler<MouseEvent>) {
        moveButton.onMouseClicked = eventHandler
    }

    fun onDeleteClick(eventHandler: EventHandler<MouseEvent>) {
        deleteButton.onMouseClicked = eventHandler
    }

    fun onUndoClick(eventHandler: EventHandler<MouseEvent>) {
        undoButton.onMouseClicked = eventHandler
    }

    fun onRedoClick(eventHandler: EventHandler<MouseEvent>) {
        redoButton.onMouseClicked = eventHandler
    }
}