class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zero_count = 0
        zero_product = 1
        product = 1

        for i in nums:

            if i == 0 and zero_count == 0: 
                zero_count += 1 
                product *= i
                continue

            product *= i
            zero_product *= i
        
        answer = []
        for i in nums:

            if i == 0 and zero_count <= 1: 
                answer.append(zero_product)
                continue

            value = int(product / i)
            answer.append(value)

        return answer
        