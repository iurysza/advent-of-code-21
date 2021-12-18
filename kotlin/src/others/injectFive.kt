fun injectFive(n: Int): Int {
    val isNegative = n < 0
    val stringList = n.toString().toList()

    val start: String = buildString {
        stringList.forEachIndexed { index, digit ->
            if (isNegative) {
                if (index == 1) append(5)
            } else {
                if (index == 0) append(5)
            }
            append(digit)
        }
    }
    val middle: String = buildString {
        stringList.forEachIndexed { index, digit ->
            val listMid = (stringList.size / 2)
            var hasAdded = false
            if (index == listMid) {
                if (digit.digitToInt() > 5) {
                    hasAdded = true
                    append(5)
                    append(digit)
                } else {
                    append(digit)
                    append(5)
                }
                append(5)
            }
            if (!hasAdded) append(digit)
        }
    }
    val end: String = buildString {
        stringList.forEachIndexed { index, digit ->
            append(digit)
            if (index == stringList.size - 1) append(5)
        }
    }

    return listOf(start, middle, end).maxOf { it.toInt() }
}


/* ***** BOILERPLATE BELOW ***** */


// Test cases (you can add more cases here if you want)
val tests = mapOf(
    -999 to -5999,
    -299 to -2599,
    0 to 50,
    671 to 6751,
    278 to 5278,
    926 to 9526,
    999 to 9995,
)


// This code runs your test cases. Do not change or delete.
fun main() {
    var totalCorrect = 0.0
    val outputOk = StringBuilder()
    val outputFail = StringBuilder()

    tests.forEach { (input, expected) ->
        val result = try {
            injectFive(input)
        } catch (t: Throwable) {
            outputFail.append("· Failed for $input, ${t.message}:\n")
            Integer.MIN_VALUE
        }
        if (expected == result) {
            totalCorrect++
            outputOk.append("· N = $input -> $result\n")
        } else {
            outputFail.append("· N = $input -> $result (expected $expected)\n\n")
        }
    }

    println("Total successful: ${Math.floor(totalCorrect / tests.size * 100).toInt()}%\n")
    if (outputOk.isNotEmpty()) {
        println("[ OK ]\n")
        println(outputOk)
    }
    if (outputFail.isNotEmpty()) {
        println("[ Failed ]\n")
        println(outputFail)
    }
}
