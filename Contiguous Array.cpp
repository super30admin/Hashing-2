//525. Contiguous Array

/*
say: x = nums[0:5], y = nums[0:1] => z= nums[2:5] = x-y ===> use this idea
when encountered 0 decrement by 1; when encountered 1 increment by 1;
initialize 0 runningSum to -1 -> so that we can catch any subarrays such as [1,0] => return 1 even though balanced
We use hashmaps to store running sum, and the index at which running sum was calculated
when hashmap[running sum] is found, do max between the existing subarray and (currentindex - hashmap[running sum] )

Time complexity: O(N)
Space complexity: O(N)

*/

class Solution {
public:
    int findMaxLength(vector<int>& nums) {

        int runningSum = 0;
        unordered_map<int, int> hash;
        hash[0] = -1;
        int maxL = 0;
        for(int i=0; i<nums.size();i++){
            if(nums[i] == 0) runningSum--;
            if(nums[i] == 1) runningSum++;

            if(hash.find(runningSum) != hash.end()){
                maxL = max(maxL, i-hash[runningSum]);
            }else{
                hash[runningSum] = i;
            }
           
        }


        return maxL;
        
    }
};