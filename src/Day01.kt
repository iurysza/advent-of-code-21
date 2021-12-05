fun main() {
    fun part1(input: List<Int>): Int = input
        .windowed(2)
        .count { (a, b) -> a < b }

    fun part2(input: List<Int>): Int = input
        .windowed(4)
        .count { window ->
            window[0] < window[3]
        }

    val input = readInputAsInt("day1-input")
    println(part1(input))
    println(part2(input))
}
