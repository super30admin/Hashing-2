//Time complexity: O(n) iterating over array to fins #of subarrays
//Space complexity: O(n) hashmap to store running sum

//Approach: use a sliding window approach specifically running sum
//here store frequency map of running sum and its count
// at every given index check if (current sum-k) exist in the map
//if it does then see the counter and add it to our final answer
//every time you see the key in map existing simply increment its counter
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        int curr=0, ans=0;
        mp[0]=1;
        for(auto x:nums)
        {
            curr+=x;
            ans+=mp[curr-k];
            mp[curr]++;
        }
        return ans;
    }
};