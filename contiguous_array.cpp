// Time complexity O(n)
// Space complexity O(1)

#include <unordered_map>
#include <algorithm>
class Solution
{
public:
    int findMaxLength(vector<int> &nums)
    {

        // max variable to keep track of current max difference
        int maximum = 0;
        int count = 0;
        // declare a hash map

        unordered_map<int, int> h_map;
        h_map.insert({0, -1});
        // test case [0,1,0]  to keep in mind

        // traverse through the array and -1 for every 0 and +1 for every 1:

        for (int i = 0; i < nums.size(); i++)
        {

            // check if number is 0
            if (nums[i] == 0)
            {
                count = count - 1;
            }
            else
            {
                count = count + 1;
            }

            // checking if key is present
            if (h_map.find(count) != h_map.end())
            {
                maximum = max(maximum, i - h_map.at(count));
            }

            else
            {
                h_map.insert({count, i});
            }
        }

        return maximum;
    }
};