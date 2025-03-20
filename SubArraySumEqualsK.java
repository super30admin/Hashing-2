// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); //rSum: count
        int rSum=0;
        int result = 0;
        map.put(0,1);

        for(int num: nums) {
            rSum +=num;
            int cmp = rSum - k;
            if(map.containsKey(cmp)) {
                result += map.get(cmp);
            }

            map.put(rSum, map.getOrDefault(rSum, 0)+1);
        }
        return result;
    }
}