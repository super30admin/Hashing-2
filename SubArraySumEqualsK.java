//tc=O(n)
//sc=O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
    int total = 0;
    if (nums == null || nums.length ==0) {
        return total;
    }
    int rSum = 0;    
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(rSum, 1);
    for (int i = 0; i < nums.length; i++) {
        rSum = rSum + nums[i];
        int lookUp = rSum - k;
        if (map.containsKey(lookUp)) {
            total = total + map.get(lookUp);
        }
        map.put(rSum, map.getOrDefault(rSum, 0) +1 );
    }
    return total;
        
    }
}