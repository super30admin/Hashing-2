//Time Complexity : O(n)  
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
	int longestPalindrome(string s) {
		unordered_map<char, int> m;
		for(int i = 0; i < s.size(); i++){
			m[s[i]]++;
		}
		int res = 0;
		int flag = 0;     //flag is taken to keep a track of the odd 
		for(auto i : m){
			if(i.second % 2 == 0){
				res += i.second;  // taking even counts
			}
			else{
				res += i.second - 1;  // taking odd counts - 1
				flag = 1;
			}
		}
		if(flag == 1){  // At least one char shows odd times
			return 1 + res;
		}
		return res;
	}
};