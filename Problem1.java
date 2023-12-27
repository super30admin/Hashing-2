//Accepted on leetcode
// So i did solve this with brute force O(n^2) than in the class learned this new approach of running sum and mixing it with hashmap
//Time should be O(n), space should be O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        hm.put(0,1);

  
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            int p = sum - k;
            if(hm.containsKey(p)){
                count = count + hm.get(p);

            }
            if(hm.containsKey(sum)){
                    int x = hm.get(sum);
                    hm.put(sum,x+1);
                    
                }
            else{
                hm.put(sum,1);
            }

        }


        return count;
        
    }
}