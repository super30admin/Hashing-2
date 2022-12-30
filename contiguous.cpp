class Solution{
public:
	int findMaxLength(vector<int> &nums){
		unordered_map<int,int> umap;
        int psum=0,res=0;
        umap[0]=-1;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==0){
                psum--;
            }
            else{
                psum++;
            }
            if(umap.find(psum)!=umap.end()){
                res = max(res,i-umap[psum]);
            }
            else{
                umap[psum]=i;
            }

        }
    return res;
	}
};
