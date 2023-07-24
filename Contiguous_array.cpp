class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
            map<int,int> m;
            m[0] = -1;
            int rsum = 0;
                int maxi = 0;
            for(int i=0 ;i<nums.size();i++){
                
                if(nums[i] == 1){
                        rsum = rsum+1;
                }
                else{
                    rsum = rsum-1;

                }

                if(m.find(i) == m.end()){
                    m[i] = rsum;
                }
                else{
                        int diff = i- m[rsum];
                        maxi = max(maxi,diff);
                }

            }


        return maxi;


        
            // vector<int> v;

            // if(m.find(0)!=m.end() && m.find(1)!=m.end()){
            //     for(auto i:m){
            //         v.push_back(i.second);
            //     }
            // }
            // else{
            //         return 0;
            // }

            // for(int i=0;i<v.size();i++){
            //     if(mini>v[i]){
            //         mini = v[i];
            //     }
            // }

            // return mini+mini;
           

    }
};