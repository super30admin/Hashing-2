//TC: O(n)
//SC: O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //dummy node with index -1
        
        int rSum = 0;
        int maxLen = 0;
        
        for(int i=0;i<nums.length;i++){
           
            if(nums[i] == 0){
                rSum--;
            }else{
                rSum++;
            }
             if(map.containsKey(rSum)){
                 maxLen = Math.max(maxLen, i-map.get(rSum));
             }else{
                 map.put(rSum, i);
             }
        }
        
        return maxLen;
    }
}
