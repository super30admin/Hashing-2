//Time Complexity O(N^2)
//Space Complexity O(1)
//Leetcode: Yes, but the brute force solutin timesout

public class ContiguousArrayLengthBinaryLeetcode509 {
    public int findMaxLength(int[] nums) {
        int end = nums.length;
        int count = 0;
        int max_len = 0;

        for (int i = 0; i < end; i++) {
            count = 0;
            for (int j = i; j < end; j++) {
                if (nums[j] == 0) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    max_len = Math.max(max_len, j-i + 1);
                }
            }
        }
        return max_len;
    }
}
