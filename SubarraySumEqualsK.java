//Time Complexity = 0(n)
//space Complexity 0(N)
import java.util.HashMap;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        // hmap.put(nums[0],1);
        int rsum = 0;
        int value = 0;
        int totalCount =0;
        for(int i = 0; i<nums.length; i++)
        {
            //base
            rsum = rsum + nums[i];
            value = rsum - k;
            if(hmap.containsKey(value)){
                totalCount = totalCount+ hmap.get(value);
            }
            if(hmap.containsKey(rsum))
            {
                int ncount = hmap.get(rsum);
                hmap.put(rsum, ncount+1);
            }
            else{
                hmap.put(rsum, 1);
            }
        }
        System.out.println(hmap);
        return totalCount;
    }
}