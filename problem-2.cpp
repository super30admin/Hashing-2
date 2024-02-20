// 525. Contiguous Array
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
utilizes a hashmap to store the cumulative sum of 1s and 0s encountered so far
as keys and their corresponding indices as values. Initially, a sum of 0 is
mapped to index -1 to handle the case when the balanced subarray starts from
the beginning. Then, it iterates through the array, updating the cumulative
sum, and checks if the current cumulative sum exists in the hashmap. If it
does, it updates the maximum length found so far by calculating the difference
between the current index and the index stored in the hashmap. Finally, it returns the maximum length found.

*/
int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> umap;
        vector<int> suff;
        int sum = 0, maxnum = 0;
        umap[0] = -1; 
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] == 0)
                sum -= 1;
            else
                sum += 1;
            suff.push_back(sum);
        }
        for(int i = 0; i < nums.size(); i++)
        {
            if(umap.find(suff[i]) != umap.end())
                maxnum = max(maxnum, i - umap[suff[i]] );
            else
                umap[suff[i]] = i;   
        }
        return maxnum;

}