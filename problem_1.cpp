/*

// Time Complexity : O(N) length of the array
// Space Complexity : O(N) number of rolling sums
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
knowledge of rollling sum for finding the sum of the intermediate sub arrays without iterating through the elements.

// Your code here along with comments explaining your approach
Calculate the rolling sums and store their frequency. Find the difference between the current rolling sum and target
and if that exist what is the frequency of that paticular rolling sums. this can tell that there are atleast two indexes 
where we go back we will find the same sum across the whole subarray.

*/

#include<vector>
#include<unordered_map>

using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> hash_map{{0,1}};
        int rsum{},count{};
        for(int i{};i<nums.size();++i){
            rsum+=nums.at(i);
            if(hash_map.find(rsum - k) != hash_map.end()){
                count+=hash_map[rsum-k];
            }
            if(hash_map.find(rsum)==hash_map.end()){
                hash_map[rsum] = 0;
            }
            ++hash_map[rsum];
        }
        return count;
    }
};