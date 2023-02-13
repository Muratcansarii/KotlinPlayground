class Solution {
    fun longestValidParentheses(s: String): Int {
        val validTag = BooleanArray(s.length) { false }
        val stack = arrayListOf<Int>()
        for (i in 0 until s.length) {
            if (s[i] == '(') {
                stack.add(i)
            } else {
                if (stack.isNotEmpty()) {
                    val index = stack.removeAt(stack.size - 1)
                    validTag[index] = true
                    validTag[i] = true
                }
            }
        }
        var totalMax = 0
        var curMax = 0
        validTag.forEach {
            if (it) {
                curMax++
            } else {
                totalMax = Math.max(totalMax, curMax)
                curMax = 0
            }
        }
        totalMax = Math.max(totalMax, curMax)
        return totalMax
    }
}