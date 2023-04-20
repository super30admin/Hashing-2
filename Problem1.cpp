// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

// I will calculate the running sum by traversing array, at each element I will store the sum in map with sum as key.
// And I will check at each elemnent in the map if there exists (sum-target); if exists I will increment the ans(It means that there 
// exists a subarray  of target sum)
// While checking for (sum-target ) if it equals to zero we will miss this subarrays so inorder to include this I will add (0,1) in the map

// TC:O(N), SC: O(N)

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int count=0;
        unordered_map<int,int>r_sum_counter;
        int sum=0;
        r_sum_counter.insert(make_pair(0,1));

        for(int i=0;i<nums.size();i++)
        {
           sum=sum+nums[i];
        //    if(sum==k) count++;
           if(r_sum_counter.find(sum-k)!=r_sum_counter.end())
           {
               count=count + r_sum_counter[sum-k];
           }
           r_sum_counter[sum]++;
        } 
        
        return count;
}};