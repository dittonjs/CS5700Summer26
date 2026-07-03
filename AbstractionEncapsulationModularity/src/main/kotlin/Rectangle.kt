import java.io.File
import kotlin.jvm.Throws

class Rectangle @Throws(IllegalArgumentException::class) constructor(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double,
) {
    init {
        require(width > 0.0) { "width must be positive" }
        require(height > 0.0) { "height must be positive" }
    }
    val area: Double
        get() {
            return width * height
        }
}