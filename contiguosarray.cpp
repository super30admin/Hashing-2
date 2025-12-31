class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int , int> map;
        map[0] = -1;//added in order to handle subarrays that start from index 0
        int rSum = 0;//aka prefix sum

        int max = 0;//stores the maximum length of a balanced subarray found so far

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (num == 0) rSum--;//-1 if 0
            else rSum++;//+1 if 1

            if (map.find(rSum) != map.end()){//search if rSum was seen in the hashmap
                max = std::max(max, i - map[rSum]);//computes the length of the max arraay length so far
            }
            else{
                map[rSum]= i;//rSum was not seen before

            }
        }
        return max;
    }

};