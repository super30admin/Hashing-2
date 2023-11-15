// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


/* find the running sum at each index when its 1 ++ 0 -- */
/* at each store check wheather the map has the rsum if so set the max from that index to previous rsum occurance index/
/*or else insert rsuma and its index, as we are checking before only first rsum occurance is stored */
/*put deafault key 0 and value -1 for edge cases */


import java.util.HashMap;

public class Problem2 {

        public static int findMaxLength(int[] nums) {
        int max = 0;
        int rSum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i< nums.length ; i++){
            if(nums[i] == 0){ 
                rSum--;
                }else{
                     rSum++;
                }
             if(map.containsKey(rSum)){
                max = Math.max(max,i - map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        return max;
    }

    public static void main(String[] arg) {
        int[] nums = new int[]{0,1,0};
    
        System.out.println(findMaxLength(nums));
    }
    
}
