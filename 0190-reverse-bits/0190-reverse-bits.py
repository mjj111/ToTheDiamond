class Solution:
    def reverseBits(self, n: int) -> int:
        ret, power = 0, 31

        # power 만큼 이동한 값에서 1을 추출하여 ret에 추가하는 방식을 사용한다.
        # 즉 왼쪽부터 접근하여 1의 위치를 반전하는 것
        # 3 = 101 
        # 3&1 = 1
        # 3 >> 1 = 01

        while n:
            ret += (n & 1) << power
            n = n >> 1
            power -= 1
        return ret