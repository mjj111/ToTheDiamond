'''
백준 1854번 K번째 최단 경로 찾기
distance를 만들고, 거리와 비용을 비교해서 갱신한다.

여기서 재밌는 점은,
가장 먼저 접근하여 비용을 갱신한다면 가장 적은 비용으로 접근하는 것임을 의미하기에
똑같은 노드에 접근하더라도 이전 접근이 최선이다.

'''
import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, M, K = map(int, input().split())
W = [[] for _ in range(N + 1)]

INF = float('inf')
distance = [[INF] * K for _ in range(N+1)]

for _ in range(M):
  a, b, c = map(int, input().split())
  W[a].append((b, c))

pq = [(0, 1)]
distance[1][0] = 0

while pq:
  cost, node = heappop(pq)

  for nNode, nCost in W[node]:
    sCost = cost + nCost

    if distance[nNode][K-1] > sCost:
      distance[nNode][K-1] = sCost
      distance[nNode].sort()
      heappush(pq, [sCost, nNode])

for i in range(1, N+1):
  if distance[i][K-1] == INF:
    print(-1)
  else:
    print(distance[i][K-1])