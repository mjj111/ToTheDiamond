import collections
import sys
sys.setrecursionlimit(10**5)

input = sys.stdin.readline
INF = float('inf')
MAX_LOG = 20

n = int(input())

parents = [[-1] * MAX_LOG for _ in range(n + 1)]
min_cost = [[INF] * MAX_LOG for _ in range(n + 1)]
max_cost = [[-INF] * MAX_LOG for _ in range(n + 1)]
depth = [-1] * (n + 1)

bridges = collections.defaultdict(list)
for _ in range(n - 1):
    start, end, cost = map(int, input().split())
    bridges[start].append((end, cost))
    bridges[end].append((start, cost))

def dfs(now, d, p, cost):
    depth[now] = d
    parents[now][0] = p
    min_cost[now][0] = cost
    max_cost[now][0] = cost

    for next, cost in bridges[now]:
        if depth[next] == -1:
            dfs(next, d + 1, now, cost)

dfs(1, 0, -1, 0)

def preprocess_lca():

    for pidx in range(1, MAX_LOG):
        for node in range(1, n + 1):
            if parents[node][pidx - 1] == -1: continue

            parents[node][pidx] = parents[parents[node][pidx - 1]][pidx - 1]
            min_cost[node][pidx] = min(min_cost[node][pidx - 1], min_cost[parents[node][pidx - 1]][pidx - 1])
            max_cost[node][pidx] = max(max_cost[node][pidx - 1], max_cost[parents[node][pidx - 1]][pidx - 1])

preprocess_lca()

def get_lca(left, right):
    if depth[left] < depth[right]: # 왼쪽이 항상 더 깊도록
        left, right = right, left

    for i in range(MAX_LOG - 1, -1, -1):
        if depth[left] - (1 << i) >= depth[right]:
            left = parents[left][i]

    if left == right:
        return left

    for i in range(MAX_LOG - 1, -1, -1):
        if parents[left][i] != parents[right][i]:
            left = parents[left][i]
            right = parents[right][i]

    return parents[left][0]

def get_min_max_cost(left, right):
    lca = get_lca(left, right)

    min_c = INF
    max_c = -INF

    for i in range(MAX_LOG - 1, -1, -1):
        if depth[left] - (1 << i) >= depth[lca]:
            min_c = min(min_c, min_cost[left][i])
            max_c = max(max_c, max_cost[left][i])
            left = parents[left][i]

    for i in range(MAX_LOG - 1, -1, -1):
        if depth[right] - (1 << i) >= depth[lca]:
            min_c = min(min_c, min_cost[right][i])
            max_c = max(max_c, max_cost[right][i])
            right = parents[right][i]

    return min_c, max_c

k = int(input())
for _ in range(k):
    start, end = map(int, input().split())
    min_cost_val, max_cost_val = get_min_max_cost(start, end)
    print(min_cost_val, max_cost_val)
