#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a HashSet to track characters that haven't formed a pair yet.
When we find a pair, we add 2 to the count and remove that char from the set.
If anything is left in the set, we can put one in the center — so we add 1 to the total.
*/
class Solution{
public:
    int longestPallindrome(string s){
        unordered_set<char> set;
        int count=0;

        for(char c : s){
            if(set.count(c)){
                count+=2;
                set.erase(c);
            }else set.insert(c);
        }

        if(!set.empty()) return count+1;
        return count;
    }
    
};
int main(){
    //example input
    string s = "aabbccdeeffghhijjjk";
    Solution obj;
    cout << obj.longestPallindrome(s) ;
    return 0;
}