//Time Complexity: O(n) | n is the size of the input array
//Space Complexity: O(n) | Size of Hashmap in worst case
//Program ran successfully
/*
    Algorithm: 1. All 0s are considered -1 and running sum is calculated
               2. At each iteration, check if the hashmap contains the running sum
               3. If yes, calcuate the length of the subarray by taking the difference of the current index and the first occurence of the running sum(value associated with the runnng sum in the hashmap)
               4. Check if the length of the subarray is greater than the previously computed subarray and replace max accordingly
               5. If map does not contain the running sum, then put in the map with it's index as it's value
               6. Return max
*/

class contiguousArray {
    public int findMaxLength(int[] nums) {
        //edge cases
        if(nums == null) return -1;
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int currSum = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            currSum = (nums[i] == 0) ? currSum-1 : currSum+1;
            if(map.containsKey(currSum)){
                max = Math.max(max, i - map.get(currSum));
            }else{
                map.put(currSum,i);
            }
        }
        return max;
    }
}
