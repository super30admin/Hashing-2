class Solution {
    // Time Complecity :O(n)
    // Space Complexity : O(n)
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> umap;

        
        umap[0] =1;
        int noOfSubArrays = 0;

        for(int i = 0; i< nums.size(); i++){
            if(i>0){
              nums[i] = nums[i-1]+nums[i];    // running sum 
            }
            if(umap.find(nums[i]-k) != umap.end() ){
                noOfSubArrays = noOfSubArrays+umap[nums[i]-k];
            }
            if(umap.find(nums[i]) == umap.end()){
                umap[nums[i]] = 1;
            }
            else umap[nums[i]] = umap[nums[i]]+1;


        }
        return noOfSubArrays;
        
    }
};