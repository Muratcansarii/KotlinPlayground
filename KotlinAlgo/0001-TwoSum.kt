fun twoSum(nums: IntArray, target: Int): IntArray {
    val previous = mutableMapOf<Int, Int>()
    for ((i, num) in nums.withIndex()) {
        previous[num]?.let { prevIndex ->
            return intArrayOf(i, prevIndex)
        }
        previous[target - num] = i
    }
    throw AssertionError(previous.toString())
}
