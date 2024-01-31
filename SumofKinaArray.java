// Time Complexity :o(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// approach: perform the running sum and using the hashmap when ever the we get sum at each index - target if have that num in hash map inscrease it by 1 else put the values in hash map. if the rsum-target is there in the map then increase the count by the number of times the rsum has repeated.
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum=0;
        for(int i=0;i<nums.length;i++){
            rSum+=nums[i];
            int y=rSum-k;
            if(map.containsKey(y)){
             count+=map.get(y);
            }
            if(!map.containsKey(rSum)){
                map.put(rSum,1);
            }else{
                map.put(rSum,map.get(rSum)+1);
            }
        }
     return count;
    }
}