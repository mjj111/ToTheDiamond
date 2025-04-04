class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        now = max_subarray = nums[0]

        for num in nums[1:]:
            now = max(num, now + num)
            max_subarray = max(max_subarray, now)

        return max_subarray