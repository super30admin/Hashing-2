//TC:- On
//SC:-O(1)
import java.util.HashMap;

public class kSumSubarray {
    public static void main(String[] args) {
        subarraySum(new int[]{1,1,1},2);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int rsum = 0;
        hm.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rsum = rsum + nums[i];
            if (hm.containsKey(rsum - k)) {
                count = count + hm.get(rsum - k);
            }
            if (hm.containsKey(rsum)) {
                int newCount = hm.get(rsum);

                newCount++;

                hm.put(rsum, newCount);


            } else {
                hm.put(rsum, 1);
            }
        }
        System.out.println(count);
        return count;
    }
}
