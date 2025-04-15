from collections import Counter
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        dic = Counter(nums)
        for v in dic.values():
            if v >= 2: return True
        return False