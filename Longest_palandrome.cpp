// i created a set to track the chars of the string
// if I ancounter a char this is occuring second time then i remove it from the set and add 2 to answer count
// at the end if the set has elements then 1 is added to the answer
class Solution {
public:
    int longestPalindrome(string s) {
        int answer = 0;
        set<char> set;
        for(int i = 0; i < s.length();i++){
            if(set.find(s[i]) != set.end()){
                answer+=2;
                set.erase(s[i]);
            }
            else {
                set.insert(s[i]);
            }
        }
        if(!set.empty()){
            answer++;
        }

        return answer;
    }
};
