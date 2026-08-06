

// Contguous Subarray with equal number of 1 and 0
//Time complexity: O(n)
// Space Complexity: O(n)

// assigning values 1 and -1 to to 1 and 0 , so we can easily understand the number of zeroes and ones


class Solution {
    public int findMaxLength(int[] nums) {

        // saves the runSum and the index value
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int runSum = 0;
        // to cover a edge case when we want to check length of subarray we need to cover it from index 0 
        map.put(0,-1);

        int maxLength = 0;
        int value;

        for(int i = 0; i< nums.length; i ++){

         if(nums[i] == 0){
            value = 1;

         } else {
            value = -1;
         }
          runSum = runSum + value;
          if(runSum == 0 ){
            maxLength = Math.max(maxLength, i - map.get(0));
          } else if(map.containsKey(runSum)){
            maxLength = Math.max(maxLength , i - map.get(runSum));
          } else {
            map.put(runSum , i);
          }
            
        }
    return maxLength;


        }
        
    
}