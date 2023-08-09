//TC:O(n)
//SC:O(n)
import java.util.HashMap;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count = 0;
        int sum = 0;
        hmap.put(0, 1);
        for(int i = 0; i<nums.length; i++){
            sum = sum + nums[i];
            if(hmap.containsKey(sum-k)){
                count = count + hmap.get(sum-k);
            }
            if(hmap.containsKey(sum)){
                hmap.put(sum, hmap.get(sum)+1);
            }
            else {
                hmap.put(sum, 1); }
        }
        return count;
    }
}