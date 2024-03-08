// Time Complexity : O(numsLength)
// Space Complexity : O(numsLength)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // complement, count
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        int count = 0;
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            int complement = runningSum - k;
            // if complement exist in the map then get it and update its value in count variable
            if(map.containsKey(complement)){
                count += map.get(complement);
            }
            // if runningSum doesnt exist in map, then add it with count 1
            if(!map.containsKey(runningSum)) {
                map.put(runningSum, 1);
            } else {
                // else get count of runningSum from map and increment it by and update map
                int incrementedCount = map.get(runningSum) + 1;
                map.put(runningSum, incrementedCount);
            }
        }
        // now simply return the count
        return count;
    }

}
