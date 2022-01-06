//Input: ransomNote = "a", magazine = "b"
//Output: false
fun main() {
    inputList.forEach { (input, answer) ->
        val isCorrect = RansomNote.canConstruct(input.ransomNote, input.magazine) == answer
        if (!isCorrect) {
            throw Error("Wrong!\nInput: $input\t Answer: $answer")
        } else {
            println("Correct!\nInput: $input\t Answer: $answer")
        }
    }
}

private object RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        var counter = 0
        val magazineText = hashMapOf<String, Int>()
        magazine.map { it.toString() }.forEach { char ->
            if (magazineText.getOrDefault(char, 0) > 0) {
                val get: Int = magazineText[char]!!
                magazineText[char] = get + 1
            } else {
                magazineText[char] = 1
            }
        }

        ransomNote.map { it.toString() }.forEach { char ->
            if (magazineText.getOrDefault(char, 0) > 0) {
                val newValue = magazineText[char]!! - 1
                magazineText[char] = newValue
                counter++
            }
        }
        return (counter == ransomNote.length)
    }
}


private val inputList = listOf(
    RansomNoteInput(
        ransomNote = "a",
        magazine = "b",
    ) to false,
    RansomNoteInput(
        ransomNote = "aa",
        magazine = "ab",
    ) to false,
    RansomNoteInput(
        ransomNote = "aa",
        magazine = "aab",
    ) to true,
    RansomNoteInput(
        ransomNote = "aab",
        magazine = "baa",
    ) to true,

    )

private data class RansomNoteInput(val ransomNote: String, val magazine: String)
