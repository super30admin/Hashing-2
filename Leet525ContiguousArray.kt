// Time Complexity :O(n) scanning all
// Space Complexity :0(n) storing all
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//line 48 to 44
// line 18 took bit exploring but then was able to write it in kotlin way
class Solution {
    fun findMaxLength(nums: IntArray): Int {
        //nested operations identified
        val map = mutableMapOf<Int,Int>() //rSum, index
        map[0] = -1
        var max = 0
        var rSum = 0
        for(i in 0 until nums.size){
            val n = nums[i]
            rSum += if(n == 0) -1 else 1
            //if we have seen that rSum before or Not is seen get will give non null index
            val seenIndex = map.getOrPut(rSum){i}
            //if seen then current - previous
            if(seenIndex != null){
                max = max(max, i - seenIndex)
            }
        }
        return max
    }
}

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        //nested operations identified
        val map = mutableMapOf<Int,Int>() //rSum, index
        map[0] = -1
        var max = 0
        var rSum = 0
        for(i in 0 until nums.size){
            val n = nums[i]
            rSum += if(n == 0) -1 else 1
            //if we have seen that rSum before then current index vs last seen index

            if(map.containsKey(rSum)){
                max = max(max, i - map[rSum]!!)
            }else{
                map[rSum] = i
            }
        }
        return max
    }
}