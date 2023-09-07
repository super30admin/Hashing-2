

// Time complexity : O(n)
//space complexity :O(n)
// Did the code pass all test cases in  the leetcode : Yes
//Any problem you faced while coding this : No
import java.util.HashMap;

class Problem1 {
    public int subarraySum(int[] nums, int k) {
        int rSum=0;
        int cnt=0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            rSum += nums[i];
            if(map.containsKey(rSum - k)){
                cnt += map.get(rSum -k);
            }
            map.put(rSum,map.getOrDefault(rSum,0)+1);
        }
        return cnt;
    }
}