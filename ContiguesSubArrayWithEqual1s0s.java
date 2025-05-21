//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: compute running sum for all elements (+1 if 1 and -1 if 0) in the array. 
// IF running sum repeats the elements within the similar sum values is balanced
//maintain hashmap to store sum values and index it was first seen at(coz we want longest length palindrome)
import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                sum += 1;
            else
                sum-=1;
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            else{
                maxLength = Math.max(maxLength, i-map.get(sum));
            }
        }
        return maxLength;
    }
}
