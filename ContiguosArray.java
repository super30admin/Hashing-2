import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we use a hashmap to store the running sum as key and the index that it occured at as values. First we add (0,-1) 
//to the map to check the initial subarray. For each 0 nwe reduce the sum by 1 and for each 1 we add 1 to the sum. Then we check if the rsum
//is present in the map if not we add it with its index. If it is there we take the max of the previous result and the one obtained by\
//subtracting the value at rsum key of the map from the index. Then we return the result.

public class ContiguosArray {
    
        public int findMaxLength(int[] nums) {
            if(nums == null || nums.length== 0) return 0;
    
            HashMap<Integer,Integer> map = new HashMap<>();
            int rSum =0;
            map.put(0,-1);
            int result = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 0){
                    rSum--;
                }else{
                    rSum++;
                }
                if(!map.containsKey(rSum)){
                    map.put(rSum,i);
                }else{
                    result = Math.max(result, i-(map.get(rSum)));
                }
                
            }
    
            return result;
        }
    
    
}
