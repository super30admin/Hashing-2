//TC : O(n)
// SC : O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {

        // // Hash Map + Prefix with Two loops
        // int[] prefixSum = new int[nums.length+1];

        // for(int i =0; i< nums.length; i++){
        // prefixSum[i+1] = prefixSum[i] + nums[i];
        // }
        // int count =0;
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i=0; i<prefixSum.length; i++) {
        // if(map.containsKey(prefixSum[i]-k)) { //0, 1, 0, 3
        // int key = prefixSum[i] -k;
        // count+= map.get(prefixSum[i]-k); // _, _, 1, 2
        // }
        // map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0)+1); // _ , _ , {...
        // 0:2}
        // }

        // return count;

        // Hash Map + Prefix with Single loop

        int[] prefixSum = new int[nums.length + 1];
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            if (map.containsKey(prefixSum[i + 1] - k)) {
                int key = prefixSum[i + 1] - k;
                count += map.get(prefixSum[i + 1] - k);
            }
            map.put(prefixSum[i + 1], map.getOrDefault(prefixSum[i + 1], 0) + 1);

        }
        return count;

    }
}