// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//Keep the runningSum of array elements, where 0 decreases sum by 1, and 1 increases by 1
//this way if two same runninSum, happens that translate to having equal number of addition ,and subtraction
//which in turn means equal number of 0s and 1s
//keep the first sum in a map to look later if that sum appears again later, and keep track of maxLen
//put 0,-1 in map to counter where when we see 0 sum in beginning
class ContigiousArray {
    public int findMaxLength(int[] nums) {
        int runningSum=0;
        //update runningSum to each element in array
        //+1 for 1 and -1 for 0
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                runningSum = runningSum-1;
                nums[i] = runningSum;
            }
            else
            {
                runningSum = runningSum +1;
                nums[i] = runningSum;
            }
        }
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        //Iterate over array, and see if the sum appeared before
        //if so, calculate maxLen
        //else put sum, and index
        for(int i = 0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int currLen = i - map.get(nums[i]);
                maxLen = Math.max(currLen,maxLen);
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        return maxLen;
    }
}