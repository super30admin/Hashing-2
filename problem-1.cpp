// 560. Subarray Sum Equals K
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
used a hashmap to store the sums of subarrays as keys and
their corresponding frequencies as values. iterates through the array
from right to left, updating the sum at each position. For 
each position, calculated the target value required to achieve the 
sum k by subtracting k from the current cumulative sum. checks if 
the target value exists in the hashmap, incrementing the count by the 
frequency of that target if found. Finally, updates the hashmap with
the current cumulative sum and its frequency before moving to the next
position.

*/


int subarraySum(vector<int>& nums, int k) {
    int n = nums.size(), target;
    unordered_map<int, int> umap;;
    int count = 0;
    umap[0] = 1;
    for(int i = n-1; i >= 0; i--)
    {
        if(i != n-1)
            nums[i] += nums[i+1];
        target = nums[i] - k;
            if(umap.find(target) != umap.end())
            {
                count+=umap[target];
            }
        if(umap.find(nums[i]) != umap.end())
            {
            umap[nums[i]]++;
            }
            else
            umap[nums[i]] = 1;
        
    }
        return count;
}

