import sys
input = sys.stdin.readline
INF = float('inf')

def bellman_ford(N, M, edges):
  distance = [INF] * (N + 1)
  distance[1] = 0

  for i in range(N - 1):
    for u, v, cost in edges:
      if distance[u] != INF and distance[u] + cost < distance[v]:
        distance[v] = distance[u] + cost

  for u, v, cost in edges:
    if distance[u] != INF and distance[u] + cost < distance[v]:
      return -1

  return distance

def main():
  N, M = map(int, input().split())

  edges = []
  for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

  result = bellman_ford(N, M, edges)

  if result == -1:
    print(-1)
  else:
    for i in range(2, N + 1):
      if result[i] == INF:
        print(-1)
      else:
        print(result[i])

if __name__ == "__main__":
  main()
