//Problem 1 - SubArray Sum Equals K
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem


// Your code here along with comments explaining your approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        map.put(0,1);
        int sum=0,res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int cmp = sum-k; //compliment
            if(map.containsKey(cmp)) //check if compliment is present. if yes means subarray sum=k exists
                res+=map.get(cmp); //check number of occurrences of that subarray sum.
            
            // if(map.containsKey(sum))
            //     map.put(sum,map.get(sum)+1);
            // else
            //     map.put(sum,1);
            map.put(sum,map.getOrDefault(sum,0)+1); // check if sum is present, add occurrence, if not add sum,1
        }
        return res;
    }
}

//Problem 2 - Contigious Array
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem


// Your code here along with comments explaining your approach
class Solution {
    public int findMaxLength(int[] nums) {
       Map<Integer, Integer> map= new HashMap<>();
       map.put(0,-1);
        int rSum=0;
        int max=0;
        //int start=0,end=0; //check if max has changed, max is actually changed then count start and end
       for(int i=0;i<nums.length;i++){
           if(nums[i]==0)
            rSum--;    //denoted amount to 0 is rowSum-1
            else
                rSum++;
            
            if(map.containsKey(rSum)){  //check if map already contains current rowSum
                max=Math.max(i-map.get(rSum), max); //if yes, get current contigious array length with current - earlier similar RowSum. Take maximum
            }
            else
                map.put(rSum,i); // if not present, add it to map 
       }
       return max; 
    }
}

//Problem 3 - Longest Palindrome
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        //with hashmap
        // HashMap<Character, Integer> map=new HashMap<>();
        // int total=0;
        // for(int i=0;i<s.length();i++){
        //     if(map.containsKey(s.charAt(i))){
        //         total+=2;
        //         map.remove(s.charAt(i));
        //     }
        //     else
        //         map.put(s.charAt(i),1);
        // }
        // if(map.size()>0)
        //     return total+1;
        // return total;

        //with array
        // int[] count = new int[256];
        // int odds = 0;
        // for (int v = 0; v < s.length(); v++) {
        //     char currChar = s.charAt(v);
        //     count[currChar] += 1;
        //     odds += (count[currChar] & 1) == 1 ? 1 : -1;
        // }
        // return s.length() - odds + (odds > 0 ? 1 : 0);

        //with hashSet
        Set<Character> set=new HashSet<>(); 
        int count=0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){ 
                count+=2; //if element already present, add our count with 2(2 elements) and remove that element for further even element check
                set.remove(s.charAt(i));
            }
            else
                set.add(s.charAt(i)); // if not present, add it to array.
        }
        if(set.isEmpty()) 
            return count;
        return count+1;//if set not empty -> set has single element so any one can be added to palindrome to act as middle element
    }

    
}