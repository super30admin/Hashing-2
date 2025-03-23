// Time Complexity : O(N) N is size of array
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to get answer if k=0 and sub-array found at i=0


// Your code here along with comments explaining your approach:
// 1. Create a running sum array which has sum of ending index i.
// 2. arr[0]=0 as this array will add element and it's previous sum.
// 3. Map values and simulteneously check if arr[i]-k exist in map.


class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int n=nums.size();
        int arr[n+1];arr[0]=0;
        if( n==1){
            if(k==nums[0]){return 1;}
            else{return 0;}
        }
        for(int i=1;i<=n;i++){
            arr[i]=arr[i-1]+nums[i-1];
            cout<<arr[i]<<' ';
        }
        map<int,int> m;
        int ans=0,f=0;
        cout<<'\n';
        m[0]=1;
        for(int i=1;i<=n;i++){
                if( (m[(arr[i]-k)] > 0) ){
                    ans=ans+m[arr[i]-k];
                }
                m[arr[i]]++;
            cout<<ans<<' ';
        }
        return ans;
    }
};