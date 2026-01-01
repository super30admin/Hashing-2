//TimeComplexity O(n)
//SpaceComplexity O(n)
//In this problem we need to find balanced array of 0 or 1, we keep a running sum where we decrement when we observe 0 and increment when we observe 1
// if the map already contains the running sum, it means we have found a balanced subarray. we check the max of index where we have found the subarray. 

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = mutableMapOf<Int,Int>().apply {
            put(0, -1)
        }

        var max = 0
        var rSum = 0
        for (i in 0..nums.size - 1) {
            val num = nums[i]
            if (num == 0) rSum--
            else rSum++

            if(map.containsKey(rSum)) {
                max = Math.max(max, i - map.getOrDefault(rSum, 0))
            } else {
                map.put(rSum, i)
            }
        }
        return max
    }
}