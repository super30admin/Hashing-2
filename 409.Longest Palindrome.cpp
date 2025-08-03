class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set<char>s1;    //using set since it will not take duplicate
        int count =0;
        for(char c:s)
        {
            if(s1.count(c))    //if present increase the count to 2 and remove not insert to check for  future encounter 
            {
                count += 2;
                s1.erase(c);
            }
            else
             s1.insert(c);
        }
        if(s1.empty())  // check for adding middle term 
         return count;
        else
         return count+1; 
        
    }
};