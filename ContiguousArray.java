// Time Complexity : O(n^2)- Brute force, n is the size of array
// Space Complexity : O(1)-constant space
// Did this code successfully run on Leetcode : No, Got TLE error
// Any problem you faced while coding this : Can't think about the optimal Solution


// Your code here along with comments explaining your approach
/*
just traversing whole array for each element and checking whether zerosCount and onesCount is equal or not.
*/


class Solution18 {
    public int findMaxLength(int[] nums) {
        
        //TC -O(n^2)
        //SC -O(1);
        //Error : TLE
        
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int maxLen = Integer.MIN_VALUE;
        int zeroCount = 0;
        int onesCount = 0;
        
        for(int i=0;i<nums.length;i++){
            zeroCount =onesCount = 0;
            for(int j=i;j<nums.length;j++){
                
                if(nums[j]==1){
                    zeroCount++;
                }else{
                    onesCount++;
                }
                
                if(zeroCount==onesCount){
                    maxLen = Math.max(maxLen,j-i+1);
                }
                
            }
        }
      
        return maxLen==Integer.MIN_VALUE ? 0:maxLen;//Needs to be checked if only 1s or zeros are there then initial maxLen will not be updated and will return Integer.MIN_LEN as max length.But I have to return 0
    }
}