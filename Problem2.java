class Solution {
    public int findMaxLength(int[] nums) 
    {
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=0;
        int rsum=0;
       
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            if(num==0)
            {
                rsum--;
            }
            else{
                rsum++;
            }

            if(map.containsKey(rsum)){
                max = Math.max(max,i-map.get(rsum));
            }
            else{
                map.put(rsum,i);
            }


        }
        return max;
    }
}
