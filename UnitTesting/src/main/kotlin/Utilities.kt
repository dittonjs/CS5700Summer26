fun fuddify(text: String): String {
    require(text.isNotEmpty()) { "text should not be empty" }
    return text.replace("r", "w").replace("R", "W")
}

fun max(val1: Int, val2: Int): Int {
    println("max($val1, $val2)")
    return if (val1 >= val2) val1 else val2
}

fun min(val1: Int, val2: Int): Int {
    return if (val1 <= val2) val1 else val2
}


fun doWithLog(callback: (Int, Int) -> Unit) {
    println("doWithLog start")
    callback(1,2)
    println("doWithLog end")
}

fun main() {
    val a = listOf(1,2,3,4,5)
    a.forEach {
        println(it)
    }


    doWithLog {val1: Int, val2:Int ->
        println("$val1 + $val2")
    }
}



