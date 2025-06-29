//time complexity - O(n) where n is the no of element sin the array
//space complexity - O(n) at worst case where all elements is 1's or all are 0's 
//approach:
//maintain a variable maxlength and initialize to 0
//do contiguous sum as if you see 0 subtract 1 from sum and add 1 if you see '1'
//idea if the no of 1's and 0's are same then the sum will be equal from that index to that 
//so maxlength = max(maxlength, 1-index at which sum is equal)
// maintain a map of sum as key and value as the first index it is seen

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int,int> map_sum_index;
        int maxlength = 0;
        int sum = 0;
        //base case where sum =0, at index -1
        map_sum_index[0] = -1;
        for(int i=0; i<nums.size(); i++ ){
            if(nums[i] == 0){//subtract -1 if number is 0
                sum = sum -1;
            }
            if(nums[i] == 1){
                sum = sum + 1;
            }
           if(map_sum_index.find(sum) != map_sum_index.end()){ //if the sum is there then 
            maxlength = max(maxlength, i - map_sum_index[sum]);//if key is found donot change the value corresponding to that sum
           }
           else{ //if key(sum) is not found //only if key is not found 
            map_sum_index[sum] = i;
           }           
           
        }
        return maxlength;
    }
};
