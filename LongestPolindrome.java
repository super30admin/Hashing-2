//Tc = O(n)
//SC = O(1)

import java.util.HashSet;

public class LongestPolindrome {

    public static void main(String[] args) {

        String s = "abccccdd";

        LongestPolindrome obj = new LongestPolindrome();

        int obj1 = obj.search(s);

        System.out.println("value" + obj1);

    }

    public int search(String s) {
        int count = 0;
        HashSet<Character> str = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (str.contains(c)) {

                count += 2;

                str.remove(c);

            } else {
                str.add(c);
            }
        }
        if (!str.isEmpty())
            count++;

        return count;

    }

}