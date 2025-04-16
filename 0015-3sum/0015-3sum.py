class Solution:
    def __init__(self):
        self.res = []
        
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        for i in range(len(nums)):
            if nums[i] > 0:
                break

            if i == 0 or nums[i - 1] != nums[i]:
                self.twoSum(nums, i)
        return self.res

    def twoSum(self, nums: List[int], i: int):
        seen = set()
        j = i + 1

        while j < len(nums):
            complement = -nums[i] - nums[j]

            if complement in seen:
                self.res.append([nums[i], nums[j], complement])
                
                while j + 1 < len(nums) and nums[j] == nums[j + 1]:
                    j += 1

            seen.add(nums[j])
            j += 1