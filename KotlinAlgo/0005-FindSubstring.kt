class PartialResult(
    val start: Int,
    private var pos: Int,
    startWord: String,
    private val toFind: Int,
    private val charWordMap: Map<Char, List<String>>,
    wordCountMap: MutableMap<String, Int>,
) {
    private var currentWord = startWord
    private val ownWords = wordCountMap
        .also { it.compute(startWord) { _, v -> v!! - 1 } }
    private var valid = false

    fun checkValid(): Boolean {
        if (valid) return true
        if (++pos - start == toFind) {
            valid = true
            return true
        }
        return false
    }

    /**
     * Whether I should keep on living
     */
    fun inc(c: Char, iterator: MutableIterator<PartialResult>, newResults: MutableList<PartialResult>) {
        if (checkValid()) return
        if ((pos - start) % currentWord.length == 0) {
            var continued: String? = null
            for (candidate in charWordMap[c] ?: return iterator.remove()) {
                val candidateCount = ownWords[candidate] ?: 0
                if (candidateCount > 0) {
                    if (continued == null) {
                        if (candidateCount == 1) {
                            ownWords.remove(candidate)
                        } else {
                            ownWords[candidate] = candidateCount - 1
                        }
                        currentWord = candidate
                        continued = candidate
                    } else {
                        val splitWords = ownWords.toMutableMap()
                        splitWords.compute(continued) { _, v -> (v ?: 0) + 1 }
                        newResults.add(PartialResult(start, pos, candidate, toFind, charWordMap, splitWords))
                    }
                }
            }
            if (continued == null) {
                return iterator.remove()
            }
        } else if (currentWord[(pos - start) % currentWord.length] != c) { // check that the current word keeps matching
            // die
            return iterator.remove()
        }
    }
}

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val len = words[0].length * words.size
    if (len > s.length) return emptyList()
    val wordMap = words.groupBy { it[0] }.mapValues { (_, v) -> v.distinct() }
    val wordCountMap = words.groupingBy { it }.eachCount()
    val results = mutableListOf<PartialResult>()
    for (i in s.indices) {
        val newResults = mutableListOf<PartialResult>()
        val it = results.iterator()
        while (it.hasNext()) {
            it.next().inc(s[i], it, newResults)
        }
        results += newResults

        if (i <= s.length - len) {
            // get all words that start with this letter
            wordMap[s[i]]?.forEach { results += PartialResult(i, i, it, len, wordMap, wordCountMap.toMutableMap()) }
        }
    }
    return results.asSequence()
        .filter { it.checkValid() }
        .map { it.start }
        .distinct()
        .toList()
}
