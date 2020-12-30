// Time Complexity : O(n^2)- Brute force, n is the size of array
// Space Complexity : O(1)-constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Can't think about the optimal Solution


// Your code here along with comments explaining your approach
/*
just traversing whole array for each element and checking whether sum of each element == k or not.
*/


class Solution17 {
    public int subarraySum(int[] nums, int k) {
        
        if(nums==null || nums.length==0){
            return 0;
        }
        
        //O(n^2)
        int count = 0;
        int sum;
        for(int i=0;i<nums.length;i++){
            sum = 0;//have to reset every time on moving i pointer
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                
                if(sum==k){
                   count++;   
                }
                
            }
        }
        
        return count;
    }
}