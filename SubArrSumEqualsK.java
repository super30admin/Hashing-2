// Brute force
public class SubArrSumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for(int l=0;l<nums.length;l++){
            int sum = 0;
            for(int r=l;r<nums.length;r++){
                sum += nums[r];
                if(sum==k){
                    res++;
                }
            }
        }        
        return res;
    }
}

// TC - O(n2)
// SC - O(n)

// Optmized
public class SubArrSumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum = 0, result = 0;
        for(int i=0;i<nums.length;i++){
            // calculate running sum
            rSum+=nums[i];
            if(map.containsKey(rSum-k)){
                result = result + map.get(rSum-k);
            }
            if(!map.containsKey(rSum)){
                map.put(rSum,0);
            }
            map.put(rSum, map.get(rSum)+1);
        }
        return result;
    }
}

// TC - O(n)
// SC - O()