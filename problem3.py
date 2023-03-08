# Time complexity : O(N) - because we have to iterate the length of the string and the size of the string can be at max N
# Space complexity : O(1) - since size of the character set fixed to lower/upper case characters. Its constant O(26). The size of the set can at max be 26 characters.
class Solution:
    def longestPalindrome(self, s: str) -> int:
        #Hashset Solution
        set1=set()
        count=0
        for i in s:
            if i not in set1:
                set1.add(i)
            else:
                count=count+2
                set1.remove(i)
        if len(set1)>0:
            count=count+1
        return count


        # # Hashmap Solution
        freq=collections.defaultdict(int)
        for x in s:
            freq[x]=freq[x]+1
        print(freq)
        count=0
        for item in freq:
            if freq[item]%2==0:
                count=count+freq[item]
                freq[item]=0
            
            if freq[item]%2==1:
                count=count+(freq[item]-1)
                freq[item]=1
        result= any(element == 1 for element in freq.values())
        if result:
            return count+1
        else:
            return count
        print(count)
