import com.sun.source.tree.BreakTree;

import java.util.HashMap;

public class subarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hMap =  new HashMap<>();
        hMap.put(0,1);
        int count = 0;
        int rSum = 0;
        for (int i=0; i<nums.length; i++){
            rSum+=nums[i];
            int y = rSum-k;
            if (hMap.containsKey(y)){
                count+= hMap.get(y);
            }
            if (!hMap.containsKey(rSum)){
                hMap.put(rSum,1);
            }
            else hMap.put(rSum,hMap.get(rSum)+1);
        }
        return count;
    }
}
