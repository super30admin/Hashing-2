class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int add=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                add+=nums[j];
                if(add==k)   count++;
             
            }
            add=0;
        }
        return count;
    }
}