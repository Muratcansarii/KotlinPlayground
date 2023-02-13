fun plusOne(digits: IntArray): IntArray {
    if (digits.all { it == 9 }) {
        return IntArray(digits.size + 1) { 0 }.also { it[0] = 1 }
    }
    var i = digits.size - 1
    while (i >= 0) {
        if (digits[i] == 9) {
            digits[i] = 0
        } else {
            digits[i]++
            return digits
        }
        i--
    }
    error("Should not reach this")
}
