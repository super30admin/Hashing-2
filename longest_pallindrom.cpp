class Solution {
public:
    int longestPalindrome(string s) {
        
            int sum = 0;



        map<char,int>m; 

        int j = 0;
        for(int i=0;i<s.length();i++){
                m[s[i]]++;
        }

        for(auto i:m){
            if((i.second)%2==0){
                sum = sum + i.second;
            }
            else{
                sum = sum + ((i.second) - 1);
                j++;
            }
        }
        if(j>0){
            sum  = sum+1;
        }
        return sum;
    }
};