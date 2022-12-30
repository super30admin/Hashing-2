class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set<char>umap;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(umap.find(s[i])!=umap.end()){
                count=count+2;
                umap.erase(s[i]);
            }
            else{
                umap.insert(s[i]);
            }
        }
        if(umap.empty()){return count;}
        else{
            return count+1;
        }
    }
};
