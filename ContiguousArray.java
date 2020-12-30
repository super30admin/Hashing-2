// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 */

class ContiguousArray{

    public int findMaxLength(int[] nums) {

        int max = 0,rSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for (int i = 0;i < nums.length; i++){
            rSum = nums[i] == 1 ? rSum + 1 : rSum - 1;
            if (map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            else{
                map.put(rSum,i);
            }
        }

        return max;
    }
}

/*
Leetcode Analysis:
Runtime: 19 ms, faster than 81.00% of Java online submissions for Contiguous Array.
Memory Usage: 48.6 MB, less than 76.86% of Java online submissions for Contiguous Array.
 */