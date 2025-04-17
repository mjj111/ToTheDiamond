from collections import defaultdict, deque, Counter
from itertools import permutations, combinations
from heapq import heappush, heappop, heapify
#
# n = 3
# visited = 0  # 초기값 수정
#
# visited |= 1 << 2
# visited |= 1 << 1
# visited |= 1 << 0
#
# if visited & (1 << n) - 1:
#   print("굿")  # 올바르게 출력됨
#
# tmp = ['1','2']
# print("".join(tmp))
# '123'.startswith('1')
#
# for i,t in enumerate(tmp):
#   a = 2
#
# for key, value in {1:2}:
#   print(key)
#   print(value)