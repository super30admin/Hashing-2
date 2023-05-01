class Problem_3:

    def LongestPalindrome(self, str1):

        char_dict = dict()

        for i in str1:
            if i not in char_dict:
                char_dict[i] = 0

            char_dict[i]+=1


        allValues = list(char_dict.values())

        oneChar = 0

        max_length = 0

        for i in allValues:

            if (i % 2 == 0):
                max_length += i

            
            else:
                max_length += (i-1)

                oneChar = 1

        return max_length + oneChar

str = 'malayalam'
solution = Problem_3()
res = solution.LongestPalindrome(str)
output = print(res)