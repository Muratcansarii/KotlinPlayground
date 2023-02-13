class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return nums1.plus(nums2).apply { sort() }.median() ?: 0.0
    }

    private fun IntArray.median(): Double? {
        if (this.isEmpty()) {
            return null
        }
        return if (size % 2 == 1) {
            this[size / 2].toDouble()
        } else {
            (this[(size / 2) - 1] + this[size / 2]) / 2.0
        }
    }
}