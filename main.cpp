#include <iostream>
#include <vector>
#include <map>

using namespace std;
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        map<int,int> m;
        int count = 0;
        int rsum = 0;
        m[0]=1;
        for(int i =0; i< nums.size();i++){
            rsum = rsum + nums[i];
            if(m.find(rsum - k) != m.end()) {
                count = count + m[rsum - k];
            }
            if(m.find(rsum) != m.end()){
                m[rsum]++;
            }else{
                m[rsum] = 1;
            }
        }
        return count;
    }
};



int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
