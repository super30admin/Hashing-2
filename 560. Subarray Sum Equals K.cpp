class Solution {
public:
    // Time Complexity : O(n)
    // Space Complexity :  O(n)
    
    /* 
    Approach:
    
    Maintain prefix sum.. For a particular index, let say the running sum is s. Then, the number of prefix sums with value = (s - k) should be the number of subarrays with sum = k
    */
    int subarraySum(vector<int>& a, int k) {
        unordered_map<int,int> m;
        m[0] = 1;
        
        int pref = 0;
        int ans = 0;
        for(auto& num: a){
          pref += num;
          int need = pref-k;

          if(m.count(need)!=0)  ans += m[need];
          
          if(m.count(pref)==0)  m[pref] = 0;
          m[pref]++;
        }

        return ans;
    }
};
