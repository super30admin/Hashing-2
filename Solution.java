import java.util.*;

class Solution {
    // TC: O(n) SC: O(n)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int rSum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum = rSum + nums[i];
            if (map.containsKey(rSum - k))
                cnt += map.get(rSum - k);
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        return cnt;
    }

    // TC: O(n) SC: O(n)
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int rsum = 0;
        int max1 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                rsum -= 1;
            else
                rsum += 1;
            if (!map.containsKey(rsum))
                map.put(rsum, i);
            else
                max1 = Math.max(max1, i - map.get(rsum));
        }
        return max1;
    }

    // TC: O(n) SC: O(k)
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                count += 2;
                hs.remove(s.charAt(i));
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) {
            count += 1;
        }
        return count;
    }
}