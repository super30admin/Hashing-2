class Solution {
   // TC - O(n)
   // SC -O(n) 
public:
    int findMaxLength(vector<int>& nums) {
    unordered_map<int,int> umap;
    umap[0] = -1;
    int maxLength =0;

    for(int i =0; i<nums.size();i++){
         if(i>0){
             nums[i] = nums[i]==0?nums[i-1]-1:nums[i-1]+1 ;
         }
         else nums[i] = nums[i]==0?-1:1; 
        if(umap.find(nums[i]) != umap.end()){
            int length = i - umap[nums[i]];
            if(length> maxLength) maxLength = length;
        }
        else{
            umap[nums[i]] = i;
        }       
    }
    return maxLength;
    }
};