//T.C: O(n) n: length of nums[].
//S.c: O(n) length of the hashMap.

/*Approach: i will iterate it through the nums[]. and keep track of zeros. 
if zero encountered then increment by 1. if not, then decrement by 1.
at each iteration i will add my zero count with the index if not present.
if at any time, my zero count is 0 then i will check get the value of the key(0) 
and update my resultant length by 1.
*/


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int zero = 0;
        int result = 0;
        map.put(0,0);

        for(int i = 0 ; i< nums.length; i++){
            
            if(nums[i] == 0) zero++;
            else{
                zero--;
            }

            if(zero == 0) result = i + 1;

            if(!map.containsKey(zero)) map.put(zero, i);
            else{
                result = Math.max(result, i - map.get(zero));
            }


        }

    return result;
    }
}