// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach : Used runningsum technique, then we know y = x-z, and we already have x (rSum) and z(k).
//find possible rSum which can lead to k


class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // dummy value to catch k from 0th index
        int rSum = 0;

        for(int n : nums){
            rSum += n;
            int y = rSum - k; // complement of rSum to create k = y

            // add the number of times we can find y
            if(map.containsKey(y)){
                count += map.get(y);
            }
            //add the rSum and it's occurence
            map.put(rSum,map.getOrDefault(rSum,0)+1);

        }

        return count;

    }
}