
/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity : O(N)
Space complexity -O(N)
Approach:
e.g - [1 2 3] k =3
preximSum = 1 is this present in the map, yes? get the count of it and increment by one,
            if this prefixSum is not present in the map put it in map with initially count
            value as 1, return count at the end of iteration

to cover edge case where the prefixSum == target then we will have to consider it once,
(e,g 7-7 sum will be 0 and the count should be 1) hence we add this  countMap.put(0,1)
*/
import java.util.HashMap;
import java.util.Map;
public class SubArraySumEqualsK_LC560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        //{key value}
        //{Sum , count}
        /***
         * //when prefixSum == target then we will have to consider it once,
         * below line helps with this  like  prefixSum-k == 0 for this scenario we consider count = 1
         */
        countMap.put(0,1);
        int prefixSum = 0;
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            //Check the complement in Map, if found get the value against it and add it to count
            if(countMap.containsKey(prefixSum-k)) {
                count += countMap.get(prefixSum-k);
            }
            // keep adding prefixSum to the map, so next time we can check complement and its value
            countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1);

            /*  instead of this loop just covered the code with getOrDefault
            if(!countMap.containsKey(prefixSum)){
                 countMap.put(prefixSum, 0); //clarify this
             }
             countMap.put(prefixSum, countMap.get(prefixSum)+1); */
        }
        return count;
    }
}