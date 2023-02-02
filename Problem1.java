import java.util.HashMap;
import java.util.Map;

//time: O(n)
//space: O(n)
public class Problem1 {
    public int subarraySum(int[] nums, int k) {

        int rsum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            int currEle = nums[i];
            rsum+=currEle;
            int diff = rsum-k;
            if(map.containsKey(diff)){
                count = count+ map.get(diff);

            }
            if(!map.containsKey(rsum)){
                map.put(rsum, 0);
            }
            map.put(rsum, map.get(rsum)+1);

        }
        return count;
    }
}