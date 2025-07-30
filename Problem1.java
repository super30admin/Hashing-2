import java.util.HashMap;
// To solve this we use a Map to track the no of times the running sum is generated. Once we know that we can use that to increase the count when ever a compliment of running sum - target is found in the map.
// TC is O(n) and SC is 0(n)
public class Problem1 {
    public int subarraySum(int[] nums, int k){
        int count = 0;
        int rsum = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0,1);
        for(int num : nums){
            rsum += num;
            int complimnet = rsum - k;
            if(countMap.containsKey(complimnet)){
                count += countMap.get(complimnet);
            }
            countMap.put(rsum, countMap.getOrDefault(rsum, 0)+1);
        }
        return count;
    }
}
