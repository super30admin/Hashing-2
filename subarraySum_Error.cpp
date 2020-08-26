// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : I tried to implement the method explained in class but it was giving me an eror
// all the elements of array are 0. I tried to fix that using one more extra condition but unable to figure 
// out the error. So used different approach. Please find that in another .cpp file

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        map<int, int> myhash;
        long sum = 0;
        int result = 0;
        bool val= true;
        myhash.insert({0,1});
        for ( int i = 0;i < nums.size(); i++){
           cout<< nums.size()<< endl;
            sum += nums[i];
            int comp = sum - k;
            if (myhash.count(comp)){
                result += myhash.at(comp);
            }
            if (!myhash.count(sum)){
                myhash.insert({sum,1});
            }
            else  myhash.insert({sum, myhash.at(sum)+1});
        }
          for (int i = 0; i < nums.size(); i++)
            {
            if(nums[i] != 0) {
                 val= false;
                }
            }
        if (val == true){
            return (nums.size()*(nums.size() + 1))/2;
        }
      
       return result; 
    }
};