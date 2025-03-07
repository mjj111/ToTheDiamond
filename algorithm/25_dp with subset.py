'''
백준 14567번 선수과목
'''
import sys
from collections import deque

input = sys.stdin.readline

# 입력 받기
n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]  # 선수 과목 관계
indegree = [0] * (n+1)  # 진입 차수
semester = [1] * (n+1)  # 최소 학기 (기본적으로 1학기)

# 선수 과목 정보 입력
for _ in range(m):
  a, b = map(int, input().split())
  adj[a].append(b)  # a -> b (a를 들어야 b를 들을 수 있음)
  indegree[b] += 1  # b의 선수 과목 개수 증가

# 위상 정렬 (BFS)
queue = deque()

# 선수 과목이 없는 과목(진입 차수 0)부터 시작
for i in range(1, n+1):
  if indegree[i] == 0:
    queue.append(i)

while queue:
  cur = queue.popleft()

  for next in adj[cur]:
    indegree[next] -= 1  # 선수 과목 하나 해결됨
    if indegree[next] == 0:
      queue.append(next)
    semester[next] = max(semester[next], semester[cur] + 1)

# 결과 출력
print(*semester[1:])
