class Solution:
    def hammingWeight(self, n: int) -> int:
        s = 0
        while n != 0:
            s += 1
            n &= (n-1)
        return s
        
        #110100 에서 1을 빼면 110011이 된다.
        # 이를 and연산해주면 110000이 된다!
