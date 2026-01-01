//Time Complexity O(n)
//Space Complexity O(n)
//In this problem we keep a running Sum and check if runningSum - k (target) has already occured in the hasmap before. If it has we increase the count and return the number of subarrays. 
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {

        val prefixSum = mutableMapOf<Int,Int>().apply {
            put(0, 1)
        }

        var count = 0
        var runningSum = 0

        for(n in nums) {
            runningSum = runningSum + n
            count += prefixSum.getOrDefault(runningSum - k, 0)
            prefixSum.put(runningSum, prefixSum.getOrDefault(runningSum, 0) + 1)
        }
        return count
    }
}