# 합이 0인 네 정수
# https://www.acmicpc.net/problem/7453

from collections import defaultdict
import sys
input = sys.stdin.readline

n = int(input())
A, B, C, D = [], [], [], []

for _ in range(n):
  a, b, c, d = map(int, input().split())
  A.append(a)
  B.append(b)
  C.append(c)
  D.append(d)

sum_ab = defaultdict(int)

for a in A:
  for b in B:
    sum_ab[a + b] += 1

count = 0
for c in C:
  for d in D:
    count += sum_ab[-(c + d)]

print(count)