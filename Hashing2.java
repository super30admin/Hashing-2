class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0, rSum = 0;
        for (int i = 0; i < nums.length; i++){
            rSum = rSum + nums[i];
            if(map.containsKey(rSum-k)){
                count = count + map.get(rSum-k);
            }
            if(!map.containsKey(rSum)){
                map.put(rSum,0);
            }
            map.put(rSum, map.get(rSum)+1);
        }
        return count;
    }
}

// Brute Force- O(n^2)
/*class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}*/

class Solution {
    public int findMaxLength(int[] n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0, rSum = 0;
        for (int i = 0; i < n.length; i++){
            if(n[i] == 0){
                rSum = rSum - 1;
            }
            else {
                rSum = rSum + 1;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            else {
                map.put(rSum,i);
            }
        }
        return max;
    }
}
















/*Brute Force
class Solution {
    public int findMaxLength(int[] n) {
       int maxLength = 0;
for (int i = 0; i < n.length; i++){
    int zeroCount = 0, oneCount = 0;
    for (int j = i; j < n.length; j++){
        if(n[j] == 0)
        zeroCount++;
        else
        oneCount++;

    if(zeroCount == oneCount){
        int currLength =  j - i + 1;
        maxLength = Math.max(maxLength, currLength);
            }

}
}
return maxLength;
}
}*/


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count += 2;
                set.remove(ch);
            }
            else
                set.add(ch);
        }
        if(!set.isEmpty())
            count++;
        return count;
    }
}

