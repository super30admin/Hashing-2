// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class ContiguousArray {
    //Idea is to use cummulative sum or running sum to calculate the equal number of 0's and 1's
    // Consider 0 as -1 and add to 1. If number of 0's and 1's are equal, sum will become zero.
    //If the cummulative sum till an element is already present in hashmap, it means the sub array is zero 

    //Time Complexity:O(n)
    //Space Complexity:O(n) 
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int max = 0;
        int rsum = 0;
        map.put(0,-1);

        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num == 0) rsum--;
            else rsum++;

            if(map.containsKey(rsum)){
                max = Math.max(max,i-map.get(rsum));
            } else{
                map.put(rsum,i);
            }
        }
        return max;
    }
}