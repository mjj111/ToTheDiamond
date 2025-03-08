'''
백준 11657번 타임머신으로 빨리 가기

큰 값을가진 노드 크기만큼의 distance를 만들어준다.
노드 크기만큼 반복하여,
만약 start가 접근된 상태에 값이 싸다면 목적지를 갱신

엣지 만큼 한 번더 반복할 떄, 갱신되면 사이클이 있음을 의미한다.
모든 갱신을 마쳤음에도 불구하고 한 번도 동작시킬 때, 갱신된다면 사이클이 있다는 것이다.
'''
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
edges = []
distance = [sys.maxsize]*(N + 1)

for i in range(M):
  start, end, time = map(int, input().split())
  edges.append((start, end, time))

distance[1] = 0

for _ in range(N - 1):
  for start, end, time in edges:
    if distance[start] != sys.maxsize and distance[end] > distance[start] + time:
      distance[end] = distance[start] + time

mCycle = False

for start, end, time in edges:
  if distance[start] != sys.maxsize and distance[end] > distance[start] + time:
    mCycle = True

if not mCycle:
  for i in range(2, N + 1):
    if distance[i] != sys.maxsize:
      print(distance[i])
    else:
      print(-1)
else:
  print(-1)