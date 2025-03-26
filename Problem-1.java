/* Using HashMap: Time complexity - O(n) & Space complexity - O(n) */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // rsum : count
        int rsum = 0;
        int res = 0;

        map.put(0, 1);
        for(int num : nums){
            rsum += num;
            int comp = rsum - k;
            if(map.containsKey(comp)){
                res += map.get(comp);
            }
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);  
        }

        return res;
    }
}