
import java.util.HashMap;

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int ans = 0;
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
            } else {
                count--;
            }

            if(map.containsKey(count)) {
                ans = Math.max(ans, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ContiguousArray sol = new ContiguousArray();

        int[] nums = {0, 1, 0, 1, 0, 1, 1};
        int result = sol.findMaxLength(nums);
        System.out.println("Maximum length of a contiguous subarray with equal number of 0 and 1: " + result);
    }
}
