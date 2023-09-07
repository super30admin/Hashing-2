//Time complexity: O(n)
//Space complexity: O(n)

//Approach: In contiguous array idea here is to return a maximum length of subarray
//such that it contains equal numenr od 0s and 1s. so when we see 0 we subtract -1
//and when we see 1 we add 1 and calculate running sum. while calculating rsum at each
//index we will also store running sum as a key and its corresponsing index as a value
//in hashmap. if while doing rsum we see that rsum already exist - we never update it 
//rather we will compare it with maximum length so far with window size by (current index-
//value of rsum) and update the maximum value. if it does not exist we simply put in map


class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int,int> map;
        map[0]=-1; // sum 0 at index -1
        int rsum=0;
        int max_=0;
        for(int i=0;i<nums.size();i++)
        {
           if(nums[i]==0)
               rsum-=1;
            else
                rsum+=1;

            if(map.find(rsum)!=map.end())
            {
                max_=max(max_, i-map[rsum]);
            }
            else
            {
                map[rsum]=i;
            }
        }
        return max_;
    }
};