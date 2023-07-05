// Time Complexity : Time complexity would be O(n) as we have to iterate over the array
// Space Complexity : Space complexity would be O(n) as there can be n number of elements in map
// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Using hashmap to keep track of the running sum. Everytime I iterate over an element, I calculate the running sum and find out running sum - k. If that is present in my hashmap then I increment the counter by 1. 

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int rsum = 0;
        map.put(0,1);
        int count = 0;

        for(int i=0;i<nums.length;i++){
            rsum = rsum + nums[i];
            int temp = rsum - k;
            if(map.containsKey(temp)){
                count = count + map.get(temp);
            }

            if(map.containsKey(rsum)){
                map.put(rsum, map.get(rsum)+1);
            }
            else{
                map.put(rsum, 1);
            }
        }

        return count;
    }
}