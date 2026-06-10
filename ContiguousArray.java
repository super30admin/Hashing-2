// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int rSum = 0;    
        map.put(0, -1); // to cover base cases    
        for(int i = 0 ; i < nums.length; i++) {
            
            if(nums[i] == 1) {
                rSum +=1;
            } else {
                rSum -=1;
            }

            if(map.containsKey(rSum)) {
                maxLength = Math.max(maxLength, i - map.get(rSum));
            }
            else {
                map.put(rSum, i);
            }
               
        }
        return maxLength;
    }
}