class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            while (i < j && !s[i].isLetterOrDigit()) {
                i++
            }
            while (i < j && !s[j].isLetterOrDigit()) {
                j--
            }
            if (s[i++].toLowerCase() != s[j--].toLowerCase()) {
                return false
            }
        }
        return true
    }
}