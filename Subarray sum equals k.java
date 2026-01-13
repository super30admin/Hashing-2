// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Did this code successfully run on Leetcode : yes
// Three sentences abou the solution: We count the number of subarrays whose sum equals k using a prefix-sum approach.It keeps a running sum and uses a HashMap to store how many times each prefix sum has occurred.
// If (currentSum − k) exists in the map, it means a subarray ending at the current index sums to k.
// The map is updated at each step with the current prefix sum count. Finally, we return the total number of such subarrays found.

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum = sum +nums[i];
            if(map.containsKey(sum-k)) {
                int val = map.get(sum-k);
                count = count +val;
            }
            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) +1);
            } else {
                map.put(sum,1);
            }
        }
        return count;
    }
}