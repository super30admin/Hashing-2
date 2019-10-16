//Brute force solution
//Time Complexity: O(n^2)

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count =0; //initial count 0
        
        for(int i = 0;i<nums.length;i++){
            
            int sum = nums[i];
            
            if(sum == k)
                count++;
            
            for(int j=i+1;j<nums.length;j++){ //Add continuous numbers
                
                sum  = sum + nums[j];
                
                if(sum == k)
                    count++;
            }
        }
        
       return count; 
        
    }
}
