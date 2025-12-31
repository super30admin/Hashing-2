// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//We keep the runningSum for each element in the array
//we keep a map to put the count of sumArrays element when we traverse it
// if we find currentSum - k is any value existing map, that means we can have that count of subarrays whose sum is k
// else we put the currentSum,1 in map
class SubArrayEqualsK {
    public int subarraySum(int[] nums, int k) {
        //keep runningSum array
        for(int i = 1;i<nums.length;i++)
        {
            nums[i]=nums[i-1] + nums[i];
        }
        int counter= 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        //iterate over array
        for(int i = 0;i<nums.length;i++)
        {
            //if runninSum-k exists, that many subArray possible
            //increase counter
            //add the currentSum to map also
            if(map.containsKey(nums[i]-k))
            {
                counter += map.get(nums[i]-k);
                int sumCounter = map.getOrDefault(nums[i],0);
                map.put(nums[i],sumCounter+1);
            }
            //add the currentSum to map also
            else
            {
                int sumCounter = map.getOrDefault(nums[i],0);
                map.put(nums[i],sumCounter+1);
            }
        }
        return counter;
    }
}