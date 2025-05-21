//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: using running sums technique and a hashmap to keep track of possible sums and their counts
// if for each sum in running sums, if we already saw a sum = current_sum - k, which means the subarray from where current_sum-k to current element =k
// maintain a count of all such subarrays
import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                res+=map.get(sum-k);
            }
            if(!map.containsKey(sum)){
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum)+1);
        }
        System.out.println(map);
        return res;
    }
}