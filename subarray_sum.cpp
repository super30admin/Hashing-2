class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
       unordered_map<int,int>umap;
       int count=0;
       int psum=0;
       for(int i=0;i<nums.size();i++){
           psum+=nums[i];
           if(psum==k){
               count++;
           }
           if(umap.find(psum-k)!=umap.end()){
                count++;
           }else{
               umap[psum]=1;
           }
       }
    return count;
    }
};
