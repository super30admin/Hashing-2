// Time Complexity : O(n)
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No 

//  Your code here along with comments explaining your approach :i did this using hashset
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                length += 2;
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            length += 1;
        }

        return length;

    }
}

//////////////////////////
///
///
/// //time complexity : O(n)
/// //space complexity : O(n )
/// //did this code successfully run on leetcode : yes
/// //any problem you faced while coding this : no
///
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixcount = new HashMap<>();
        int currentsum = 0;
        int count = 0;
        prefixcount.put(0, 1); // Initialize with sum 0 at index -1 (before array starts)

        for (int num : nums) {
            currentsum += num; // Update running sum
            int needed = currentsum - k; // Sum needed to form subarray summing to k
            if (prefixcount.containsKey(needed)) {
                count += prefixcount.get(needed); // Add count of subarrays ending at current index
            }
            // Always update hash map with current sum
            prefixcount.put(currentsum, prefixcount.getOrDefault(currentsum, 0) + 1);
        }
        return count;
    }
}



//////////////////////
/// 
/// 
/// 
/// 
/// //time complexity : O(n)
/// //space complexity : O(n)
/// //did this code successfully run on leetcode : yes
/// //any problem you faced while coding this : no
/// 
///
/class Solution {
public int findMaxLength(int[] nums) {

    Map<Integer, Integer> freqmap = new HashMap<>();
    freqmap.put(0, -1);
    int maxlength = 0;
    int currentsum = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            currentsum = currentsum - 1;
        } else {
            currentsum = currentsum + 1;
        }
        if (freqmap.containsKey(currentsum)) {
            int previndex = freqmap.get(currentsum);
            int length = i - previndex;
            maxlength = Math.max(maxlength, length);
        } else {
            // First time seeing this running sum, store it with current index
            freqmap.put(currentsum, i);
        }

    }
    return maxlength;

}
}