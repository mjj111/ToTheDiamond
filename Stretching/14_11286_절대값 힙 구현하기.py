from heapq import heappush, heappop
n = int(input())

abs_heap = []
for i in range(n):
  num = int(input())
  if num:
    heappush(abs_heap, (abs(num), num))
  else:
    if abs_heap:
      print(heappop(abs_heap)[1])
    else:
      print(0)