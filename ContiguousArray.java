// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Algorithm was difficult to grasp.

// Your code here along with comments explaining your approach

import java.util.HashMap;

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                nums[i] = -1;
        }
            
        int sum = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
          
            sum = sum + nums[i];

            if(sum == 0){
                maxLength = i+1;
            }

            if(hmap.containsKey(sum + nums.length)){
                if(maxLength < i - hmap.get(sum + nums.length)){
                    maxLength = i - hmap.get(sum + nums.length);
                }
            }
            else{
                hmap.put(sum+nums.length, i);
            }                        
        }
        return maxLength;
    }
    public static void main(String[] args){
        System.out.println("Contiguous Array");
        ContiguousArray obj = new ContiguousArray();
        int[] nums = {1,0,1,1,0};
        System.out.println(obj.findMaxLength(nums));
    }
}