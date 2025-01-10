import heapq, sys
input = sys.stdin.readline

N = int(input())
problems = []

for _ in range(N):
  deadLine, numOfRamen = map(int,input().split())
  problems.append((deadLine, numOfRamen))

problems.sort(key=lambda x: (x[0], -x[1]))

select = []
for deadLine, numOfRamen in problems:
  if len(select) < deadLine:
    heapq.heappush(select, numOfRamen)
  else:
    if select[0] < numOfRamen:
      heapq.heappop(select)
      heapq.heappush(select, numOfRamen)

print(sum(select))
