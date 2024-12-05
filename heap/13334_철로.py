import sys
import heapq

input = sys.stdin.readline

n = int(input())

locations = []
for _ in range(n):
    a, b = map(int, input().split())
    end = max(a,b)
    start = min(a,b)
    locations.append([start, end])

d = int(input())

locations.sort(key=lambda x: (x[1], x[0]))

heap = []
max_cnt = 0

for location in locations:
    start, end = location

    heapq.heappush(heap, start)
    line_start = end - d

    while heap and heap[0] < line_start:
        heapq.heappop(heap)
    max_cnt = max(max_cnt, len(heap))

print(max_cnt)