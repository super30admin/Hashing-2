//T.C: O(n) n: length of nums[].
//S.c: O(n) length of the hashMap.

/*Approach: Here i am using hashMap to store Current Sum with the count. 
At each iteration i will check i i have currrentSum - k in the map. if it exist then 
i will add its count to the result. if not then i will put the value in map.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int curSum = 0;
        int count = 0;

        map.put(0,1);


        for(int i = 0; i < nums.length ; i++){
            curSum += nums[i];

            if(map.containsKey(curSum - k)){
                count += map.get(curSum - k); 
            }

            if(map.containsKey(curSum)){
                map.put(curSum, map.get(curSum+1));
            }else{
                map.put(curSum,1);
            }
        }

    return count;    
    }
}