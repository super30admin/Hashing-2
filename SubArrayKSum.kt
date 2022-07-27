// Time Complexity : O(n) where n is the number of integers present in the list
// Space Complexity : O(n) that takes space to store the keys
// Did this code successfully run on LeetCode : yes
// Any problem you faced while coding this : no


class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {

        var total = 0
        val hashMap = HashMap<Int, Int>()
        hashMap.put(0, 1)
        var rSum = 0

        for(i in 0..nums.size -1){

            rSum += nums.get(i)

            if( hashMap.containsKey(rSum - k)){
                total += hashMap.get(rSum -k)!!
            }

            if(hashMap.containsKey(rSum)){
                hashMap[rSum]  = hashMap[rSum]!! + 1
            }else{
                hashMap.put(rSum, 1)
            }

        }

        return total

    }
}