// sınıflara bölündü insanoğlu..
class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits == "") {
            return listOf()
        }
        val res = ArrayList<String>()
        val digitMap = HashMap<Int, List<Char>>()
        for (digit in digits) {
            when (digit.toString().toInt()) {
                2 -> digitMap[2] = listOf('a', 'b', 'c')
                3 -> digitMap[3] = listOf('d', 'e', 'f')
                4 -> digitMap[4] = listOf('g', 'h', 'i')
                5 -> digitMap[5] = listOf('j', 'k', 'l')
                6 -> digitMap[6] = listOf('m', 'n', 'o')
                7 -> digitMap[7] = listOf('p', 'q', 'r', 's')
                8 -> digitMap[8] = listOf('t', 'u', 'v')
                9 -> digitMap[9] = listOf('w', 'x', 'y', 'z')
            }
        }
        val digitList = ArrayList<List<Char>>()
        for (digit in digits) {
            var num = digit.toString().toInt()
            digitList.add(digitMap[num]!!)
        }
        fill(res, digitList, 0, "")
        return res
    }

    private fun fill(res: ArrayList<String>, digitList: ArrayList<List<Char>>, level: Int, str: String) {
        if (level == digitList.size) {
            res.add(str)
            return
        } else {
            for (c in digitList[level]) {
                var strC = str + c.toString()
                fill(res, digitList, level + 1, strC)
                strC = strC.dropLast(1)
            }
        }
    }
}