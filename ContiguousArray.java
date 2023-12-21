// Time Complexity : O(n)
// Space Complexity : O(n)
// Method : Hashing

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap();
        int rSum = 0, result = 0;

        map.put(0, -1);

        for(int i = 0; i < nums.length; i++)
        {
            rSum = (nums[i] == 1) ? rSum + 1 : rSum - 1;

            if(!map.containsKey(rSum)) map.put(rSum, i);

            else result = Math.max(result, i - map.get(rSum));
        }

        return result;
    }
}