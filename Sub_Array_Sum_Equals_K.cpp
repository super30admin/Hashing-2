class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {

        unordered_map<int,int> myMap;
        myMap[0]=1;
        int count=0,running_sum=0;
        for(int i =0;i<nums.size();i++){
            running_sum +=nums[i];
            if(myMap[running_sum-k]){
                count += myMap[(running_sum-k)];
            }
            myMap[running_sum]++;
        }

      return count;  
    }
};
