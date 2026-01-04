//TC: O(n)
//SC: O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        // HashMap Solution with prefix sum

        // int[] prefixSum = new int[nums.length+1];
        // for(int i=0; i< nums.length; i++) {
        // if(nums[i]==0) {
        // prefixSum[i+1] = prefixSum[i]-1;
        // } else {
        // prefixSum[i+1] = prefixSum[i]+1;
        // }
        // }

        // HashMap<Integer, Integer> count = new HashMap<>();
        // int max =0;

        // for (int i =0; i<prefixSum.length;i++) {
        // if(!count.containsKey(prefixSum[i])) {
        // count.put(prefixSum[i], i);
        // } else {
        // max= Math.max(max, i-count.get(prefixSum[i]));
        // }
        // }
        // return max;

        // Solution 2: Single For Loop with Prefix array

        // int[] prefixSum = new int[nums.length+1];
        // HashMap<Integer, Integer> count = new HashMap<>();
        // int max =0;
        // count.put(0,0);
        // for(int i=0; i< nums.length; i++) {
        // if(nums[i]==0) {
        // prefixSum[i+1] = prefixSum[i]-1;
        // } else {
        // prefixSum[i+1] = prefixSum[i]+1;
        // }

        // if(!count.containsKey(prefixSum[i+1])) {
        // count.put(prefixSum[i+1], i+1);
        // } else {
        // max= Math.max(max, i+1-count.get(prefixSum[i+1]));
        // }
        // }
        // return max;

        // Solution 3 : without prefix Sum array
        // Runtime seems to be faster than the earlier two due to not creating an array
        // and accessing it.
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int prefixSum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                prefixSum -= 1; // Keeps track of prefix sum at index i of nums array.
            } else {
                prefixSum += 1;
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            } else {
                max = Math.max(max, i - map.get(prefixSum));
            }
        }
        return max;

    }
}