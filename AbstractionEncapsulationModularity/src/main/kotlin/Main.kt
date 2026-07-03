import org.w3c.dom.ls.LSOutput

fun main() {
    println("Hello World!")
//    val alarm = Alarm()
    val alarm2 = Alarm()
//    println(alarm == alarm2)
    val myInt: Int = 10

    val alarm: Alarm? = Alarm()

    alarm?.doThing() ?: println("Alarm is null")

    val stack = Stack<Int>()
    stack.push(myInt)
    stack.push(myInt)
    stack.push(myInt)
    stack.push(myInt)
    stack.push(myInt)
    stack.push(myInt)
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())

    val width = 34.4
    val height = 0.0
    var rectangle: Rectangle? = null
    rectangle = Rectangle(0.0, 0.0, width, height)


    val account = BankAccount()

//    println(account.balance)

}