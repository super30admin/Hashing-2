// Time Complexity : O(n) where n is the number of integers present in list
// Space Complexity : O(n) to store the keys
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    fun findMaxLength(nums: IntArray): Int {

        var rSum = 0

        var max = 0

        var hashMap = HashMap<Int, Int>()

        hashMap.put(0, -1)

        for(i in 0..nums.size-1){
            if (nums.get(i) == 0){
                rSum -= 1
            }
            else{
                rSum += 1
            }

            if(hashMap.containsKey(rSum)){
                max = Math.max(max, (i - hashMap.get(rSum)!!))
            }
            else{
                hashMap.put(rSum, i)
            }
        }

        return max

    }
}