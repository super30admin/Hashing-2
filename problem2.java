// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// in the loop , we calculate the rsum by increasing 1 if we get 1 and decresing 1 if we get 0.
// so, our intention is to check equal number of 0's and 1's. we maintain a map to store the index of first occurence of the rsum.
// so that whenever we encounter an rsum , we update the maxLength.
// Here we get a problem considering the initial subarray, to overcome that we fill the map with (0,-1) so that when taking the difference,
// the initial subarray is also taken into account.

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return 0;
        }
        int rsum = 0;
        int maxLength = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==0) rsum-=1;
            else rsum+=1;
            if(map.containsKey(rsum))
            {
                maxLength = Math.max(maxLength, i - map.get(rsum));
            }
            else
            {
                map.put(rsum,i);
            }
        }
        return maxLength;
        
    }
}