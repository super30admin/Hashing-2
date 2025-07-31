// Time Complexity :O(n) scanning all
// Space Complexity :0(n) storing all
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//line 18
//line 22
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        //since we see nested operations we should think in two pointers, running sum or sliding window apprococh
        val map = mutableMapOf<Int, Int>() //rSum, freq
        map[0] = 1 // we have
        var count = 0
        var rSum = 0
        for(i in 0 until nums.size){
            rSum += nums[i]
            val comp = rSum - k
            //have we seen this comp value
            // in kotlin map[] is optional so "?:" is just getOr "0" here
            count += map[comp]?:0

            // in both case seen or unseen update the rSum Hashmap for the occurance
            map[rSum] = (map[rSum]?: 0) + 1
        }
        return count
    }
}