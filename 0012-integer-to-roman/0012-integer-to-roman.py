class Solution:
    def __init__(self):
        # 감산법 포함한 값들까지 모두 정리 (큰 수부터)
        self.roman_map = [
            (1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD'),
            (100, 'C'), (90, 'XC'), (50, 'L'), (40, 'XL'),
            (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'), (1, 'I')
        ]
    
    def intToRoman(self, num: int) -> str:
        return self.get_roman(num, 0)
    
    def get_roman(self, num: int, idx: int) -> str:
        if num == 0:
            return ''
        
        value, symbol = self.roman_map[idx]
        count = num // value
        return symbol * count + self.get_roman(num % value, idx + 1)