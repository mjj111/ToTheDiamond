# 가장 긴 증가하는 부분 수열 2
# https://www.acmicpc.net/problem/12015

from bisect import bisect_left

n = int(input())
nums = list(map(int, input().split()))

lis = []
for num in nums:
  idx = bisect_left(lis, num)
  if idx == len(lis):
    lis.append(num)
  else:
    lis[idx] = num

print(len(lis))
