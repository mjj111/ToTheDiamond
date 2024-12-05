import heapq

def find(now):
    if now == parent[now]:
        return now

    parent[now] = find(parent[now])
    return parent[now]


def union(son1, son2):
    parent1 = find(son1)
    parent2 = find(son2)

    if parent1 < parent2: # parent1이 항상 크게
        parent1, parent2 = parent2, parent1

    parent[parent1] = parent2


n = int(input())
planets = [0 for _ in range(n)]
parent = [i for i in range(n)]

for i in range(n):
    x, y, z = map(int, input().split())
    planets[i] = (x, y, z, i)

xsort = sorted(planets, key=lambda x: x[0])
ysort = sorted(planets, key=lambda x: x[1])
zsort = sorted(planets, key=lambda x: x[2])

pq = []  # (cost, a, b)
for i in range(n - 1):
    heapq.heappush(pq, (abs(xsort[i][0] - xsort[i + 1][0]), xsort[i][3], xsort[i + 1][3]))
    heapq.heappush(pq, (abs(ysort[i][1] - ysort[i + 1][1]), ysort[i][3], ysort[i + 1][3]))
    heapq.heappush(pq, (abs(zsort[i][2] - zsort[i + 1][2]), zsort[i][3], zsort[i + 1][3]))

answer = 0
while pq:
    cost, a, b = heapq.heappop(pq)
    if find(a) == find(b): continue

    union(a, b)
    answer += cost

print(answer)