class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int>h; // rsum :count
        h[0] =1; 
        int result =0;
        int rsum =0;
       
        for(int i =0;i<nums.size();i++)
        {
            rsum += nums[i]; // cumulative sum till nums[i]
            int comp = rsum-k; //to find subarray lenght between i to j => rsumj-rsumi = k
            if(h.find(comp)!=h.end()) // once you find the comp that is the end of subarray equals to target (k)
             result += h[comp] ;
            h[rsum]++;   
        }
        return result;
    }
};