

import org.junit.jupiter.api.Test

fun compressString(word: String): String {
    val compressedString = StringBuilder()
    var consecutiveCount = 0

    for (i in word.indices) {
        consecutiveCount++
        if(i + 1 >= word.length || word[i] != word[i + 1]) {
            compressedString.append(word[i])
            compressedString.append(consecutiveCount)
            consecutiveCount = 0
        }
    }
    return compressedString.toString()
}

class CompressStringTest {
    @Test
    fun test() {
        assert(compressString("aabcccccaaa") == "a2b1c5a3")
        assert(compressString("abcdef") == "a1b1c1d1e1f1")
    }
}