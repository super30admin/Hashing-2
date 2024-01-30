class Solution {
public:
    /*
    Time Complexity : O(n)
    Space Complexity :  O(n) 

    Approach:

    Maintain prefix sum (add -1 for 0, 1 for 1). For a particular index i, let say the running sum is s. Then, the left most index of prefix sums with value = s should be the left boundary of the largest sub-array that ends at i and has equal 0s/1s
    */

    int findMaxLength(vector<int>& nums) {
      unordered_map<int,int> m;
      int ans = 0, balance = 0;

      m[0] = -1;
      for(int i=0;i<nums.size();i++){
        nums[i] == 0 ? balance-- : balance++;

        //what count we need to make the balance zero? balance itself! balance-balace!
        if(m.count(balance)!=0) {
          ans = max(ans, i-m[balance]);
        }

        if(m.count(balance)==0)  m[balance] = i; //only store the first (leftmost) occurance to maximize the subarrays
      }

      return ans;
        
    }
};
