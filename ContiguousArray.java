//Tc = o(n)
//Sc = o(1)

import java.util.HashMap;

public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray obj = new ContiguousArray();

        int[] arr = { 0, 1, 1, 0, 0, 0, 1, 1, 1 };

        int obj1 = obj.search(arr);

        System.out.println(obj1);
    }

    public int search(int[] nums) {

        HashMap<Integer, Integer> Map = new HashMap<>();

        int Max = 0;
        Map.put(0, -1);
        int rSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {

                rSum--;
            } else {
                rSum++;
            }
            if (Map.containsKey(rSum)) {
                Max = Math.max(Max, i - Map.get(rSum));
            } else {
                Map.put(i, rSum);
            }
        }
        return Max;
    }

}