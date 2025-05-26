// Time complexity O(n)
// Space complexity O(n)
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int max_length = 0;

        unordered_map<int, int> prefix_sums_map;
        prefix_sums_map.insert({0, -1});

        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {          
            sum += (nums[i] == 1 ? 1 : -1);

            if (prefix_sums_map.find(sum) != prefix_sums_map.end()) {
                max_length = max(max_length, i - prefix_sums_map[sum]);
            } else {
                prefix_sums_map[sum] = i;
            }
        }

        return max_length;
    }
};