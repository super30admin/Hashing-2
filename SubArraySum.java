//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : yes

/*Approach
1. Find the running sum of the array at each position while traversing linearly and store its occurrence in a hashmap
2. Check if complement of current running sum and target has already occurred. If yes that means subarray with sum equals target exists
3. Increase the result counter by number of times the complement has occurred.
 */
class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map= new HashMap<>();

        int rSum=0;
        int res=0;

        map.put(0,1);
        for(int i=0;i<nums.length;i++){

            rSum+=nums[i];
            int complement=rSum-k;
            if(map.containsKey(complement))
                res+=map.get(complement);

            map.put(rSum, map.getOrDefault(rSum,0)+1);
        }

        return res;

    }
}