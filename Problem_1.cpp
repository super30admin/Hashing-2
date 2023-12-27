/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
    I start by initializing an unordered map sum_map, which will
    map the cumulative sum of elements in the array to the frequency
    of that sum. The key is the cumulative sum, and the value is the
    count of how many times that sum has been encountered. I also
    initialize count to keep track of the number of subarrays that
    sum up to k, and a variable sum to store the cumulative sum as
    I iterate through the array.

    I insert an entry in the map for the sum of 0 with a frequency of 1.
    This is an important step, as it handles cases where a subarray that
    forms the sum k starts from the beginning of the array.

    As I iterate over the array, I continually add the current element
    (num) to sum, which represents the cumulative sum up to the current
    element. The key operation here is checking for sum - k in sum_map.
    If sum - k is found in the map, it means there are one or more subarrays
    ending at the current index which sum up to k. I add the frequency of
    sum - k in the map to count, as this frequency represents the number
    of such subarrays.

    After checking for sum - k, I update the frequency of sum in sum_map
    by incrementing it. This update is crucial as it accounts for the
    current cumulative sum being encountered in future iterations.

    Finally, I return count, which represents the total number of continuous
    subarrays that add up to k in the input array nums.
*/

#include <vector>
#include <unordered_map>

class Solution {
public:
    int subarraySum(std::vector<int>& nums, int k) {
        int n = nums.size();

        std::unordered_map<int, int> sum_map; // { sum : count }
        int count = 0, sum = 0;

        // Adding sum 0 with count 1 include the first element sum subarray
        sum_map[0] = 1;

        for (int num : nums) {
            sum += num;
            count += sum_map[sum - k];
            sum_map[sum]++;
        }

        return count;
    }
};