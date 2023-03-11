//Time Complexity: O(n)
//Space Complexity:O(1)
//executed on leetcode : yes 


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int result =0 ;
        int rsum =0;

        for(int i=0; i< nums.length;i++)
        {
            rsum= rsum+nums[i];
            if(map.containsKey( rsum - k)){
                result+=map.get( rsum - k);
            }
            if(!map.containsKey(rsum))
            {
                map.put(rsum, 0);
            }

            map.put(rsum, map.get(rsum)+1);

        }
      return result; 
    }
}
