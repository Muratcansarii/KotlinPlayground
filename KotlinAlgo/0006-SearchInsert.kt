fun searchInsert(nums: IntArray, target: Int): Int {
    if (target <= nums.first()) return 0
    if (target > nums.last()) return nums.size

    var left = 0
    var right = nums.size

    while (left <= right) {
        val mid = (left + right) shr 1
        val current = nums[mid]

        when {
            target == current -> return mid
            target < current -> right = mid - 1
            else -> left = mid + 1
        }
    }
    return left
}
