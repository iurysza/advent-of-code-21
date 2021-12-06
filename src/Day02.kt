import java.security.InvalidAlgorithmParameterException

fun main() {
    val input = readInput("day2")
    val value1 = partOne(input)
    val value2 = partTwo(input)
    println(value1)
    println(value2)
}


fun partOne(list: List<String>): Int = mapCommands(list).reduce { acc, commandLength ->
    val command = commandLength.keys.first()
    val length = commandLength.values.first()

    val vertical = acc.getOrDefault("vertical", 0)
    val forward = acc.getOrDefault("forward", 0)
    when (command) {
        "up" -> {
            acc["vertical"] = vertical + length * (-1)
        }
        "down" -> {
            acc["vertical"] = vertical + length
        }
        else -> {
            acc["forward"] = forward + length
        }
    }
    acc
}.let {
    it.getOrDefault("forward", 0) * it.getOrDefault("vertical", 0)
}


fun partTwo(list: List<String>): Int {
    var aim = 0
    return mapCommands(list).reduce { acc, commandLength ->
        val command = commandLength.keys.first()
        val length = commandLength.values.first()

        val vertical = acc.getOrDefault("vertical", 0)
        val forward = acc.getOrDefault("forward", 0)
        when (command) {
            "up" -> {
                aim -= length
            }
            "down" -> {
                aim += length
            }
            else -> {
                acc["vertical"] = vertical + length * aim
                acc["forward"] = forward + length
            }
        }
        acc
    }.let {
        it.getOrDefault("forward", 0) * it.getOrDefault("vertical", 0)
    }
}

private fun mapCommands(list: List<String>) = list.map { text ->
    val command = "\\w+".toRegex().find(text)?.value?.trim() ?: throw InvalidAlgorithmParameterException()
    val length = text.replace(command, "").trim().toInt()
    command to length
    mutableMapOf(command to length)
}
