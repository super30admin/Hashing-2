class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int,int>h; // to store rsum and index
        h[0] =-1;
        int rsum =0;
        int lenmax =0; // to calculate max length
        for(int i =0;i<nums.size();i++)
        {
           if(nums[i]==0)   // add +1 for 1 and -1 for 0
            rsum--;
           else
            rsum++;

           if(h.find(rsum)!=h.end()) //if there is similar rsum calculate the maxlength my sub the earlier index with current one 
            {
                lenmax = max(lenmax,i-h[rsum]);
            } 
            else
            {
                h[rsum]=i;  // if not add the rsum and corresponding index
            } 
        }
        return lenmax;
    }
};