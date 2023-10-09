package S30.exercises;

import java.util.HashMap;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

/*Approach
create hashmap to store count of running sum
store sum,count
add 0 in hm because initially sum is 0
loop -> 0 to n add current value of ith element from array to  the runningSum.  find runningSum  contains runningSum - targer
if exist count += count of prefixSum
add runningSum  in hm, if already exists then increment value(count) by 1
return count
*/
public class SubArraySumEqualsKey {

    public static int subarraySum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();  //runningSum as key and count
        map.put(0,1);
        int runningSum = 0;
        int count = 0;
        for(int i = 0; i<n; i++){
            runningSum = runningSum + nums[i];
            if(map.containsKey(runningSum-target)){
                count += map.get(runningSum-target);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
        }

        return count;
    }
    public static void main(String[] args){
        int[] a = {1,2,3,-3,1,1,1,4,2,-3};
        int[] b = {1,2,3,-3,1,1,1};
        System.out.println(subarraySum(a,6));
        //System.out.println(subarraySum(b, ))
    }
}
