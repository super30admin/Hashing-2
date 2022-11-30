// Time Complexity : O(n)
// Space Complexity : O(1)

//https://leetcode.com/problems/contiguous-array
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen=0;
        int rSum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            rSum = nums[i] == 1 ? ++rSum : --rSum;
            if(map.containsKey(rSum)){
                if(i-map.get(rSum)>maxLen){
                    maxLen=i-map.get(rSum);
                }
            }else{
                map.put(rSum,i);
            }
        }
        return maxLen;
    }
}
