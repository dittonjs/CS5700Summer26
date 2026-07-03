import java.util.LinkedList

class Stack<T> {
    private val collection = LinkedList<T>()

    fun pop(): T? {
        return collection.removeLastOrNull()
    }

    fun push(value: T) {
        collection += value
    }

    fun peek(): T? {
        return collection.lastOrNull()
    }
}