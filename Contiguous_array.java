import java.util.HashMap;

public class Contiguous_array {
    
    public int findMaxLength(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int runningSum = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                runningSum += -1;
            }else{
                runningSum += 1;
            }
            if(map.containsKey(runningSum)){
                max = Math.max(max, i - map.get(runningSum));
            }else{
                map.put(runningSum, i);
            }
        }
        return max;
        

    }


    public static void main(String[] args) {
        Contiguous_array ca = new Contiguous_array();
        int[] nums = {1,0,1,0,1,1,1,0,0,0,0};
        System.out.println(ca.findMaxLength(nums));
    }
}
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Explanation:
// We use a HashMap to store the running sum and its corresponding index.
// We iterate through the array and update the running sum by adding -1 for 0 and +1 for 1.
// If the running sum has been seen before, it means that the subarray between the previous index and the current index has an equal number of 0s and 1s, so we calculate the length of this subarray and update the maximum length if necessary.
// If the running sum has not been seen before, we add it to the HashMap with the current index. 
// Finally, we return the maximum length of the contiguous array with equal number of 0s and 1s.            