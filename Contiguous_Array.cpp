// calculate the running sum, if 0 then do -1, if 1 then +1
// save the first encountered value of sum in map, as we need longest subarray
// then if I find any sum that has been previously added to the map then the array between them is balanced.
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        vector<int> sums;
        unordered_map<int, int> map;
        int result = 0;
        map.insert({0, -1});
        if(nums[0] == 1) sums.push_back(1);
        else sums.push_back(-1);
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] == 0){
                sums.push_back(sums[i-1]-1);
            }else{
                sums.push_back(sums[i-1]+1);
            }
        }
        for(int i = 0; i < nums.size(); i++){
            if(map.find(sums[i]) != map.end()){
                result = max(i-map[sums[i]], result);
            }else{
                map.insert({sums[i],i});
            }
        }
        return result;
    }
};
