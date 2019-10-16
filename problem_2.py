"""
Approach : find(a[1:N]) = max(find(a[2:N]) , find_from_start(a, 2, (a[1] == 1) - (a[1] == 0))

find from start is the maximum contiguaous subset starting from the start index

This solution does not work on leet code. I get a timeout exception

Time compexity O(n^2)
Space Complexity O(n)

"""



class Solution(object):
    
    cache = {}
    
    def find(self,arr,start) :
        if start >= len(arr) :
            return 0
        r1 = self.find_from_start(arr,start,0)
        r2 = self.find(arr,start+1)
        return max(r1,r2)


    def put_in_cache(self,start,delta,result):
        
        if self.cache.get(start) == None :
            self.cache[start] = {}
        
        if self.cache[start].get(delta) == None :
            self.cache[start][delta] = result
        
        return result
        
        

    def find_from_start(self,arr,start,delta) : 
        if (self.cache.get(start) != None) and (self.cache[start].get(delta) != None)  :
            return self.cache[start][delta]
        
        if start >= len(arr) :
            return self.put_in_cache(start,delta,0)
        delta_new = delta + (1 if arr[start] == 1 else -1)
        sub_result = self.find_from_start(arr,start+1,delta_new) if (len(arr) - abs(delta_new) - start) > 0 else 0
        if sub_result > 0 :
            return self.put_in_cache(start,delta,1 + sub_result)
        if delta_new == 0 :
            return self.put_in_cache(start,delta,1)
        return self.put_in_cache(start,delta,0)


    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.cache = {}
        return self.find(nums,0)
