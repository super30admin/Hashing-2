import java.util.HashMap;
//TC=O(n)
//SC=O(n)

public class Problem560 {
    public int subarraySum(int[] nums, int k) {
        int runningSum=0;
        int counter=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            if(map.containsKey(runningSum-k))
                counter=counter+map.get(runningSum-k);
            map.put(runningSum,map.getOrDefault(runningSum,0)+1);
        }
        return counter;
    }

    public static void main(String[] args) {
        Problem560 problem=new Problem560();
        System.out.println(problem.subarraySum(new int[]{3,4,7,2,-3,1,4,2,0,1},7));
    }
}
