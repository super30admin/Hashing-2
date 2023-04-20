// ## Problem2 (https://leetcode.com/problems/contiguous-array/)

// In this I am calculating cummulative sum by traversing the array but instead of 0 I am using -1,
// And I am storing the first occurence index of different sums,If I encounter the sum that is already 
// present in map that means I have a balanced array ,I will update my ans with the max length

class Solution {
public:
    int findMaxLength(vector<int>& nums) {

     
        unordered_map<int,int>K;
        int ans=0;
        int sum=0;
        K.insert(make_pair(0,-1));

     
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==0)
            sum=sum-1;
            else
            sum=sum+nums[i];

       
            if(K.find(sum)==K.end())
            {
                K.insert(make_pair(sum,i));
            }
            else
            {
                ans=max(ans,i-K[sum]);
           
            }
         
    }
    return ans;
    }
};