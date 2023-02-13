class Solution {
    fun reverse(x: Int): Int {
        var res = 0
        var x2 = x
        while (x2 != 0) {
            if (res * 10 / 10 != res) {
                return 0
            }
            res = res * 10 + x2 % 10
            x2 = x2 / 10
        }
        return res
    }
}