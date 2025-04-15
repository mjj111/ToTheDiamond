class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        num_map = {}  
        
        for i, number in enumerate(numbers):
            diff = target - number
            if diff in num_map:
                return [num_map[diff], i]
            num_map[number] = i
        
        return [0, 0] 
