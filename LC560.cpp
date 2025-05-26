// Time complexity O(n)
// Space complexity O(n)
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> prefix_sum_map;
        prefix_sum_map.insert({0, 1});

        int count = 0;
        int curr = 0;
        for (int i = 0; i < nums.size(); i++) {

            curr += nums[i];

            if (prefix_sum_map.find(curr - k) != prefix_sum_map.end()) {
                count += prefix_sum_map[curr - k];
            }

            prefix_sum_map[curr]++;
        }

        return count;
    }
};