import java.util.HashMap;

//TC=O(n)
//SC=O(n)
public class Problem525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        int maxSum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==1)
                runningSum++;
            else
                runningSum--;

            if(map.containsKey(runningSum))
                maxSum=Math.max(maxSum,i-map.get(runningSum));
            else
                map.put(runningSum,i);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Problem525 problem=new Problem525();
        System.out.println(problem.findMaxLength(new int[]{1,1,0,0,0,1,1,0}));
        System.out.println(problem.findMaxLength(new int[]{1,1,0,0,0,1,1,0,0,0,0,1,1}));
    }
}
