/**
 * Leet code 525
 */
class Solution {
    public int findMaxLength(int[] nums) {
        // rSum of index, index of nums
        Map<Integer,Integer> mapping = new HashMap<Integer,Integer>();
        int maxLength = 0;
        int[] rSum = computeRSum(nums);
        mapping.put(0,-1);
        for (int i=0;i<nums.length;i++)
        {
            if(!mapping.containsKey(rSum[i]))
            {
                mapping.put(rSum[i],i);
            }
            else
            {
                int prevIndex = mapping.get(rSum[i]);
                maxLength = Math.max(maxLength,(i-prevIndex));
            }
        }
        return maxLength;
    }
    private int[] computeRSum(int[] nums)
    {
        int[] rSum = new int[nums.length];
        //rSum[0] starts out as 0; if nums[0] is 1 add 1 else subtract 1
        //At 0th index we consider the value of the 0th index (not -1 index) and add/subtract accordingly
        //Another thought process:If value is 0 do we keep value at index 0 as 0(implying that its uninitialized??)
        //Base case
        rSum[0] = nums[0] == 1 ? 1 : -1;
        for (int i=1;i<nums.length;i++)
        {
            if(nums[i] == 1)
                rSum[i] = rSum[i-1] + 1;
            if(nums[i] == 0)
                rSum[i] = rSum[i-1] - 1;
        }
        return rSum;
    }  
}