//Space complexity O(n)
//Time complexity O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
               if(map.containsKey(sum-k))
            {
count+=map.get(sum-k);
            }
            if(map.containsKey(sum))
            {
                map.put(sum,map.get(sum)+1);
            }
            else
            {
                map.put(sum,1);
            }
         

        }
        return count;
    }
}