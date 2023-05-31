/*

// Time Complexity : O(N) going through array
// Space Complexity : O(N) - storing all the possible unique rolling sums
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
having knowledge of rolling sum to find the subarray and values corresponding to it.


// Your code here along with comments explaining your approach
You find the rolling sum. Store the unique occurence of index of each rolling sum. 
if that rolling sum occurs again, then the sub array assoicated can be find by finding the 
difference between the initial index of the first occurence of the rolling sum and present occurence of the rolling sum
this will imply that equal elements have occured as 0 weighs -1 and 1 weighs 1.

*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        if(nums.size() == 1){
            return 0;
        }
        int max{},sum{};
        unordered_map<int,int> storage{{0,-1}};
        for(int i{};i<nums.size();++i){
            sum+= (nums.at(i)==1?1:-1);
            // storing new rolling sum
            if(storage.find(sum)==storage.end()){
                storage[sum] = i;
            }
            // if found finding the length by diffrence between indices which lead to their occurence.
            else{
                int temp{i-(storage.at(sum))};
                max = (temp>max?temp:max);
            }
        }
        return max;
    }
};