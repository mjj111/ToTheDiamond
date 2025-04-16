from bisect import bisect_left

class Solution:
    def find_start(self, nums: List[int]) -> int:
        start = 0
        end = len(nums) - 1

        while start < end:
            mid = (start + end) // 2
            if mid < len(nums) - 1 and nums[mid] > nums[mid + 1]:
                return mid + 1
            if mid > 0 and nums[mid] < nums[mid - 1]:
                return mid
            if nums[mid] >= nums[start]:
                start = mid + 1
            else:
                end = mid
        return start

    def search(self, nums: List[int], target: int) -> int:
        pivot = self.find_start(nums)

        if nums[pivot] <= target <= nums[-1]:
            idx = bisect_left(nums[pivot:], target)
            if pivot + idx < len(nums) and nums[pivot + idx] == target:
                return pivot + idx
        else:
            idx = bisect_left(nums[:pivot], target)
            if idx < pivot and nums[idx] == target:
                return idx

        return -1
