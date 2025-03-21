'''
백준 14567번 선수과목
'''
import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)
semester = [1] * (n+1)  # 최소 학기 (기본적으로 1학기)

for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  indegree[b] += 1

queue = deque()
for i in range(1, n+1):
  if indegree[i] == 0:
    queue.append(i)

while queue:
  cur = queue.popleft()

  for next in graph[cur]:
    indegree[next] -= 1
    if indegree[next] == 0:
      queue.append(next)
    semester[next] = max(semester[next], semester[cur] + 1)

print(*semester[1:])
