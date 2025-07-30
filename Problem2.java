import java.util.HashMap;
//We use a map to solve this. We store the running sum and the index sum occurred, if Map contains the rsum already then we find the length of the array using the index present in the map. we use a max variable to store the max length.
// TC is O(n) and SC is O(n)
public class Problem2 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int rSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum = rSum + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}
