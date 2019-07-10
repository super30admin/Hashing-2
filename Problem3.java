//Time Complexity :  O(n) for char storage plus O(n) for char array loop for the Brute Force. method longestPalindrome.   
//Space Complexity : O(1) for the Brute Force. method longestPalindrome.   
//Did this code successfully run on Leetcode : Yes 
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach 
// this is the greedy approach , where  we count number of char in the given array and store them in the char array.
// if the number / 2*2   == 1  --> it is the center element  and same way number/2*2 == 0 --> it is the  number element side by side of center.
// if both condition satisfies, we will increment the ans and return it.

class Solution3 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}

public class Problem3 {
	
	public static void main(String[] args) {
		String input = "aaabaaa";

		Solution3 s = new Solution3();
		System.out.println(s.longestPalindrome(input));
	}

}
