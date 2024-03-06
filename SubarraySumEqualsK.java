import java.util.HashMap;
// tc = o(n)
//sc = o(n)

//iterate through array and calculate cumulative sum and add it to the map if it is unique or update frequency for repeated ones.Also check if sum - k exists in the map. 
// get the frequency and update the count
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //important
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            int target = sum - k;
            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}