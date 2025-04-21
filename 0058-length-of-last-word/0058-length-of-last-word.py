class Solution:
    def lengthOfLastWord(self, s: str) -> int:
         return list(map(len,list(s.split())))[-1]