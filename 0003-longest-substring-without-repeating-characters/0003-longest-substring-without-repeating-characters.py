class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        number_set = set()
        left = 0  
        max_len = 0  
        
        for right in range(len(s)):
            while s[right] in number_set:
                number_set.remove(s[left])
                left += 1
                
            number_set.add(s[right])
            max_len = max(max_len, right - left + 1) 
            
        return max_len
