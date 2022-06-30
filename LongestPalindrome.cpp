HashMap:
O(N) time, O(52) space ~ O(1) (lower + upper chars)
class Solution {
public:
    int longestPalindrome(string s) {
        int result = 0;
        int maxOdd = 0;
        unordered_map<char,int> m;
        for(auto c:s)
            m[c]++;
        for(auto itr:m){
            if(itr.second%2==0) //if even take all chars
                result+=itr.second;
            else{ //if odd, I can take odd - 1
                result+=(itr.second-1);
                maxOdd++;
            }
        }
        if(maxOdd>0) result++; //keep the extra odd in center
        return result;
    }
};
