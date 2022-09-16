//SC : O(n)
//TC : O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int result = 0;
        hmap.put(0,1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(hmap.containsKey(sum - k))
                result = result + hmap.get(sum - k);
            if(hmap.containsKey(sum))
                hmap.put(sum, hmap.get(sum)+1);
            else
                hmap.put(sum, 1);
        }
        return result;
        
    }
}
