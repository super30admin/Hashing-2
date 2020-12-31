// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
The thought is to implement equation: x - y = z
where x is sum of the value already present in hashmap
y is sum of the total value till i pointer
z is K mentioned in problem.

the only edge case to think about is when we have 0 as the sum, thats why we preemptively put 1 count to 0
 */

class SubArraySum{

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum = 0;
        int count = 0;

        for (int i = 0; i< nums.length; i++){
            rSum += nums[i];
            int complement = rSum - k;

            if (map.containsKey(complement)){
                count += map.get(complement);
            }
            if (map.contains(rSum)){
                map.put(rSum,map.get(rSum) + 1);
            }
            else{
                map.put(rSum,1);
            }
        }

        return count;
    }
}