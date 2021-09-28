public class Problem1 {

    public static int subarraySum(int[] nums, int k) { // brute force
        if(nums.length == 1)    return k == nums[0] ? 1 : 0;
        int sum, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k)    ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2)); // 2
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 1)); // 1
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0)); // 3
    }
}
