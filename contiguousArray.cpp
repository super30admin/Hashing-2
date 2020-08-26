// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        map<int, int> myhash;
        int sum = 0;
        int result = 0;
        
        for ( int i =0; i  < nums.size() ; i++){
          
            if ( nums[i] == 0){
                sum +=1;
            }else{ sum -= 1;}
            
            if (sum == 0){
                result = i +1;
            }
            if ((myhash.find(nums[sum])== myhash.end()) || myhash.empty()){
                myhash.insert({sum,i});
            }else{
                cout<< sum << endl;
                
                result = max(result, (i - myhash.at(sum)));
            }
             
        }
        return result;
    }
};