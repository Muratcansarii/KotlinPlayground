class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        var i = nums.size - 1
        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                val next = findNextInt(nums, i - 1)
                val temp = nums[i - 1]
                nums[i - 1] = nums[next]
                nums[next] = temp
                nums.sort(i, nums.size)
                return
            }
            i--
        }
        nums.reverse()
    }

    private fun findNextInt(nums: IntArray, i: Int): Int {
        val v = nums[i]
        var minDiff = Int.MAX_VALUE
        var minIndex = i + 1
        for (j in i + 1 until nums.size) {
            if (nums[j] > v && nums[j] - v < minDiff) {
                minDiff = nums[j] - v
                minIndex = j
            }
        }
        return minIndex
    }
}