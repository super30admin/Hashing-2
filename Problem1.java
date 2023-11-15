// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/* find the running sum at each index and store it map with frequncy */
/* at each store check whther the map has the diff between rsum and k , if so their frequenct is added to count as number of subarrays from that point*/
/*put deafault key 0 and value 1 for edge cases */


import java.util.HashMap;

public class Problem1 {

        public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int rsum = 0;
        map.put(0,1);
        for(int i = 0 ; i< nums.length ; i++){
           rsum += nums[i];
           if(map.containsKey(rsum-k)){
              count += map.get(rsum-k);
           }
           if(map.containsKey(rsum)){
              map.put(rsum,map.getOrDefault(rsum,0)+1);
           }else{
               map.put(rsum,1);
           }

        }
        return count;
    }

    public static void main(String[] arg) {
        int[] nums = new int[]{1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }
    
}
