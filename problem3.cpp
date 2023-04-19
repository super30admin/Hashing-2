// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// We use a set to count even count elements. so first we insert into set and when it occurs second time , we increment count+=2 and remove from set.
// at last , if the set is not empty, that means there is atleast one odd count character, so we add one to count.

class Solution {
public:
    int longestPalindrome(string s) {
        if(s.size()==0) return 0;
        unordered_set<char>set;
        int count=0;
        for(char ele: s)
        {
            if(set.find(ele)!=set.end())
            {
                count+=2;
                set.erase(ele);
            }
            else{
                set.insert(ele);
            }
        }
        if(!set.empty())
        {
            count+=1;
        }
        return count;
        
    }
};