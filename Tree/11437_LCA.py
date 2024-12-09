import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline
MAX_DEPTH = 21 # 최대 깊이

n = int(input())
parent = [[0] * MAX_DEPTH for _ in range(n + 1)] # parent[a][b] = c  / a노드의 b번쨰 조상노드 번호 c
visited = [False] * (n + 1)
d = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(x, depth):
    visited[x] = True
    d[x] = depth

    for node in graph[x]:
        if visited[node]:
            continue
        parent[node][0] = x
        dfs(node, depth + 1)


def set_parent():
    dfs(1, 0)
    for i in range(1, MAX_DEPTH):
        for j in range(1, n + 1):
            parent[j][i] = parent[parent[j][i - 1]][i - 1]

def lca(a, b) :
    if d[a] > d[b] :
        a, b = b, a

    for i in range(MAX_DEPTH - 1, -1, -1) :
        if d[b] - d[a] >= 2**i :
            b = parent[b][i]

    if a == b :
        return a

    for i in range(MAX_DEPTH - 1, -1, -1) :
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    return parent[a][0]

set_parent()

m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    print(lca(a, b))