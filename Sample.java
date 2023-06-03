//Longest Palindrome
//Time Complexity - O(n)
//Space Complexity - O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Hashset syntax



// Used hash set and used the cut down approach (Whenever palindrome check for even occurances)

class Solution {
    public int longestPalindrome(String s) {

        int count =0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(set.contains(c))
            {
                count+=2;
                set.remove(c);
            }
            else{
                set.add(c);
            }



        }
        if(!set.isEmpty())
        count++;
        return count;
    }
}


//Contigous Array
//Time Complexity - O(n)
//Space Complexity - O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : The logic is well written in notes

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);   // adding the first map value with sum zero and index -1

        int rSum = 0;  //running sum
        int max = 0;   // maximum length
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            rSum--;    // decreasing the value if we find one
            else
            rSum++;   // increasing the value if we find zero
            if(map.containsKey(rSum))
            {
                max = Math.max(max,i-map.get(rSum));  // we grab the maximum value by subtracting earliest index and current index of the same key and get the maximum between max and the calucalated value when we find the same key 
            }
            else
            {
                map.put(rSum,i);  // we put the new rSum found with it's first occurence index.
            }
        }
        return max;
    }
}


//Subarray Sum Equals K
//Time Complexity - O(n)
//Space Complexity - O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : The logic is good and need to see in notes


class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum=0;
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            rSum+=nums[i];
            if(map.containsKey(rSum-k))
            {
                result=result+ map.get((rSum-k));

            }
            if(!map.containsKey(rSum))
            {
                map.put(rSum, 0);
            }

            map.put(rSum, map.get(rSum)+1);
        }
        return result;
        
    }
}

