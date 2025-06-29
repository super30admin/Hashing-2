//time complexity  = O(n);;
//space complexity  = O(n);
//approach: maintain contiguous sum and a hash map with key as sum and value as its frequency 
//maintain a variable count
// check while inserting a key in map if sum - k is there in the map or not
//if its present then count = count + frequency of the key (sum-k)
//and add +1 to the value of the key as the frequency of that key has increased

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> map_sum_frequency;
        //base case;
        map_sum_frequency[0] = 1; //0-sum and 1-frequency

        int count  = 0;
        int sum = 0;
        for(int i=0; i < nums.size(); i++){
            sum = sum + nums[i];
            if(map_sum_frequency.find(sum - k) !=  map_sum_frequency.end()){ //checking if the sum-k key is present or not 
            //.find() returns .end() if key is not present
                count = count + map_sum_frequency[sum-k];
            }
            map_sum_frequency[sum] = map_sum_frequency[sum] + 1;
        }
        return count;

    }
};
