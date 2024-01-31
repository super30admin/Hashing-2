// Time Complexity :o(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// approach: using running sum when the sum is repeated check it in the hashmap at what index it is repeated and compare it with the max


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int max=0;
        int rSum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rSum--;
            }else{
                rSum++;
            }
            if(map.containsKey(rSum)){
                max=Math.max(max,i-map.get(rSum));
            }else{
                map.put(rSum,i);
            }

        }
        return max;
    }
}