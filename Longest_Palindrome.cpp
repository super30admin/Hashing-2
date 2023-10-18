class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> myMap;
       
        int result =0;
        for(int i=0;i<s.length();i++){
            myMap[s[i]]++;
            if(myMap[s[i]]%2==0){
                result+= myMap[s[i]];
                myMap[s[i]]=0;
            }
            
        }
    for(auto x:myMap){
        if(x.second == 1){
            result +=1;
            break;
        }
    }
     return result;   
    }
};
