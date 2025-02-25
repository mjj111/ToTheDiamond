n = int(input())
numbers = [[] for _ in range(n)]
visited = [False] * (n)
D = [0] * (n)
lcm = 1

def gcd(a, b):
  if b ==0:
    return a
  else:
    return gcd(b, a % b)

def DFS(v):
  visited[v] = True
  for i in numbers[v]:
    next = i[0]
    if not visited[next]:
      D[next] = D[v] * i[2] // i[1]
      DFS(next)

for i in range(n - 1):
  a, b, p, q = map(int, input().split())
  numbers[a].append((b, p, q))
  numbers[b].append((a, q, p))
  lcm *= (p * q // gcd(p, q))

D[0] = lcm
DFS(0)
mgcd = D[0]

for i in range(1, n):
  mgcd = gcd(mgcd, D[i])

for i in range(n):
  print(int(D[i] // mgcd), end=' ')