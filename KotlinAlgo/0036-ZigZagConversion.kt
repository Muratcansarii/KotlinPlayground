class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        var res = mutableListOf<MutableList<Char>>()
        for (i in 0 until numRows) {
            res.add(mutableListOf())
        }
        for (i in s.indices) {
            val j = i % (2 * numRows - 2)
            if (j / numRows == 0) {
                res.get(j % numRows).add(s[i])
            } else {
                res.get(numRows - 1 - j % numRows - 1).add(s[i])
            }
        }
        val final = StringBuilder()
        for (i in res.indices) {
            val row = res.get(i)
            for (j in row.indices) {
                final.append(row.get(j))
            }
        }
        return final.toString()
    }
}