import java.lang.StringBuilder

fun isNumber(s: String): Boolean {
    if (s.isEmpty()) return false
    for (symbol in s) {
        if (!symbol.isDigit()) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {

    print("Please input expression = ")
    var answer: String? = readLine()
    val ops = arrayOf("+", "-", "*", "/")
    if (!answer.isNullOrEmpty()) {
        val parts = answer?.split(' ')
        val stack = mutableListOf<String>()
        for (part in parts.reversed()) {
            if (isNumber(part)) {
                stack.add(0, part)
            } else {
                if (part in ops) {
                    if (stack.size >= 2) {
                        var sign = part
                        var first = stack.first()
                        stack.removeAt(0)
                        var second = stack.first()
                        stack.removeAt(0)

                        var str = "(" + first + sign + second + ")"

                        stack.add(0, str)
                    } else {
                        println("Not enough args")
                        return
                    }
                } else {
                    println("Wrong expression! There are unrecognized symbols")
                    return
                }
            }
        }

        if (stack.size > 1) {
            println("Not enough operators")
        } else if (stack.isEmpty()) {
            println("Stack is empty. Please rerun program and enter new expression")
        } else {
            println("Result: ${stack.removeAt(stack.lastIndex)}")
        }
    }
    else {
        println("Expression is empty. Please rerun program and enter new expression")
    }
}