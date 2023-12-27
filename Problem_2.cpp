/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
    I calculate the prefix sum of the array, but with a twist:
    I increment the sum by 1 for each 1 encountered and decrement
    it by 1 for each 0. This approach effectively converts the
    problem into finding two positions in the array where the
    prefix sum is the same, indicating an equal number of 0s
    and 1s between these positions.

    I initialize a vector prefixSum to store these modified
    prefix sums. The prefix sum at the first position is just
    the value of the first element (incremented or decremented
    as described). Then, I iterate through the array, updating
    the prefix sum at each position based on whether the current
    element is a 1 or a 0.

    Next, I use an unordered map (map) to store the first occurrence
    of each unique prefix sum along with its index. Additionally, I
    add an entry for a sum of 0 at index -1 to handle edge cases
    where a valid subarray starts from the beginning of the array.

    As I iterate through the prefixSum vector, I check if the current
    prefix sum already exists in the map. If it does, it means I've
    found a subarray (from the index stored in the map to the current
    index) where the number of 0s and 1s are equal. I update the count
    with the length of this subarray if it's larger than the current
    count. If the current prefix sum is not in the map, I add it with
    its corresponding index.

    Finally, count holds the maximum length of the required sub
*/

#include <vector>
#include <unordered_map>

class Solution {
public:
    int findMaxLength(std::vector<int>& nums) {
        int n = nums.size();
        std::vector<int> prefixSum(n);

        // Initialize the prefix sum with -1 if num[0] == 0 or 1 if num[0] == 1
        prefixSum[0] = (nums[0]) ? 1 : -1;
        for (int i = 1; i < n; i++) {
            if (nums[i])
                prefixSum[i] = prefixSum[i - 1] + 1;
            else
                prefixSum[i] = prefixSum[i - 1] - 1;
        }

        std::unordered_map<int, int> map; // { sum : index }

        // add 0 sum with index -1 for the subarray starting from 0 -> edge case
        map[0] = -1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.contains(prefixSum[i])) {
                count = std::max(count, i - map[prefixSum[i]]);
            } else {
                map[prefixSum[i]] = i;
            }
        }

        return count;
    }
};