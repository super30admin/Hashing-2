/* Time Complexity O(n) 
Space Complexity O(n) */

class Solution {

    public int findMaxLength(int[] nums) {

        HashMap<Integer,Integer> map=new HashMap<>();

        int rsum=0;

        int max=0;

        map.put(0,-1);

        for(int i=0;i<nums.length;i++){

            if(nums[i]!=0) rsum+=1;

            else rsum-=1;

            if(map.containsKey(rsum))

               max=Math.max(max,i-map.get(rsum));
            
            else
            
                map.put(rsum,i);
            
        }

        return max;

    }

}