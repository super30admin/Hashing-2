// Time Complexity : O(n)
// Space Complexity : O(n)
import java.util.*;
public class Problem2 {
    static int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0, -1);

        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                sum += 1;
            } else {
                sum -= 1;
            }
            if(map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum , i);
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println("Maximum length of Contigous array: "+ findMaxLength(nums) );
    }

}
