
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

fun isUnique(word: String): Boolean {
    val charSet = HashSet<Char>()
    for (char in word) {
        if(charSet.contains(char)) {
            return false
        }

        charSet.add(char)
    }

    return true
}

fun isUniqueSlow(word: String): Boolean {
    val sortedWordList = word.toList().sorted()
    for (i in 0 until sortedWordList.size - 1) {
        if(sortedWordList[i] == sortedWordList[i + 1]) {
            return false
        }
    }
    return true
}


class IsUniqueTest{
    @Test
    fun isUniqueFastTest() {
        var word: String = "abcdef"
        assert(isUnique(word))
        assert(isUniqueSlow(word))

        word = "tinmalt"
        assertFalse(isUnique(word))
        assertFalse(isUniqueSlow(word))
    }
}