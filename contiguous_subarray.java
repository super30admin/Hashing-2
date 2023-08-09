class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> m =new HashMap<>();
        int rsum = 0;
        int result=0;
        m.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                rsum=rsum-1;
            }
            else
            {
                rsum=rsum+1;
            }
            if(m.containsKey(rsum))
            {
                result = Math.max(result,i-m.get(rsum));
            }
            else
            {
                m.put(rsum,i);
            }
        }
        return result;
    }
}