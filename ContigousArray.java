class Solution {
    public int findMaxLength(int[] nums) {
        int rs=0;
        int max=0;
        HashMap<Integer, Integer> m=new HashMap<>();
        m.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                rs--;
            }
            else{
                rs++;
            }

            if(m.containsKey(rs))
            {
                
                max=Math.max(max, i-m.get(rs));
            }
            else{
                m.put(rs,i);
            }
        }
        return max;
    }
}