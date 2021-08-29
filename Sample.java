// Time Complexity : O(n)
// Space Complexity : O(n)


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hashset =  new HashSet<>();
        int counter = 0;
        for (int i = 0; i< s.length(); i++){
            char temp = s.charAt(i);
            if(hashset.contains(temp)){
                hashset.remove(temp);
                counter+=2;
            }
            else{
                hashset.add(temp);
            }

        }

        if (hashset.isEmpty()){
            return counter;
        }
        return counter+1;
    }
    // Time Complexity : O(n)
// Space Complexity : O(n)
    public int findMaxLength(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        map.put(0,-1);

        for(int i = 0; i<nums.length; i++){
            if (nums[i] == 0){
                count--;
            }
            else{
                count++;
            }
            if(map.containsKey(count)){
                max = Math.max(max,i - map.get(count));

            }
            else{
                map.put(count,i);
            }

        }
        return max;

    }

    // Time Complexity : o(n)
    // Space Complexity : o(n)

    public int subarraySum(int[] nums, int k) {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length ==0 ) return 0;
            int count = 0;
            int returnInt = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);

            for (int i = 0; i < nums.length; i++){
                count+= nums[i];
                if (map.containsKey(count-k)){
                    returnInt = returnInt + map.get(count-k);
                }
                if(map.containsKey(count)){
                    map.put(count,map.get(count)+1);

                }
                else{
                    map.put(count,1);
                }


            }
            return returnInt;

        }
    }
}