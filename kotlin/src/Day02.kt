import java.security.InvalidAlgorithmParameterException

fun main() {
    val input = readInput("day2")
    val value1 = partOne(input)
    val value2 = partTwo(input)
    println(value1)
    println(value2)
}


fun partOne(input: List<String>): Int = parseCommands(input).reduce { acc, commandLength ->
    val command = commandLength.keys.first()
    val length = commandLength.values.first()

    val vertical = acc.getVertical()
    val forward = acc.getForward()

    when (command) {
        "up" -> acc["vertical"] = vertical + length * (-1)
        "down" -> acc["vertical"] = vertical + length
        else -> acc["forward"] = forward + length
    }
    acc
}.let { it.getForward() * it.getVertical() }


fun partTwo(list: List<String>): Int {
    var aim = 0
    listOf<String>(

    )
    return parseCommands(list).reduce { acc, commandLength ->
        val command = commandLength.keys.first()
        val length = commandLength.values.first()

        val vertical = acc.getVertical()
        val forward = acc.getForward()
        when (command) {
            "up" -> aim -= length
            "down" -> aim += length
            else -> {
                acc["vertical"] = vertical + length * aim
                acc["forward"] = forward + length
            }
        }
        acc
    }.let { it.getForward() * it.getVertical() }
}


private fun MutableMap<String, Int>.getForward(): Int = getOrDefault("forward", 0)

private fun MutableMap<String, Int>.getVertical(): Int = getOrDefault("vertical", 0)

private fun parseCommands(list: List<String>) = list.map { text ->
    val command = "\\w+".toRegex().find(text)?.value?.trim() ?: throw InvalidAlgorithmParameterException()
    val length = text.replace(command, "").trim().toInt()
    command to length
    mutableMapOf(command to length)
}
