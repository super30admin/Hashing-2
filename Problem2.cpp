// Time Complexity : O(N) N is size of array
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to get answer if sub-array found at i=0


// Your code here along with comments explaining your approach:
// 1. Create a running sum array which has sum of ending index i.
// 2. Create mapm which stores map with key as sum and value as index.
// 3. If map exist take the starting index - current index(smallest length of sub array).


class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n=nums.size();
        int arr[n+1];arr[0]=0;
        for(int i=1;i<=n;i++){
            if(nums[i-1]==0){
                arr[i]=arr[i-1]-1;
            }else{
                arr[i]=arr[i-1]+1;
            }
        }
        map<int,int> m;
        int ans=0;
        for(int i=0;i<=n;i++){
            if(!m[arr[i]]){
                m[arr[i]]=i;
                if(i==0){
                    m[arr[i]]=-1;
                }
            }else{
                if(m[arr[i]]==-1){
                    if(ans<(i)){
                        ans=(i);continue;
                    }
                }
                if(ans<(i-m[arr[i]])){
                    ans=(i-m[arr[i]]);
                }
            }
        }
        return ans;
    }
};