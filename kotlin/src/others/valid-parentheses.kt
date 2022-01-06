import java.util.Stack

fun main() {
    inputList.forEach { (input, output) ->
        val answer = isValid(input)
        val isCorrect = answer == output
        if (!isCorrect) {
            throw Error(buildResponse(input, output, answer))
        } else {
            println("Correct!${buildResponse(input, output, answer)}\n\n")
        }
    }
}

private fun buildResponse(input: String, output: Boolean, answer: Boolean): String {
    return """
        
        Input: $input 
        Output: $output
        My Answer: $answer
    """.trimIndent()
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    if (s.length % 2 != 0) return false
    for (char in s) {
        when (char) {
            '(', '[', '{' -> stack.push(char)
            else -> {
                if (stack.isEmpty()) return false
                val last = stack.peek()
                when (char) {
                    ')' -> if (last != '(') return false
                    '}' -> if (last != '{') return false
                    ']' -> if (last != '[') return false
                }
                stack.pop()
            }
        }
    }
    return stack.isEmpty()
}


private val inputList = listOf(
    "()" to true,
    "()[]{}" to true,
    "(]" to false,
    "((" to false
)


