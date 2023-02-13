class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 1) {
            return listOf("()")
        }
        val newPset: MutableList<String> = mutableListOf()
        for (str in generateParenthesis(n - 1)) {
            for (i in 1..str.length) {
                val newStr = str.substring(0, i) + "()" + str.substring(i, str.length)
                newPset.add(newStr)
            }
        }
        return newPset.distinct()
    }
}