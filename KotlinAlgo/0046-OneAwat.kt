

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertFalse

fun oneEditAway(a: String, b: String): Boolean {
    val aLength = a.length
    val bLength = b.length
    if (abs(aLength - bLength) > 1)
        return false

    var shorterString = a
    var longerString = b

    if (aLength > bLength) {
        shorterString = b
        longerString = a
    } else {
        shorterString = a
        longerString = b
    }

    var shortIndex = 0
    var longIndex = 0
    var foundDifference = false
    while (shortIndex < shorterString.length && longIndex < longerString.length) {
        if (shorterString[shortIndex] != longerString[longIndex]) {
            if (foundDifference) {
                return false
            }
            foundDifference = true
            if (aLength == bLength) {
                shortIndex++
            }
        } else {
            shortIndex++
        }
        longIndex++
    }
    return true
}

class OneAwayTest() {
    @Test
    fun test() {
        compareEdits("pales", "pale", true)
        compareEdits("pale", "ple", true)
        compareEdits("pale", "bale", true)
        compareEdits("pale", "bake", false)
    }

    private fun compareEdits(wordA: String, wordB: String, isTrue: Boolean) {
        if (isTrue) {
            assert(oneEditAway(wordA, wordB)) {
                "Testing $wordA, $wordB"
            }
        } else {
            assertFalse(oneEditAway(wordA, wordB), "Testing $wordA, $wordB")
        }
    }
}