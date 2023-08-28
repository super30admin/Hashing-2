import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
public class ContiguousArray {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        int result = findMaxLength(arr);
        System.out.println("Max Length :: " + result);
    }

    /**
     * @param arr
     * @return max length of balanced sub array
     */
    private static int findMaxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int runningSum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                runningSum = runningSum + 1;
            else
                runningSum = runningSum - 1;

            if (map.containsKey(runningSum)) {
                max = Math.max(max, i - map.get(runningSum));

            } else {

            }
        }
        return max;
    }
}