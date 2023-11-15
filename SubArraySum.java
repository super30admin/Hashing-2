//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int runSum = 0,freq = 0;

    HashMap<Integer,Integer> rsumMap = new HashMap<>();
    rsumMap.put(0,1); //Marker to consider for first subarray

    for(int i=0;i<nums.length;i++){
        runSum += nums[i];
        if(rsumMap.containsKey(runSum - k)){
            freq+=rsumMap.get(runSum - k);
        }
            rsumMap.put(runSum,rsumMap.getOrDefault(runSum,0)+1);
    }
    return freq;
    }
}