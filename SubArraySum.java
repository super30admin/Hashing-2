// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int count = 0, rSum = 0;
        map.put(0,1);
        for(int i = 0 ; i < nums.length; i ++){
            rSum = rSum + nums[i];
            if(map.containsKey(rSum - k)){
                count = count + map.get(rSum -k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        return count;
    }
}