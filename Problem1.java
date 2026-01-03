import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int rsum=0;
        int n= nums.length;
        int count = 0;
        HashMap <Integer,Integer> map=new HashMap<>();

        map.put(0,1);

        for(int i=0; i<n;i++){
            rsum += nums[i];
            //if map conatins y (for ex y = x-z) then increase the count as per frequency
            if(map.containsKey(rsum - k)){
                count+= map.get(rsum-k);
            }
            //put (rsum and frequency of rsum occcureance)
                map.put(rsum, map.getOrDefault(rsum, 0)+1);
        }
        return count;
    }
}