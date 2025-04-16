class Solution:
    def countBits(self, n: int) -> List[int]:
    
        def pop_count(x: int) -> int:
            count = 0
            while x != 0:
                x &= x - 1 
                count += 1
            return count
            
        ans = []
        for x in range(n + 1):
            ans.append(pop_count(x))
    
        return ans                                