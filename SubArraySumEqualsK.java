// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Initialize a HashMap to store the cumulative sums and their frequencies.
// 2. Add an initial entry to the HashMap with key=0 and value=1 (to handle the case where the sum of elements from index 0 to i equals k).
// 3. Initialize variables count (to count subarrays with sum k) and rSum (to store the running sum).
// 4. Iterate through the array, updating the running sum (rSum) by adding the current element.
// 5. Check if (rSum - k) exists in the HashMap. If it does, increment count by the frequency of (rSum - k).
// 6. Update the HashMap with the current running sum. If it already exists, increment its frequency; otherwise, add a new entry with frequency 1.
// 7. Repeat steps 4-6 for all elements in the array.
// 8. Return the final count, which represents the number of subarrays with sum equal to k.



import java.util.HashMap;

class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int count=0;
        int rSum=0;

        for(int i=0; i<nums.length; i++)
        {
            rSum += nums[i];
            int y = rSum-k;
            if(map.containsKey(y))
            {
                count+=map.get(y);
            }
            if(!map.containsKey(rSum))
            {
                map.put(rSum,1);
            }
            else
            {
                map.put(rSum, map.get(rSum) +1);
            }
        }
        return count;
    }
}