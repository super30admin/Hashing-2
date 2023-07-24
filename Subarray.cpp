class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        
        map<int,int> m;

        m[0] = 1;

        int rsum = 0;
        int count = 0;

        for(int i=0;i<nums.size();i++){

            rsum = rsum + nums[i];

            int diff = rsum - k;

            if(m.find(diff) != m.end()){
                      count = count + m[diff];
              
            }
           
           m[rsum]++;
        }

            return count;

    }
};