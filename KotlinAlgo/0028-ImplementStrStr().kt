class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val hn = haystack.length
        val nn = needle.length
        if (hn == 0 && nn == 0) {
            return 0
        }
        if (hn == 0) {
            return -1
        }
        if (nn == 0) {
            return 0
        }
        return haystack.indexOf(needle)
    }
}