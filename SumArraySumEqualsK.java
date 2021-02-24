class Solution {
     public int subarraySum(int[] nums, int k) {
         // Initializing variables ct and curSum to 0
         int ct = 0;
         int curSum = 0;
         // Initializing hashmap, we store the cumulative sum and number of occurences of the sum
         Map<Integer, Integer> map = new HashMap<>();
         // Initially as an empty subarray is 1, we store (0, 1) in map
         map.put(0, 1);
         // Iterate ove nums array
         for(int i=0; i<nums.length; i++){
             // We add nums value at ith index to curSum which is cumulative sum
             curSum += nums[i];
             // calculate the difference between curSum and k
             int diff = curSum - k;
             // If map contains key of diff, increment the key by the value of diff from map and add value by 1 to curSum,                // else we add new entry of (curSum, 1) into the map.
             if(map.containsKey(diff)){
                 ct += map.get(diff);
             }
             map.put(curSum, map.getOrDefault(curSum, 0) + 1);
         }
         return ct;
     }
}

//---------------------------------------------------------------------------------

// BruteForce

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int ct = 0;
//         for(int i=0; i<nums.length; i++){
//             int sum = 0;
//             for(int j=i; j<nums.length; j++){
//                 sum += nums[j];
//                 if(sum == k){
//                     ct++;
//                 }
//             }
//         }
//         return ct;
//     }
// }