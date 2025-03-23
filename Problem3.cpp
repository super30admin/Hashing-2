// Time Complexity : O(N) N is size of string
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to figure which size to consider for odd(frequency) elements.


// Your code here along with comments explaining your approach:
// 1. Create a map which tracks frequency of each char.
// 2. Add of even frequency chars in string with traversing map.
// 3. Add highest frequency of odd element.



class Solution {
public:
    int longestPalindrome(string s) {
        int n=s.size(),f=0,ans=0;
        map<char,int> m;
        for(int i=0;i<n;i++){
            m[s[i]]++;
            //cout<<s[i]<<' ';
        }
        cout<<'\n';
        for(auto i:m){          
            cout<<i.first<<' '<<i.second<<'\n'; 
            if( !((i.second)%2)){
                ans=ans+(i.second);
            }
            else{
                ans=ans+((i.second)-1);f=1;
            }
        }
        if(f==1){
            ans=ans+f;
        }
        return ans;
    }
};