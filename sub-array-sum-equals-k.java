class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //dummy element;
        int count = 0;
        int rSum = 0;
        //calculate the running sum
        for (int i = 0; i < nums.length; i++) {
            rSum = rSum + nums[i];
            if (map.containsKey(rSum - k)) { // looking for compliment
                count += map.get(rSum - k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1); // check if the rSum is there if not, add it, if there increases the count by 1
        }
        return count;
    }
}

//TC: O(n)
//SC: O(n)