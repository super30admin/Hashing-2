//TC = O(n)
//SC = O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int rSum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums)
        {
            rSum+=num;
            int target = rSum - k;
            if(map.containsKey(target))
            {
                count+=map.get(target);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
            
        }
        return count;
    }
}