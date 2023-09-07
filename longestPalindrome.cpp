//TIme complexity: O(n)
//space complexity: O(n)

//Approach: we know that character that occurs for even number of times
//can be said to add towards the length so we add the frequency directly
//otherwise if it is odd length simply increment counter in the send

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> counts;
        int res=0;
        int idOdd=false;
        for(auto c: s)counts[c]++;

        for(auto c: counts)
        {
            if(c.second%2==0)
                res+=c.second;
            else
            {
                   res+=c.second-1;
                   idOdd=true;
            }
             
            
        }
        if(idOdd)
            res++;
        return res;
    }
};