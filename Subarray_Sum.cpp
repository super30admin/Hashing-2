// first calculatd the running sum from left
// then created a map to check if sum[i] - k(target) exists in the map
// if it exists, then add the frequency of the searched num to the answer

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        vector<int> sums;
        unordered_map<int, int> map;
        int count = 0;
        map.insert({0,1});
        sums.push_back(nums[0]);
        for(int i = 1; i < nums.size();i++){
            sums.push_back(sums[i-1]+nums[i]);
        }
        for(auto& n : sums){
            if(map.find(n-k) != map.end()){
                count = count + map[n-k];
            }
            if(map.find(n) != map.end()){
                map.at(n) = map.at(n) + 1;
            }else{
                map.insert({n,1});
            }
        }

        return count;
    }
};
