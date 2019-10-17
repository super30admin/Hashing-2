
// this is subarray sum equals problem solved in c++

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int count=0;
        int runningsum=0;

        unordered_map<int,int> m;
        m[0]=1;
        for(int i=0;i<nums.size();i++)
        {
            runningsum+=nums[i];
            int compliment=runningsum-k;
            if(m.count(compliment)>0)
            {
                count+=m[compliment];
            }

           if(m.count(runningsum)>0)
           {
               m[runningsum]+=1;
           }
            else
            {
                pair<int,int> newpair (runningsum,1);
                m.insert(newpair);
            }

        }

        return count;
        }


};
