fun main() {

    inputList.forEach { (input, answer) ->
        val twoSum = twoSum(input.nums, input.target)
        val isCorrect = twoSum.contentEquals(answer)
        if (!isCorrect) {
            throw Error("Wrong!\nInput: ${input.nums.contentToString()} ${input.target} \t Answer: ${twoSum.contentToString()}")
        } else {
            println("Correct!\nInput: ${input.nums.contentToString()} ${input.target} \t Answer: ${twoSum.contentToString()}")
        }
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numMap = hashMapOf<Int, Int>()
    for (index in nums.indices) {
        val complement = target - nums[index]
        if (numMap.containsKey(complement)) {
            return intArrayOf(numMap[complement]!!, index)
        }
        numMap[nums[index]] = index
    }
    throw Error("Could not find it")
}

private val inputList = listOf(
    TwoSumInput(
        nums = intArrayOf(2, 7, 11, 15),
        target = 9,
    ) to intArrayOf(0, 1),
    TwoSumInput(
        nums = intArrayOf(3, 2, 4),
        target = 6,
    ) to intArrayOf(1, 2),
    TwoSumInput(
        nums = intArrayOf(3, 3),
        target = 6,
    ) to intArrayOf(0, 1),
)

private class TwoSumInput(val nums: IntArray, val target: Int)
