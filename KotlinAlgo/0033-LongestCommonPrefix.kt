class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        return if (strs.size == 0) {
            ""
        } else {
            strs.reduce { a, b ->
                a.commonPrefixWith(b)
            }
        }
    }
}